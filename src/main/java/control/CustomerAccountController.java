package control;

import account.Customer;
import booking.Booking;

import java.util.ArrayList;

public class CustomerAccountController {

    private Customer currentUser;
    private SearchController search;

    public CustomerAccountController(Customer user){
        currentUser = user;
        search = new SearchController();
        populateCustomerBookings();
    }

    protected void populateEmployeeFlights(){
        //Call on the search controller to return all flights then filter flights by airlineID
        ArrayList<Booking> bookings = search.retrieveAllBookings();
        bookings = filterBookings(bookings);
        currentUser.populatebookings(bookings);

    }
}
