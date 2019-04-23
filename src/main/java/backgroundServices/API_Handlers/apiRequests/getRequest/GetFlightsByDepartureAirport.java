package backgroundServices.API_Handlers.apiRequests.getRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class GetFlightsByDepartureAirport extends GetRequestHandler {
    private final int id;

    public GetFlightsByDepartureAirport(int id) {
        super();
        this.id = id;
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("getUrl")+apiProperties.getProperty("getFlightsInfoByDepartureAirportID"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"airportID\":\""+id+"\"" +
                                    "}"
                            )
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
