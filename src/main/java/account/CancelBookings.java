package account;

import routeCalculation.Flight;

import java.util.ArrayList;
import java.util.Scanner;

public class CancelBookings implements UserVisitor {

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


}
