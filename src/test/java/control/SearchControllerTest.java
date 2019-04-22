package control;

import backgroundServices.API_Handlers.getRequestHandler;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    private getRequestHandler dbHandler = new getRequestHandler();
    SearchController search = new SearchController();

    @Test
    void retriveAllFlights() {
        dbHandler.getAllFlights();
        JSONObject[] response = dbHandler.getApiResponseResults();
        System.out.print(response[1]);
        assertEquals(response.length, search.retrieveAllFlights().size());
    }


}