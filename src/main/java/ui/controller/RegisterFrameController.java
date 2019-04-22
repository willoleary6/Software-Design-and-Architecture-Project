package ui.controller;

import memento.Memento;
import memento.Originator;
import memento.RegisterMemento;
import ui.coordinator.ILoginCoordinator;
import ui.model.RegisterModel;
import ui.view.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

public class RegisterFrameController extends BaseFrameController implements Originator {
    private ILoginCoordinator coordinator;
    private RegisterModel model;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton backButton;
    private JLabel errorLabel;

    public RegisterFrameController(ILoginCoordinator coordinator) {
        this.coordinator = coordinator;
        model = new RegisterModel();
        initComponents();
        initListeners();
    }

    private void initComponents() {
        RegisterFrame registerFrame = new RegisterFrame();
        frame = registerFrame;
        usernameField = registerFrame.getUsernameField();
        emailField = registerFrame.getEmailField();
        passwordField1 = registerFrame.getPasswordField1();
        passwordField2 = registerFrame.getPasswordField2();
        signUpButton = registerFrame.getSignUpButton();
        backButton = registerFrame.getBackButton();
        errorLabel = registerFrame.getErrorLabel();
    }

    private void initListeners() {
        backButton.addActionListener(e -> coordinator.goBackToWelcome());
        signUpButton.addActionListener(new SignUpButtonListener());
    }

    @Override
    public void restore(Memento m) {
        RegisterMemento memento = (RegisterMemento) m;
        usernameField.setText(memento.getUsername());
        emailField.setText(memento.getEmail());
        passwordField1.setText(memento.getPassword());
        passwordField2.setText(memento.getConfirmPassword());
    }

    @Override
    public Memento createMemento() {
        RegisterMemento memento = new RegisterMemento();
        memento.setUsername(usernameField.getText());
        memento.setEmail(emailField.getText());
        memento.setPassword(passwordField1.getText());
        memento.setConfirmPassword(passwordField2.getText());
        return memento;
    }

    private class SignUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model.setUserName(usernameField.getText());
                model.setEmail(emailField.getText());
                model.setPassword(passwordField1.getText(), passwordField2.getText());
                errorLabel.setText(" ");

                model.createUser();
                coordinator.goToMainMenu();

            } catch (InvalidParameterException exception) {
                errorLabel.setText(exception.getMessage());
            }
        }
    }
}
