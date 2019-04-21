package account;

import routeCalculation.Flight;

import java.util.ArrayList;

public class AirlineEmployee extends User implements UserVisitable {
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
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Flights baiiis");
        for(Flight i : airlineFlights)
            System.out.println(i);
        System.out.println("-------------------------------------------------------------------------------------");
    }

    @Override
    public void accept(UserVisitor visitor) {
        visitor.visit(this);
    }

    public ArrayList<Integer> getFlightsNumbers(){
        ArrayList<Integer> flightNums = new ArrayList<Integer>();
        for(Flight i : airlineFlights)
            flightNums.add(i.getFlightID());
        return flightNums;
    }
}

