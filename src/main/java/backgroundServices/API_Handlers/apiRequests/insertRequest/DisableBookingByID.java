package backgroundServices.API_Handlers.apiRequests.insertRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class DisableBookingByID extends InsertRequestHandler {
    private final int id;

    public DisableBookingByID(int id) {
        super();
        this.id = id;
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("disableBookingByID"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"id\":\""+id+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
