package booking;

import java.util.ArrayList;

public class BookingComposite implements Booking {
    private ArrayList<Booking> childBookings = new ArrayList<>();

    @Override
    public double getTotalCost() {
        Double childBookingsCosts = 0.0;
        for(Booking currentChild: childBookings){
            childBookingsCosts += currentChild.getTotalCost();
        }
        return childBookingsCosts;
    }

    @Override
    public ArrayList<Double> getListOfCosts() {
        ArrayList<Double> listOfCosts = new ArrayList<>();
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
        for(Booking currentChild: childBookings){
            listOfString.addAll(currentChild.getListOfNames());
        }
        return listOfString;
    }

    @Override
    public ArrayList<String> getListOfTypeOfComposites() {
        ArrayList<String> listOfString = new ArrayList<>();
        for(Booking currentChild: childBookings){
            listOfString.addAll(currentChild.getListOfTypeOfComposites());
        }
        return listOfString;
    }
}
