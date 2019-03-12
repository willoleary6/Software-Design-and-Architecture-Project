package ui.model;

import org.json.JSONObject;
import reservation.Hotel;
import routeCalculation.Airport;

import java.util.Arrays;
import java.util.List;

public class HotelSearchModel {
    private Hotel [] hotels;
    private Airport destination;

    public HotelSearchModel(Airport destination) {
        hotels = new Hotel[]{new Hotel("test", destination.getAutoKey(), 1, new JSONObject("{}"))};
        this.destination = destination;
    }

    public HotelSearchTableModel getTableModel() {
        List<Hotel> hotelList = Arrays.asList(hotels);
        return  new HotelSearchTableModel(hotelList);
    }
}
