package interceptor;

import java.util.ArrayList;
import java.util.Date;

public class HotelBookingContext {

    private ArrayList<String> hotels;
    private ArrayList<Double> hotelCosts;
    private Double totalHotelCost;
    private ArrayList<Date> dates;

    public HotelBookingContext(ArrayList<String> hotels, ArrayList<Double> hotelCosts, Double totalHotelCost) {
        this.hotels = hotels;
        this.hotelCosts = hotelCosts;
        this.totalHotelCost = totalHotelCost;
    }

    public ArrayList<String> getHotels() {
        return hotels;
    }

    public ArrayList<Double> getHotelCosts() {
        return hotelCosts;
    }

    public Double getTotalHotelCost() {
        return totalHotelCost;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }
}
