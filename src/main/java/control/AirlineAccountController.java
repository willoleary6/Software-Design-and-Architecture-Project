package control;

import account.AirlineEmployee;
import account.CancellationsVisitor;
import routeCalculation.Flight;

import java.util.ArrayList;
import java.util.Scanner;

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
        ArrayList<Flight> flights = search.retrieveAllFlightsFromServer();
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

    private void cancelFlight(){
        CancellationsVisitor visitor = new CancellationsVisitor();
        currentUser.accept(visitor);
    }

    public void displayMenu(){
        if(currentUser.getFlightsNumbers().size() > 0){
            boolean end = false;
            Scanner in = new Scanner(System.in);
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1:\tcancel flight");
            System.out.println("e/E:\texit menu");
            System.out.println("-------------------------------------------------------------------------------------");
            do {
                System.out.println("Please enter option: ");
                String input = in.nextLine();
                if(input.matches("e") || input.matches("E"))
                    end = true;
                else{
                    int option = Integer.parseInt(input);
                    if(option == 1)
                        cancelFlight();
                }
            } while (!end);
        } else {
            System.out.println("No options available");
        }
    }

}
