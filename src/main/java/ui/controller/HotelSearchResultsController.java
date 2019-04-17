package ui.controller;

import booking.BookingComposite;
import booking.FlightBooking;
import booking.HotelBooking;
import reservation.Hotel;
import routeCalculation.Airport;
import routeCalculation.Route;
import ui.coordinator.IMainMenuCoordinator;
import ui.model.HotelSearchModel;
import ui.view.HotelSearchFrame;

import javax.swing.*;
import java.util.ArrayList;

public class HotelSearchResultsController extends BaseFrameController {
    private IMainMenuCoordinator coordinator;
    private ArrayList<Route> routes;
    private HotelSearchModel model;
    private JTable hotelTable;
    private JButton cancelButton;
    private JButton bookHotelButton;
    private BookingComposite reservations;

    public HotelSearchResultsController(IMainMenuCoordinator coordinator,  ArrayList<Route> routes) {
        this.routes = routes;
        this.coordinator = coordinator;
        this.model = new HotelSearchModel(routes.get(routes.size()-1).getDestination());
        initComponents();
        initListeners();
    }

    private void initialiseComposite(ArrayList<Route> routes, Hotel selectedHotel){
        HotelBooking test = new HotelBooking(selectedHotel);
        reservations = new BookingComposite();
        for(int i = 0; i < routes.size(); i++){
            FlightBooking newBooking = new FlightBooking(routes.get(i));
            if(i == routes.size()-1){
                newBooking.addChildBooking(test);
            }
            reservations.addChildBooking(newBooking);

        }
    }

    private void initComponents() {
        HotelSearchFrame hotelFrame = new HotelSearchFrame();
        this.frame = hotelFrame;
        this.hotelTable = hotelFrame.getHotelTable();
        this.cancelButton = hotelFrame.getCancelButton();
        this.bookHotelButton = hotelFrame.getBookHotelButton();
        this.hotelTable.setModel(model.getTableModel());
    }

    private void initListeners() {
        cancelButton.addActionListener(e -> coordinator.goToFlightSearchResults(routes));
        bookHotelButton.addActionListener(e -> {
            try {
                Hotel selectedHotel = (Hotel) hotelTable.getValueAt(hotelTable.getSelectedRow(), -1);
                initialiseComposite(routes, selectedHotel);
                coordinator.goToBookingConfirmScreen(reservations);
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "No Hotel selected.");
            }
        });
    }
}
