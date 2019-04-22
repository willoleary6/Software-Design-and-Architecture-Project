package backgroundServices.API_Handlers;

import org.json.JSONObject;

public interface GetRequest {
    JSONObject[] getApiResponseResults();
    String [] getApiResponseKeys();
}
