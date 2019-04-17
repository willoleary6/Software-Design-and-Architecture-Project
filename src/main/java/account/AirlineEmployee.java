package account;

import routeCalculation.Flight;

import java.util.ArrayList;

public class AirlineEmployee extends User {
    private int airlineID;
    private ArrayList<Flight> airlineFlights;

    public AirlineEmployee(String userName, int employeeID, int userType, int airlineID){
        this.setUserName(userName);
        this.setUserID(employeeID);
        this.setUserType(userType);
        this.airlineID = airlineID;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public void populateFlights(ArrayList<Flight> airlineFlights){
        this.airlineFlights = airlineFlights;
    }

    public void showFlights(){
        System.out.println("Flights baiiis");
    }
}

