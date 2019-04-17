package backgroundServices.API_Handlers.adapter;

import backgroundServices.API_Handlers.Request;
import backgroundServices.API_Handlers.ApiRequestHandler;
import org.json.JSONObject;

public class RequestAdapter implements Request, ApiRequestHandler {
    private final RequestType requestType;
    RequestAdapter (RequestType requestType) {
        super();
        this.requestType = requestType;
    }

    @Override
    public JSONObject[] getApiResponseResults() {
        return new JSONObject[0];
    }

    @Override
    public String[] getApiResponseKeys() {
        return new String[0];
    }

    @Override
    public void getRequest() {

    }

    @Override
    public void insertRequest() {

    }
}
