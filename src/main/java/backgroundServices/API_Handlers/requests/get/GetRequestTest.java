package backgroundServices.API_Handlers.requests.get;

import org.json.JSONObject;

public interface GetRequestTest {
    void makeRequest();
    JSONObject[] getApiResponseResults();
    String [] getApiResponseKeys();
}
