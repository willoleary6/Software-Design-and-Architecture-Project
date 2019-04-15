package ui.controller;

import memento.CareTaker;
import memento.FlightSearchMemento;
import memento.Memento;
import memento.Originator;
import routeCalculation.Airport;
import routeCalculation.Route;
import ui.coordinator.IMainMenuCoordinator;
import ui.model.AirportComboBoxModel;
import ui.model.FlightSearchModel;
import ui.view.FlightSearchFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.ArrayList;

public class FlightSearchFrameController extends BaseFrameController implements PropertyChangeListener, Originator {
    private IMainMenuCoordinator coordinator;
    private JComboBox departureComboBox;
    private JComboBox destinationComboBox;
    private JTextField departureDateField;
    private JRadioButton costRadioButton;
    private JRadioButton timeRadioButton;
    private JButton backButton;
    private JButton searchFlightsButton;
    private FlightSearchModel model;

    public FlightSearchFrameController(IMainMenuCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
        this.model = new FlightSearchModel(this);
    }

    private void initComponents() {
        FlightSearchFrame flightSearchFrame = new FlightSearchFrame();
        frame = flightSearchFrame;
        departureComboBox = flightSearchFrame.getDepartureComboBox();
        destinationComboBox = flightSearchFrame.getDestinationComboBox();
        departureDateField = flightSearchFrame.getDepartureDateField();
        costRadioButton = flightSearchFrame.getCostRadioButton();
        timeRadioButton = flightSearchFrame.getTimeRadioButton();
        backButton = flightSearchFrame.getBackButton();
        searchFlightsButton = flightSearchFrame.getSearchFlightsButton();
    }

    private void initListeners() {
        backButton.addActionListener(e -> coordinator.start());
        searchFlightsButton.addActionListener(new SearchFlightButtonListener());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Airport[] airportList = (Airport[]) evt.getNewValue();

        ComboBoxModel boxModel1 = new AirportComboBoxModel(airportList);
        ComboBoxModel boxModel2 = new AirportComboBoxModel(airportList);
        departureComboBox.setModel(boxModel1);
        destinationComboBox.setModel(boxModel2);
    }

    @Override
    public void restore(Memento m) {
        FlightSearchMemento memento = (FlightSearchMemento) m;
        this.model = memento.getSavedState();
        departureDateField.setText(model.getDepartureDate().toString());
        departureComboBox.setSelectedItem(model.getDepartureAirport());
        destinationComboBox.setSelectedItem(model.getDestinationAirport());
        costRadioButton.setSelected(model.isCostBased());
        timeRadioButton.setSelected(!model.isCostBased());
    }

    @Override
    public Memento createMemento() {
        setModelDetails();
        return new FlightSearchMemento(model);
    }

    private void setModelDetails() {
        try {
            model.setDepartureDate(departureDateField.getText());
            model.setDepartureAirport((Airport) departureComboBox.getSelectedItem());
            model.setDestinationAirport((Airport) destinationComboBox.getSelectedItem());
            model.setCostBased(costRadioButton.isSelected());
        } catch (ParseException exception) {
            System.out.print(exception);
        }
    }

    private class SearchFlightButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setModelDetails();
            ArrayList<Route> route = model.searchForFlight();
            CareTaker careTaker = (CareTaker) coordinator;
            careTaker.add(createMemento());
            coordinator.goToFlightSearchResults(route);
        }
    }
}
