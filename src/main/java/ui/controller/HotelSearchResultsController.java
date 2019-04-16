package ui.controller;

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

    public HotelSearchResultsController(IMainMenuCoordinator coordinator,  ArrayList<Route> routes) {
        this.routes = routes;
        this.coordinator = coordinator;
        this.model = new HotelSearchModel(routes.get(routes.size()-1).getDestination());
        initComponents();
        initListeners();
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
                // Airport destination = (Airport) flightSearchResultsTable.getValueAt(flightSearchResultsTable.getSelectedRow(), 1);
                //
                Hotel selectedHotel = (Hotel) hotelTable.getValueAt(hotelTable.getSelectedRow(), -1);
                coordinator.goToBookingConfirmScreen(routes, selectedHotel);
            }catch (Exception exc){
                JOptionPane.showMessageDialog(null, "No Hotel selected.");
            }
        });
    }
}
