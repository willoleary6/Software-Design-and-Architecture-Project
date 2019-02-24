package backgroundServices.API_Handlers;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class getRequestHandlerTest {

    @Test
    void getHotelsByAirportIDKeysTest() {
        getRequestHandler hotelTest = new getRequestHandler();
        hotelTest.getHotelsByAirportID(0);
        String [] responseKeys = hotelTest.getApiResponseKeys();
        assertEquals(Arrays.toString(responseKeys), "[autoID, name, airport, liaison, isActive, extendedDataInJSON]");
    }
    @Test
    void getHotelsByAirportIDValuesNullTest() {
        getRequestHandler hotelTest = new getRequestHandler();
        hotelTest.getHotelsByAirportID(0);
        JSONObject [] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[null]");
    }
    @Test
    void getHotelsByAirportIDValuesTest() {
        getRequestHandler hotelTest = new getRequestHandler();
        hotelTest.getHotelsByAirportID(6);
        JSONObject [] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[{\"extendedDataInJSON\":\"\",\"autoID\":1,\"name\":\"Trump Hotels\",\"liaison\":27,\"isActive\":1,\"airport\":6}]");
    }
}