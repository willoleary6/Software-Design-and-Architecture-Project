package backgroundServices.API_Handlers;

import org.json.JSONObject;

public interface Request {
    void makeRequest();
    JSONObject[] getApiResponseResults();
    String [] getApiResponseKeys();
}
