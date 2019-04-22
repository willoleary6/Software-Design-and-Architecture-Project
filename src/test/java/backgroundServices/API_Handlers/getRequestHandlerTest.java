package backgroundServices.API_Handlers;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class getRequestHandlerTest {

    @Test
    void getHotelsByAirportIDKeysTest() {
        GetRequestHandler hotelTest = new GetRequestHandler();
        hotelTest.getHotelsByAirportID(0);
        String [] responseKeys = hotelTest.getApiResponseKeys();
        assertEquals(Arrays.toString(responseKeys), "[autoID, name, price, airport, liaison, isActive, extendedDataInJSON]");
    }
    @Test
    void getHotelsByAirportIDValuesNullTest() {
        GetRequestHandler hotelTest = new GetRequestHandler();
        hotelTest.getHotelsByAirportID(0);
        JSONObject [] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[null]");
    }
    @Test
    void getHotelsByAirportIDValuesTest() {
        GetRequestHandler hotelTest = new GetRequestHandler();
        hotelTest.getHotelsByAirportID(6);
        JSONObject [] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys),
                "[{\"price\":70,\"extendedDataInJSON\":\"{}\",\"autoID\":1," +
                        "\"name\":\"Trump Hotels\",\"liaison\":27,\"isActive\":1," +
                        "\"airport\":6}, {\"price\":70,\"extendedDataInJSON\":\"{}" +
                        "\",\"autoID\":7,\"name\":\"test3\",\"liaison\":27,\"isActive\":1,\"airport\":6}]");
    }
    @Test
    void getBookingByID(){
        getRequestHandler bookingTest = new getRequestHandler();
        bookingTest.getBookingByID(1);
        JSONObject [] responseKeys = bookingTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys),
                "[{\"departureTime\":\"2018-10-30 14:00:00\"," +
                        "\"arrivalTime\":\"2018-10-30 15:00:00\"," +
                        "\"extendedDataInJSON\":\"None\"," +
                        "\"autoID\":\"1\"," +
                        "\"passengerID\":\"1\"," +
                        "\"flightID\":\"1\"," +
                        "\"isActive\":\"1\"}]");
    }
}