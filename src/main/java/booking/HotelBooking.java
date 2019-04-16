package booking;

import reservation.Hotel;
import routeCalculation.Route;

import java.util.ArrayList;

public class HotelBooking implements Booking {
    private String hotelName;
    private Double cost;
    private String type;
    private ArrayList<Booking> childBookings = new ArrayList<>();

    public HotelBooking(Hotel hotel){
        this.type = "Hotel";
        this.hotelName = hotel.getHotelName();
        this.cost = hotel.getPrice();
    }

    @Override
    public double getTotalCost() {
        Double childBookingsCosts = 0.0;
        for(Booking currentChild: childBookings){
            childBookingsCosts += currentChild.getTotalCost();
        }
        return childBookingsCosts+this.cost;
    }

    @Override
    public ArrayList<Double> getListOfCosts() {
        ArrayList<Double> listOfCosts = new ArrayList<>();
        listOfCosts.add(cost);
        for(Booking currentChild: childBookings){
            listOfCosts.addAll(currentChild.getListOfCosts());
        }
        return listOfCosts;
    }

    @Override
    public void addChildBooking(Booking bookingToAdd) {
        childBookings.add(bookingToAdd);
    }

    @Override
    public void removeChildBooking(Booking bookingToRemove) {
        childBookings.remove(bookingToRemove);
    }

    @Override
    public ArrayList<String> getListOfNames() {
        ArrayList<String> listOfString = new ArrayList<>();
        listOfString.add(hotelName);
        for(Booking currentChild: childBookings){
            listOfString.addAll(currentChild.getListOfNames());
        }
        return listOfString;
    }

    @Override
    public ArrayList<String> getListOfTypeOfComposites() {
        ArrayList<String> listOfString = new ArrayList<>();
        listOfString.add(type);
        for(Booking currentChild: childBookings){
            listOfString.addAll(currentChild.getListOfTypeOfComposites());
        }
        return listOfString;
    }
}
