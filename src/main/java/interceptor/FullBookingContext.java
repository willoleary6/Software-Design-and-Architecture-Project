package interceptor;


import java.util.ArrayList;
import java.util.Date;

public class FullBookingContext {

    private FlightBookingContext flightContext;
    private HotelBookingContext hotelContext;

    public FullBookingContext(FlightBookingContext flightContext, HotelBookingContext hotelContext) {
        this.flightContext = flightContext;
        this.hotelContext = hotelContext;
    }

    public FlightBookingContext getFlightContext() {
        return flightContext;
    }

    public HotelBookingContext getHotelContext() {
        return hotelContext;
    }

    public Double getTotalCostOfTrip() {
        return hotelContext.getTotalHotelCost() + flightContext.getTotalJourneyCost();
    }

    /**
     * creates an arraylist of list which merges all the flight data with the hotel data to create one
     * comprhensive arraylist of booking details
     * @return returns an arraylist of lists 0 - string 1 - costs 2 - dates
     */
    public ArrayList<ArrayList> getAllDetails() {
        ArrayList<ArrayList> details = new ArrayList<ArrayList>();
        ArrayList<String> allString = flightContext.getFlightRoutes();
        allString.addAll(hotelContext.getHotels());
        ArrayList<Double> allCosts = flightContext.getFlightCosts();
        allCosts.addAll(flightContext.getFlightCosts());
        ArrayList<Date> alldates = flightContext.getDates();
        alldates.addAll(hotelContext.getDates());
        details.add(allString);
        details.add(allCosts);
        details.add(alldates);
        return details;
    }
}
