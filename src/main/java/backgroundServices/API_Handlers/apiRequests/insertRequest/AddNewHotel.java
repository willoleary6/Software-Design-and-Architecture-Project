package backgroundServices.API_Handlers.apiRequests.insertRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class AddNewHotel extends InsertRequestHandler {
    private final String hotelName;
    private final int airport;
    private final int liason;
    private final String extendedDataInJSON;

    public AddNewHotel(String hotelName, int airport, int liason, String extendedDataInJSON) {
        super();
        this.hotelName = hotelName;
        this.airport = airport;
        this.liason = liason;
        this.extendedDataInJSON = extendedDataInJSON;
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewHotel"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"name\":\""+hotelName+"\"," +
                                    "\"airport\":\""+airport+"\"," +
                                    "\"liason\":\""+liason+"\"," +
                                    "\"extendedDataInJSON\":\""+extendedDataInJSON+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
