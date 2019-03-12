package ui.coordinator;


import routeCalculation.Airport;
import routeCalculation.Route;
import ui.controller.FlightSearchFrameController;
import ui.controller.FlightSearchResultsController;
import ui.controller.HotelSearchResultsController;
import ui.controller.MainMenuFrameController;
import ui.view.HotelSearchFrame;

import javax.swing.*;
import java.util.ArrayList;

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
        }
    }

    @Override
    public void goToFlightSearch() {
        FlightSearchFrameController flightSearch = new FlightSearchFrameController(this);
        setViewController(flightSearch);
    }

    @Override
    public void goToFlightSearchResults(ArrayList<Route> results) {
        FlightSearchResultsController flightSearchResults = new FlightSearchResultsController(this, results);
        setViewController(flightSearchResults);
    }
    
    @Override
    public void goToHotelSearchResults(Airport destination) {
        HotelSearchResultsController hotelSearchResults = new HotelSearchResultsController(this, destination);
        setViewController(hotelSearchResults);
    }
}
