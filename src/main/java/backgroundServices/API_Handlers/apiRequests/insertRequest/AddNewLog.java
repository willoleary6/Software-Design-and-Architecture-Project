package backgroundServices.API_Handlers.apiRequests.insertRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class AddNewLog extends InsertRequestHandler{
    private final int userID;
    private final int type;
    private final String message;
    private final String extendedDataInJSON;

    public AddNewLog(int userID, int type, String message, String extendedDataInJSON) {
        super();
        this.userID = userID;
        this.type = type;
        this.message = message;
        this.extendedDataInJSON = extendedDataInJSON;
    }

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewLog"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"userID\":\""+userID+"\"," +
                                    "\"type\":\""+type+"\"," +
                                    "\"message\":\""+message+"\"," +
                                    "\"extendedDataInJSON\":\""+extendedDataInJSON+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
