package ui.coordinator;


import memento.CareTaker;
import memento.Memento;
import routeCalculation.Airport;
import routeCalculation.Route;
import ui.controller.FlightSearchFrameController;
import ui.controller.FlightSearchResultsController;
import ui.controller.HotelSearchResultsController;
import ui.controller.MainMenuFrameController;
import ui.view.HotelSearchFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class MainMenuCoordinator extends BaseCoordinator implements IMainMenuCoordinator, CareTaker {

    private Stack<Memento> mementoStack = new Stack<>();

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

    public void goBackToFlightSearch() {
        FlightSearchFrameController flightSearch = new FlightSearchFrameController(this);
        flightSearch.restore(getLastMemento());
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

    @Override
    public void add(Memento m) {
        mementoStack.push(m);
    }

    @Override
    public Memento getLastMemento() {
        return mementoStack.pop();
    }

}
