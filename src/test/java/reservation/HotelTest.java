package reservation;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void getHotelName() {
        Hotel hotelTest = new Hotel("test", 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getHotelName(), "test");
    }

    @Test
    void getAirportID() {
        Hotel hotelTest = new Hotel("test", 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getAirportID(), 0);
    }

    @Test
    void getLiaisonUserID() {
        Hotel hotelTest = new Hotel("test", 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getLiaisonUserID(), 0);
    }
}