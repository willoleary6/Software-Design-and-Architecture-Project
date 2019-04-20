package ui.coordinator;

import memento.CareTaker;
import memento.Memento;
import memento.Originator;
import ui.controller.LoginFrameController;
import ui.controller.RegisterFrameController;
import ui.controller.WelcomeFrameController;

public class LoginCoordinator extends BaseCoordinator implements ILoginCoordinator {

    private CareTaker careTaker = new CareTaker();

    public void start() {
        WelcomeFrameController welcome = new WelcomeFrameController(this);
        setViewController(welcome);
    }

    public void goToLogin() {
        LoginFrameController login = new LoginFrameController(this);
        setViewController(login);
    }

    public void goToRegister() {
        RegisterFrameController register = new RegisterFrameController(this);
        setViewController(register);

        Memento m = careTaker.getLastMemento();
        if(m != null) {
            register.restore(m);
        }
    }

    public void goToMainMenu() {
        IMainMenuCoordinator mainMenuCoordinator = new MainMenuCoordinator();
        mainMenuCoordinator.start();
        setViewController(null);
    }

    public void goBackToWelcome() {
        Memento m = ((Originator) currentViewController).createMemento();
        careTaker.add(m);
        start();
    }
}
