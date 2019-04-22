package ui.coordinator;


import control.UIController;
import memento.CareTaker;
import memento.Memento;
import booking.Booking;
import booking.BookingComposite;
import reservation.Hotel;
import routeCalculation.Airport;
import routeCalculation.Route;
import ui.controller.*;
import ui.view.HotelSearchFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class MainMenuCoordinator extends BaseCoordinator implements IMainMenuCoordinator {

    @Override
    public void start() {
        MainMenuFrameController mainMenu = new MainMenuFrameController(this);
        setViewController(mainMenu);
    }

    @Override
    public void logout() {
        int x = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you wish to log out?",
                "Logout", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (x == JOptionPane.YES_NO_OPTION) {
            ILoginCoordinator loginCoordinator = new LoginCoordinator();
            loginCoordinator.start();
            setViewController(null);
            UIController.shared.logout();
        }
    }

    @Override
    public void goToFlightSearch() {
        FlightSearchFrameController flightSearch = new FlightSearchFrameController(this);
        setViewController(flightSearch);
    }

    public void goBackToFlightSearch() {
        FlightSearchFrameController flightSearch = new FlightSearchFrameController(this);
        setViewController(flightSearch);
    }

    @Override
    public void goToFlightSearchResults(ArrayList<Route> results) {
        FlightSearchResultsController flightSearchResults = new FlightSearchResultsController(this, results);
        setViewController(flightSearchResults);
    }
    
    @Override
    public void goToHotelSearchResults(ArrayList<Route> routes) {
        HotelSearchResultsController hotelSearchResults = new HotelSearchResultsController(this, routes);
        setViewController(hotelSearchResults);
    }

    @Override
    public void goToBookingConfirmScreen(Booking reservations) {
        BookingCheckoutController bookingCheckoutController = new BookingCheckoutController(this, reservations);
        setViewController(bookingCheckoutController);
    }
}
