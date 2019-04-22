package ui.coordinator;

import ui.controller.ViewController;

abstract class BaseCoordinator {

    ViewController currentViewController;

    void setViewController(ViewController controller) {
        if (controller != null) {
            controller.show();
        }

        if (currentViewController != null) {
            currentViewController.hide();
        }

        currentViewController = controller;
    }
}
