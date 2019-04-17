package backgroundServices.API_Handlers;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class insertRequestHandlerTest {

    @Test
    void addNewHotel() {
        InsertRequestHandler hotelTest = new InsertRequestHandler();
        hotelTest.addNewHotel("test3", 1,27, "{}");
        JSONObject[] responseKeys = hotelTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[{\"result\":null}]");
    }

    @Test
    void addNewLog() {
        int userID = 1;
        int logType = 1;
        String logMessage = "Test";
        String extendedDataInJSON = "";
        InsertRequestHandler logTest = new InsertRequestHandler();
        logTest.addNewLog(userID, logType, logMessage, extendedDataInJSON);
        JSONObject[] responseKeys = logTest.getApiResponseResults();
        assertEquals(Arrays.toString(responseKeys), "[{\"result\":null}]");
    }

}