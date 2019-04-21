package ui.controller;

import control.UIController;
import ui.coordinator.IMainMenuCoordinator;
import ui.view.MainMenuFrame;

import javax.swing.*;

public class MainMenuFrameController extends BaseFrameController  {
    private IMainMenuCoordinator coordinator;
    private JButton bookFlightsButton;
    private JButton cancelFlightsButton;
    private JButton orderHistoryButton;
    private JButton logoutButton;
    private JLabel usernameLabel;
    private JLabel availablePointsLabel;
    private JButton accountControlButton;

    public MainMenuFrameController(IMainMenuCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        MainMenuFrame mainMenuFrame = new MainMenuFrame();
        frame = mainMenuFrame;
        bookFlightsButton = mainMenuFrame.getBookFlightsButton();
        cancelFlightsButton = mainMenuFrame.getCancelFlightsButton();
        orderHistoryButton = mainMenuFrame.getOrderHistoryButton();
        logoutButton = mainMenuFrame.getLogoutButton();
        usernameLabel = mainMenuFrame.getUsernameLabel();
        availablePointsLabel = mainMenuFrame.getAvailablePointsLabel();
        accountControlButton = mainMenuFrame.getAccountControlButton();

        int userType = UIController.shared.currentUser.getUserType();
        if(userType == 1 || userType == 3) {
            accountControlButton.setVisible(true);
        }

        usernameLabel.setText(UIController.shared.currentUser.getUserName());
    }

    private void initListeners() {
        logoutButton.addActionListener(e -> coordinator.logout());
        bookFlightsButton.addActionListener(e -> coordinator.goToFlightSearch());
        accountControlButton.addActionListener(e -> UIController.shared.accountControl());
    }
}
