package backgroundServices.API_Handlers.apiRequests.insertRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class AddNewDiscount extends InsertRequestHandler {
    private final String userID;
    private final String flightID;
    private final String discountStartDate;
    private final String discountEndDate;
    private final String discountPercentage;

    public AddNewDiscount(String userID, String flightID, String discountStartDate,
                          String discountEndDate, String discountPercentage) {
        super();
        this.userID = userID;
        this.flightID = flightID;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
        this.discountPercentage = discountPercentage;

    }
    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewDiscount"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"userID\":\""+userID+"\"," +
                                    "\"flightID\":\""+flightID+"\"," +
                                    "\"discountStartDate\":\""+discountStartDate+"\"," +
                                    "\"discountEndDate\":\""+discountEndDate+"\"," +
                                    "\"discountPercentage\":\""+discountPercentage+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
