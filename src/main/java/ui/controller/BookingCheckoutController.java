package ui.controller;

import booking.BookingComposite;
import booking.FlightBooking;
import booking.HotelBooking;
import reservation.Hotel;
import routeCalculation.Route;
import ui.coordinator.IMainMenuCoordinator;
import ui.model.BookingCheckoutTableModel;
import ui.view.BookingCheckoutFrame;

import javax.swing.*;
import java.util.ArrayList;

public class BookingCheckoutController extends BaseFrameController {
    private JTable BookingCheckoutTable;
    private JButton MainMenuButton;
    private JButton ConfirmBookingButton;
    private IMainMenuCoordinator coordinator;
    private BookingComposite reservations;

    public BookingCheckoutController(IMainMenuCoordinator coordinator, ArrayList<Route> routes) {
        this.coordinator = coordinator;
        initialiseComposite(routes);
        initComponents();
        //initListeners();
    }

    public BookingCheckoutController(IMainMenuCoordinator coordinator, ArrayList<Route> routes, Hotel selectedHotel) {
        this.coordinator = coordinator;
        initialiseComposite(routes, selectedHotel);
        initComponents();
        //initListeners();
    }


    private void initComponents() {
        BookingCheckoutFrame bookingCheckoutFrame = new BookingCheckoutFrame();
        this.frame = bookingCheckoutFrame;
        ConfirmBookingButton = bookingCheckoutFrame.getConfirmBookingButton();
        MainMenuButton = bookingCheckoutFrame.getMainMenuButton();
        BookingCheckoutTable = bookingCheckoutFrame.getBookingCheckoutTable();

        BookingCheckoutTableModel tableModel = new BookingCheckoutTableModel(reservations);
        BookingCheckoutTable.setModel(tableModel);

    }

    private void initialiseComposite(ArrayList<Route> routes){
        reservations = new BookingComposite();
        for(Route route: routes){
            reservations.addChildBooking(new FlightBooking(route));
        }
    }

    private void initialiseComposite(ArrayList<Route> routes, Hotel selectedHotel){
        HotelBooking test = new HotelBooking(selectedHotel);
        reservations = new BookingComposite();
        //for(Route route: routes){
          //  reservations.addChildBooking(new FlightBooking(route));
        //}

        //todo move composite creation back
        for(int i = 0; i < routes.size(); i++){
            FlightBooking newBooking = new FlightBooking(routes.get(i));
            if(i == routes.size()-1){
                newBooking.addChildBooking(test);
            }
            reservations.addChildBooking(newBooking);

        }

    }
}
