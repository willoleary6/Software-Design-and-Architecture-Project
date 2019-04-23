package backgroundServices.API_Handlers;

import backgroundServices.API_Handlers.apiRequests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.apiRequests.insertRequest.AddNewHotel;
import backgroundServices.API_Handlers.apiRequests.insertRequest.AddNewLog;
import backgroundServices.API_Handlers.apiRequests.insertRequest.DisableBookingByID;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class insertRequestHandlerTest {

    @Test
    void addNewHotel() {
        APIRequest hotelTest = new APIRequest();
        hotelTest.makeRequest(new InsertRequestAdapter(new AddNewHotel("test3", 1,27, "{}")));
        JSONObject[] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[{\"results\":true}]");
    }

    @Test
    void addNewLog() {
        int userID = 1;
        int logType = 1;
        String logMessage = "Test";
        String extendedDataInJSON = "";
        APIRequest logTest = new APIRequest();
        logTest.makeRequest(new InsertRequestAdapter(new AddNewLog(userID, logType, logMessage, extendedDataInJSON)));
        JSONObject[] responseKeys = logTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[{\"results\":true}]");
    }

    @Test
    void disableBookingByID() {
        APIRequest disableBookingTest = new APIRequest();
        disableBookingTest.makeRequest(new InsertRequestAdapter(new DisableBookingByID(1)));
        JSONObject[] responseKeys = disableBookingTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[{\"results\":true}]");
    }


}