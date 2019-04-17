package control;

import account.AirlineEmployee;
import control.SearchController;
import routeCalculation.Flight;

import java.util.ArrayList;

public class AccountController {

    private AirlineEmployee currentUser;
    private SearchController search;

    public AccountController(AirlineEmployee user){
        currentUser = user;
        search = new SearchController();
        populateEmployeeFlights();
    }


    private void populateEmployeeFlights(){
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

}
