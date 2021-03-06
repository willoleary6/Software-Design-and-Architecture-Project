package backgroundServices.API_Handlers.apiRequests.getRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class GetAllAirports extends GetRequestHandler {
    public GetAllAirports() {
        super();
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.get(apiProperties.getProperty("getUrl") + apiProperties.getProperty("getAllAirports"))
                            .asString();

            apiResponse = new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
