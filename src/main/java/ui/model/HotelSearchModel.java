package ui.model;

import reservation.Hotel;
import reservation.HotelService;
import routeCalculation.Airport;

import java.util.ArrayList;
import java.util.List;

public class HotelSearchModel {
    private HotelService service;
    private Airport destination;

    public HotelSearchModel(Airport destination) {
        service = new HotelService();
        this.destination = destination;
    }

    public HotelSearchTableModel getTableModel() {
        List<Hotel> hotels = service.getHotels(destination.getAutoKey());
        return  new HotelSearchTableModel(hotels);
    }
}
