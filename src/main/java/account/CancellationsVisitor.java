package account;

import backgroundServices.API_Handlers.apiRequests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.apiRequests.insertRequest.DisableBookingByID;
import interceptor.LoggingContext;
import interceptor.LoggingDispatcher;

import java.util.ArrayList;
import java.util.Scanner;

public class CancellationsVisitor implements UserVisitor {

    @Override
    public void visit(Customer user) {
        Scanner in = new Scanner(System.in);
        if(user.hasBookings()) {
            boolean end = false;
            System.out.println("Enter Flight ID of flight to be cancelled or e/E to exit: ");
            do {
                String input = in.nextLine();
                if(input.matches("e") || input.matches("E"))
                    end = true;
                else {
                    try {
                        int bookingID = Integer.parseInt(input);
                        if (bookingID !=0) {
                            new InsertRequestAdapter(new DisableBookingByID(bookingID));
                            LoggingDispatcher.getInstanceOfDispatcher().accountChange(createUserContext(user,
                                    bookingID));
                            System.out.println("Booking canceled");
                            end = true;
                        } else {
                            System.out.println("Incorrect ID entered");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input Please enter a number");
                    }
                }
            } while (!end);
        } else {
            System.out.println("no bookings");
        }
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
                        LoggingDispatcher.getInstanceOfDispatcher().accountChange(createAirlineContext(user, flightID));
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

    private LoggingContext createAirlineContext(AirlineEmployee user, int flightID) {
        LoggingContext context = new LoggingContext(user.getUserID(), "Flight canceled", user.getUserName(),
                user.getAirlineID(), flightID);
        return context;
    }

    private LoggingContext createUserContext(Customer user, int bookingID) {
        LoggingContext context = new LoggingContext(user.getUserID(), "bookings canceled", user.getUserName(),
                user.getUserID(), bookingID);
        return context;
    }

}
