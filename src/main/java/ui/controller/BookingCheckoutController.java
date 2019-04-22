package ui.controller;

import booking.Booking;
import control.UIController;
import interceptor.LoggingDispatcher;
import ui.coordinator.IMainMenuCoordinator;
import ui.model.BookingCheckoutTableModel;
import ui.view.BookingCheckoutFrame;

import javax.swing.*;

public class BookingCheckoutController extends BaseFrameController {
    private JTable BookingCheckoutTable;
    private JButton MainMenuButton;
    private JButton ConfirmBookingButton;
    private IMainMenuCoordinator coordinator;
    private Booking reservations;

    public BookingCheckoutController(IMainMenuCoordinator coordinator, Booking reservations) {
        this.coordinator = coordinator;
        this.reservations = reservations;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        BookingCheckoutFrame bookingCheckoutFrame = new BookingCheckoutFrame();
        this.frame = bookingCheckoutFrame;
        ConfirmBookingButton = bookingCheckoutFrame.getConfirmBookingButton();
        MainMenuButton = bookingCheckoutFrame.getMainMenuButton();
        BookingCheckoutTable = bookingCheckoutFrame.getBookingCheckoutTable();

        BookingCheckoutTableModel tableModel = new BookingCheckoutTableModel(reservations);
        BookingCheckoutTable.setModel(tableModel);

    }

    private void initListeners() {
        MainMenuButton.addActionListener(e -> coordinator.start());
        ConfirmBookingButton.addActionListener(e -> {
            try {
                System.out.println("Booking confirmed");
                System.out.println(reservations.getListOfNames());
                System.out.println(reservations.getListOfCosts());
                LoggingDispatcher.getInstanceOfDispatcher().bookingMade(
                        UIController.shared.createLoggingContext(" " + reservations.getListOfNames() +
                                " Booking confirmed"));
            }catch (Exception exc){
                exc.printStackTrace();
            }
        });
    }
}
