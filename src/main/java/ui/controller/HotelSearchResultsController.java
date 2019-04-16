package ui.controller;

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
        cancelButton.addActionListener(e -> coordinator.goToFlightSearch());
        bookHotelButton.addActionListener(e -> System.out.println("Booked Hotel!"));
    }
}
