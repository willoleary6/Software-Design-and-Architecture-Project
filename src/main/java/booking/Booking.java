package booking;
import java.util.ArrayList;

public interface Booking {
    double getTotalCost();
    ArrayList<Double> getListOfCosts();
    void addChildBooking(Booking bookingToAdd);
    void removeChildBooking(Booking bookingToRemove);
    ArrayList<String> getListOfNames();
    ArrayList<String> getListOfTypeOfComposites();
    int getNumberOfChildBookings();
}