package ui.model;

import backgroundServices.API_Handlers.getRequestHandler;
import org.json.JSONObject;
import reservation.Hotel;
import routeCalculation.Airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelSearchModel {
    private ArrayList<Hotel>  hotels = new ArrayList<>();
    private Airport destination;

    public HotelSearchModel(Airport destination) {
        getRequestHandler requestHandler = new getRequestHandler();
        requestHandler.getHotelsByAirportID(destination.getAutoKey());
        JSONObject [] results = requestHandler.getApiResponseResults();

        for(int i = 0; i < results.length; i++){
            hotels.add(
                    new Hotel(
                            results[i].getString("name"),
                            results[i].getInt("airport"),
                            results[i].getDouble("price"),
                            results[i].getInt("liaison"),
                            new JSONObject(results[i].getString("extendedDataInJSON"))
                    )
            );
        }
        this.destination = destination;
    }

    public HotelSearchTableModel getTableModel() {
        List<Hotel> hotelList = hotels;
        return  new HotelSearchTableModel(hotelList);
    }
}
