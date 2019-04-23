package backgroundServices.API_Handlers.requests.get;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class GetHotelsByAirportID extends GetRequestHandler {
    private final int id;

    public GetHotelsByAirportID(int id) {
        super();
        this.id = id;
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("getUrl")+apiProperties.getProperty("getHotelsByAirportID"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"id\":\""+id+"\"" +
                                    "}"
                            )
                            .asString();
            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
