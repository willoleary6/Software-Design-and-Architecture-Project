package backgroundServices.API_Handlers.requests.insert.insertRequests;

import backgroundServices.API_Handlers.requests.insert.InsertRequestHandler;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class AddNewUser extends InsertRequestHandler {
    private String username;
    private String email;
    private String password;

    public AddNewUser(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }


    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewUser"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"username\":\""+username+"\"," +
                                    "\"email\":\""+email+"\"," +
                                    "\"password\":\""+password+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
