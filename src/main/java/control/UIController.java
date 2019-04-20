package control;

import account.AirlineEmployee;
import account.User;
import routeCalculation.Flight;


public class UIController {
    public static UIController shared = new UIController();
    public AirlineAccountController employeeAccount;
    public User currentUser;
    private UserControl userCon;
    //private Arrylist<Flight> archivedRoutes;
    //private Arrylist<Flight> routes;
    private String routeOrigin;
    private String routeDestination;

    public UIController(){
        userCon = new UserControl();
    }

    public boolean logIn(String username, String password) {
        User user = userCon.getUser(username, password);
        if(user != null) {
            currentUser = user;
            checkForHigherAccess();
            return true;
        }
        else
            return false;
    }

    public void register(String username, String password, String email, int userType) {
        User user = userCon.createUser(username, password, email, userType);
        if(user != null)
            currentUser = user;
    }


    public void applyDiscount(Flight flight, int percentage) {
        if(checkForHigherAccess()) {
            if(flight.getAirlineID() == ((AirlineEmployee) currentUser).getAirlineID()) {
                double price = flight.getWeight();
                price = price - price / percentage;
                flight.setCost(price);
                //update db
                //apply discount and update database
            }
        }
    }

    public void logout() {
        currentUser = null;
    }

    public boolean checkForHigherAccess(){
        /**
         *  checks if the user is an airline employee thus giving access to cancellations and change system
         *  */
        if(currentUser.getUserType() == 2) {
            employeeAccount = new AirlineAccountController((AirlineEmployee) currentUser);
            employeeAccount.cancelFlight();
            employeeAccount.populateEmployeeFlights();
            return true;
        }
        else
            return false;
    }

}
