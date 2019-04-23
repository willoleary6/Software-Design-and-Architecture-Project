package backgroundServices.API_Handlers.apiRequests.getRequest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class GetUserInformation extends GetRequestHandler {
    private final String username;
    private final String password;
    // private final int id;

    /*public GetUserInformation(int id) {
        super();
        this.id = id;
    }*/

    public GetUserInformation(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /*public GetUserInformation(String username) {
        super();
        this.username = username;
    }*/

    @Override
    public void makeRequest() {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("getUrl")+apiProperties.getProperty("getUserByUsernameAndPassword"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"username\":\""+username+"\"," +
                                    "\"password\":\""+password+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
}
