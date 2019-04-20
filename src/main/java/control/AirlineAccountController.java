package control;

import account.AirlineEmployee;
import account.CancelBookings;
import routeCalculation.Flight;

import java.util.ArrayList;

public class AirlineAccountController {

    private AirlineEmployee currentUser;
    private SearchController search;

    public AirlineAccountController(AirlineEmployee user){
        currentUser = user;
        search = new SearchController();
        populateEmployeeFlights();
    }


    protected void populateEmployeeFlights(){
        //Call on the search controller to return all flights then filter flights by airlineID
        ArrayList<Flight> flights = search.retrieveAllFlights();
        flights = filterFlights(flights);
        currentUser.populateFlights(flights);

    }

    private ArrayList<Flight> filterFlights(ArrayList<Flight> flights){
        ArrayList<Flight> newFlights = new ArrayList<Flight>();
        for(Flight i : flights)
            if(i.getAirlineID() == currentUser.getAirlineID())
                newFlights.add(i);
        return newFlights;
    }

    public void cancelFlight(){
        CancelBookings visitor = new CancelBookings();
        currentUser.accept(visitor);
    }

}
