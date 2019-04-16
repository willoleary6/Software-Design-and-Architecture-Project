package ui.controller;

import routeCalculation.Route;
import ui.coordinator.IMainMenuCoordinator;
import ui.model.FlightSearchResultsTableModel;
import ui.view.FlightSearchResultsFrame;

import javax.swing.*;
import java.util.ArrayList;

public class FlightSearchResultsController extends BaseFrameController {
    private JTable flightSearchResultsTable;
    private JButton bookFlightButton;
    private JButton bookHotelButton;
    private JButton mainMenuButton;
    private IMainMenuCoordinator coordinator;
    private ArrayList<Route> routes;

    public FlightSearchResultsController(IMainMenuCoordinator coordinator, ArrayList<Route> routes) {
        this.coordinator = coordinator;
        this.routes = routes;
        initComponents(routes);
        initListeners();
    }

    private void initComponents(ArrayList<Route> routes) {
        FlightSearchResultsFrame flightSearchResultsFrame = new FlightSearchResultsFrame();
        this.frame = flightSearchResultsFrame;
        bookFlightButton = flightSearchResultsFrame.getBookFlightButton();
        bookHotelButton = flightSearchResultsFrame.getBookHotelButton();
        mainMenuButton = flightSearchResultsFrame.getMainMenuButton();
        flightSearchResultsTable = flightSearchResultsFrame.getFlightSearchResultsTable();
        FlightSearchResultsTableModel tableModel = new FlightSearchResultsTableModel(routes);
        flightSearchResultsTable.setModel(tableModel);
    }

    private void initListeners() {
        mainMenuButton.addActionListener(e -> coordinator.start());
        bookHotelButton.addActionListener(e -> {
            try {
                coordinator.goToHotelSearchResults(routes);
            }catch (Exception exc){
                exc.printStackTrace();
                JOptionPane.showMessageDialog(null, "No Airport selected.");
            }
        });

        bookFlightButton.addActionListener(e -> {
            try {
                coordinator.goToBookingConfirmScreen(routes);
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "No Airport selected.");
            }
        });
    }
}
