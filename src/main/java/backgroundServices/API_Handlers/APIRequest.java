package backgroundServices.API_Handlers;

import backgroundServices.API_Handlers.requests.get.GetAllAirports;
import backgroundServices.API_Handlers.requests.get.GetRequestHandler;
import backgroundServices.API_Handlers.requests.get.GetRequestTest;
import backgroundServices.API_Handlers.requests.insert.InsertRequestHandler;
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
        request.makeRequest();
        System.out.println(request.getApiResponseResults()[0]);
        if (request instanceof GetRequestHandler)
            System.out.println("Get All Airports");
        else if(request instanceof InsertRequestHandler)
            System.out.println("Other");

    }
}
