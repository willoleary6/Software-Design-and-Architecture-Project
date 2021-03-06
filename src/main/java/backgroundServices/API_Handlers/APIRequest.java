package backgroundServices.API_Handlers;

import backgroundServices.resourceReader.Reader;
import org.json.JSONObject;

import java.util.Properties;

public class APIRequest {
    private final Reader myReader;
    private final Properties apiProperties;
    private JSONObject[] responseResult;
    private Request request;

    public APIRequest() {
        myReader = new Reader();
        apiProperties = myReader.readFromResources("src/main/resources/APIs.properties");
    }

    public void makeRequest(Request request) {
        this.request = request;
        this.request.makeRequest();
    }

    public JSONObject[] getApiResponseResults() {
        return request.getApiResponseResults();
    }

    public String[] getApiResponseKeys() {
        return request.getApiResponseKeys();
    }
}

