package backgroundServices.API_Handlers.requests.adaptors;

import backgroundServices.API_Handlers.requests.get.GetRequestTest;
import backgroundServices.API_Handlers.requests.insert.InsertRequestHandler;
import org.json.JSONObject;

public class InsertRequestAdapter implements GetRequestTest {
    InsertRequestHandler insertRequest;
    public InsertRequestAdapter(InsertRequestHandler insertRequest){
        this.insertRequest = insertRequest;
    }

    @Override
    public void makeRequest() {
        insertRequest.makeRequest();
    }

    @Override
    public JSONObject[] getApiResponseResults() {
        Boolean success = insertRequest.requestIsSuccessful();
        JSONObject [] returnArray = { new JSONObject(
                "{" +
                        "results:"+success+
                        "}"
        )};
        return returnArray;
    }

    @Override
    public String[] getApiResponseKeys() {
        String [] keys = {"results"};
        return keys;
    }
}
