package control;

import backgroundServices.API_Handlers.APIRequest;
import backgroundServices.API_Handlers.getRequestHandler;
import backgroundServices.API_Handlers.requests.get.GetAllAirports;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchControllerTest {

    private APIRequest dbHandler = new APIRequest();
    SearchController search = new SearchController();

    @Test
    void retrieveAllFlights() {
        dbHandler.makeRequest(new GetAllAirports());
        JSONObject[] response = dbHandler.getApiResponseResults();
        System.out.print(response[1]);
        assertEquals(response.length, search.retrieveAllFlightsFromServer().size());
    }


}