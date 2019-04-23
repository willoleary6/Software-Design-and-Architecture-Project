package backgroundServices.API_Handlers;

import backgroundServices.API_Handlers.requests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.requests.get.GetRequestHandler;
import backgroundServices.API_Handlers.requests.get.GetRequestTest;
import backgroundServices.resourceReader.Reader;
import org.json.JSONObject;

import java.util.Properties;

public class APIRequest {
    private final Reader myReader;
    private final Properties apiProperties;
    private JSONObject[] responseResult;
    private GetRequestTest request;

    public APIRequest() {
        myReader = new Reader();
        apiProperties = myReader.readFromResources("src/main/resources/APIs.properties");
    }

    public void makeRequest(GetRequestTest request) {
        this.request = request;
        this.request.makeRequest();
    }

    public JSONObject[] getApiResponseResults() {
        return request.getApiResponseResults();
    }

    public JSONObject[] getApiResponseResults() {
        return request.getApiResponseKeys();
    }
}

