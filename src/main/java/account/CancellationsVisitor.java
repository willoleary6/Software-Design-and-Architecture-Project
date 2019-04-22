package account;

import interceptor.LoggingContext;
import interceptor.LoggingDispatcher;

import java.util.ArrayList;
import java.util.Scanner;

public class CancellationsVisitor implements UserVisitor {

    @Override
    public void visit(Customer user) {

    }

    @Override
    public void visit(AirlineEmployee user) {
        Scanner in = new Scanner(System.in);
        user.showFlights();
        boolean end = false;
        System.out.println("Enter Flight ID of flight to be cancelled or e/E to exit: ");
        do {
            String input = in.nextLine();
            if(input.matches("e") || input.matches("E"))
                end = true;
            else {
                try {
                    int flightID = Integer.parseInt(input);
                    // retrieve list of flight nums to ensure flight id is a flight assigned to user
                    ArrayList<Integer> flightNums = user.getFlightsNumbers();
                    if (flightNums.contains(flightID)) {
                        //execute delete
                        LoggingDispatcher.getInstanceOfDispatcher().accountChange(createContext(user, flightID));
                        System.out.println("Flight canceled");
                        end = true;
                    } else {
                        System.out.println("Incorrect ID entered");
                    }
                } catch (Exception e) {
                    System.out.println("Wrong input Please enter a number");
                }
            }
        } while (!end);
    }

    private LoggingContext createContext(AirlineEmployee user, int flightID) {
        LoggingContext context = new LoggingContext(user.getUserID(), "Flight canceled", user.getUserName(),
                user.getAirlineID(), flightID);
        return context;
    }

}
