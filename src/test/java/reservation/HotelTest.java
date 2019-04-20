package reservation;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void getHotelName() {
        Hotel hotelTest = new Hotel("test", 0, 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getHotelName(), "test");
    }

    @Test
    void getAirportID() {
        Hotel hotelTest = new Hotel("test", 0, 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getAirportID(), 0);
    }

    @Test
    void getLiaisonUserID() {
        Hotel hotelTest = new Hotel("test", 0, 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getLiaisonUserID(), 0);
    }

    @Test
    void getAdditionalServices_null_argument() {
        Hotel hotelTest = new Hotel("test", 0, 0, 0, new JSONObject("{}"));
        assertEquals(hotelTest.getAdditionalServices(), null);
    }

    @Test
    void getAdditionalServices_valid_argument() {
        Hotel hotelTest = new Hotel("test", 0,0,
                0, new JSONObject(
                        "{additional_services:[{name:\"test\", price:20.00, description:\"test_description\"}]}")
        );
        HotelService [] testArrayOf = {new HotelService("test",20.00, "test_description")};
        assertEquals(hotelTest.getAdditionalServices()[0].getName(), testArrayOf[0].getName());
        assertEquals(hotelTest.getAdditionalServices()[0].getPrice(), testArrayOf[0].getPrice());
        assertEquals(hotelTest.getAdditionalServices()[0].getDescription(), testArrayOf[0].getDescription());
    }
}