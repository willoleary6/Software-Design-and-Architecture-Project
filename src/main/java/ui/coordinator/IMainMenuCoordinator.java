package ui.coordinator;

import routeCalculation.Airport;
import routeCalculation.Route;

import java.util.ArrayList;

public interface IMainMenuCoordinator {
    void start();
    void logout();
    void goToFlightSearch();
    void goBackToFlightSearch();
    void goToFlightSearchResults(ArrayList<Route> results);
    void goToHotelSearchResults(Airport destination);
}
