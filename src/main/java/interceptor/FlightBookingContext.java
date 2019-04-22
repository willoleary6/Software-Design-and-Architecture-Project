package interceptor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * context object which contain information on a booking made could be used to print tickets or confirmations
 * if intercepted after a booking is made
 */
public class FlightBookingContext {

    private ArrayList<String> flightRoutes;
    private ArrayList<Double> flightCosts;
    private Double totalJourneyCost;
    private ArrayList<Date> dates;


    public FlightBookingContext(ArrayList<String> flightRoutes, ArrayList<Double> flightCosts,
                                Double totalJourneyCost) {
        this.flightRoutes = flightRoutes;
        this.flightCosts = flightCosts;
        this.totalJourneyCost = totalJourneyCost;
    }

    public ArrayList<String> getFlightRoutes() {
        return flightRoutes;
    }

    public ArrayList<Double> getFlightCosts() {
        return flightCosts;
    }

    public Double getTotalJourneyCost() {
        return totalJourneyCost;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }
}
