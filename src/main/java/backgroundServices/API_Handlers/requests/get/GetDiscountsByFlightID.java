package backgroundServices.API_Handlers.requests.get;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class GetDiscountsByFlightID extends GetRequestHandler {
    private final int id;

    public GetDiscountsByFlightID(int id) {
        super();
        this.id = id;
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("getUrl")+apiProperties.getProperty("getDiscountsByFlightID"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"flightID\":\""+id+"\"" +
                                    "}"
                            )
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
