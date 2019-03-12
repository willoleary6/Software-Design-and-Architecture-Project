package ui.controller;

import routeCalculation.Airport;
import routeCalculation.Route;
import ui.coordinator.IMainMenuCoordinator;
import ui.model.FlightSearchResultsTableModel;
import ui.view.FlightSearchResultsFrame;

import javax.swing.*;
import java.util.ArrayList;

public class FlightSearchResultsController extends BaseFrameController {
    private JTable flightSearchResultsTable;
    private JButton bookFlightButton;
    private JButton mainMenuButton;
    private IMainMenuCoordinator coordinator;

    public FlightSearchResultsController(IMainMenuCoordinator coordinator, ArrayList<Route> routes) {
        this.coordinator = coordinator;
        initComponents(routes);
        initListeners();
    }

    private void initComponents(ArrayList<Route> routes) {
        FlightSearchResultsFrame flightSearchResultsFrame = new FlightSearchResultsFrame();
        this.frame = flightSearchResultsFrame;
        bookFlightButton = flightSearchResultsFrame.getBookFlightButton();
        mainMenuButton = flightSearchResultsFrame.getMainMenuButton();
        flightSearchResultsTable = flightSearchResultsFrame.getFlightSearchResultsTable();
        FlightSearchResultsTableModel tableModel = new FlightSearchResultsTableModel(routes);
        flightSearchResultsTable.setModel(tableModel);
    }

    private void initListeners() {
        mainMenuButton.addActionListener(e -> coordinator.start());
        bookFlightButton.addActionListener(e -> {
            Airport destination = (Airport) flightSearchResultsTable.getValueAt(flightSearchResultsTable.getSelectedRow(), 1);
            coordinator.goToHotelSearchResults(destination);
        });
    }
}
