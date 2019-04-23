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

    public APIRequest() {
        myReader = new Reader();
        apiProperties = myReader.readFromResources("src/main/resources/APIs.properties");
    }

    public void makeRequest(GetRequestTest request) {
        request.getApiResponseResults();
        request.getApiResponseKeys();
        request.makeRequest();
        // System.out.println(request.getApiResponseResults()[0]);
        if (request instanceof GetRequestHandler)
            System.out.println("Get All Airports");
        else if(request instanceof InsertRequestAdapter)
            System.out.println("Other");

    }

    /*public JSONObject[] getApiResponseResults() {
        return getApiResponseResults();
    }*/
}

