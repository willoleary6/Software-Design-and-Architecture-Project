package backgroundServices.API_Handlers;

import backgroundServices.API_Handlers.apiRequests.getRequest.GetBookingByID;
import backgroundServices.API_Handlers.apiRequests.getRequest.GetHotelsByAirportID;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class getRequestHandlerTest {

    @Test
    void getHotelsByAirportIDKeysTest() {
        APIRequest hotelTest = new APIRequest();
        hotelTest.makeRequest(new GetHotelsByAirportID(0));
        String [] responseKeys = hotelTest.getApiResponseKeys();
        assertEquals(Arrays.toString(responseKeys), "[autoID, name, price, airport, liaison, isActive, extendedDataInJSON]");
    }
    @Test
    void getHotelsByAirportIDValuesNullTest() {
        APIRequest hotelTest = new APIRequest();
        hotelTest.makeRequest(new GetHotelsByAirportID(0));
        JSONObject [] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[null]");
    }
    @Test
    void getHotelsByAirportIDValuesTest() {
        APIRequest hotelTest = new APIRequest();
        hotelTest.makeRequest(new GetHotelsByAirportID(6));
        JSONObject [] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys),
                "[{\"price\":70,\"extendedDataInJSON\":\"{}\",\"autoID\":1,\"name\":\"New York Hotel\",\"liaison\":27,\"isActive\":1,\"airport\":6}]");
    }
    @Test
    void getBookingByID() {
        APIRequest bookingTest = new APIRequest();
        bookingTest.makeRequest(new GetBookingByID(1));
        JSONObject [] responseKeys = bookingTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys),
                "[null]");
    }
}