package reservation;

import java.util.ArrayList;
import java.util.List;

//TODO this object will handle hotels extra services such as room service and golden showers with a name, description and price....
public class HotelService {

    public List<Hotel> getHotels(int airportId) {
        List<Hotel> hotels = new ArrayList();
        hotels.add(new Hotel("Maldron", airportId, 0, null));
        hotels.add(new Hotel("Jury's Inn", airportId, 0, null));
        hotels.add(new Hotel("Strand Hotel", airportId, 0, null));
        hotels.add(new Hotel("Clayton", airportId, 0, null));
        return hotels;
    }

}
