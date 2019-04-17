package ui.coordinator;

import booking.BookingComposite;
import reservation.Hotel;
import routeCalculation.Airport;
import routeCalculation.Route;

import java.util.ArrayList;

public interface IMainMenuCoordinator {
    void start();
    void logout();
    void goToFlightSearch();
    void goToFlightSearchResults(ArrayList<Route> results);
    void goToHotelSearchResults(ArrayList<Route> routes);
    void goToBookingConfirmScreen(BookingComposite reservations);
}
