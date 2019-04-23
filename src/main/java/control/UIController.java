package control;

import interceptor.*;
import account.AirlineEmployee;
import account.User;


public class UIController {
    public static UIController shared = new UIController();
    public User currentUser;
    private UserControl userCon;
    private String routeOrigin;
    private String routeDestination;

    public UIController() {
        userCon = new UserControl();
    }

    /**
     * Method which create new user object for the current session and call log in interception point
     * @return boolean for login success
     */
    public boolean logIn(String username, String password) {
        User user = userCon.getUser(username, password);
        if (user != null) {
            currentUser = user;
            LoggingDispatcher.getInstanceOfDispatcher().logIn(createLoggingContext("Logged in"));
            return true;
        } else
            return false;
    }

    public void register(String username, String password, String email, int userType) {
        User user = userCon.createUser(username, password, email, userType);
        if (user != null)
            currentUser = user;
    }


    public void logout() {
        LoggingDispatcher.getInstanceOfDispatcher();
        LoggingDispatcher.getInstanceOfDispatcher().logOut(createLoggingContext("Logged out"));
        currentUser = null;
    }

    public LoggingContext createLoggingContext(String msg) {
        return new LoggingContext(currentUser.getUserID(), msg,
                currentUser.getUserName());
    }

    public void accountControl() {
        /**
         *  checks if the user is an airline employee thus giving access to cancellations and change system
         *  */
        if (currentUser.getUserType() == 3) {
            AirlineAccountController employeeAccount = new AirlineAccountController((AirlineEmployee) currentUser);
            employeeAccount.displayMenu();
        } else if (currentUser.getUserType() == 1) {
            //do customer control
        }
    }

}
