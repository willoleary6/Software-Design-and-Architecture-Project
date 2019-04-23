package backgroundServices.API_Handlers.apiRequests.adaptors;

import backgroundServices.API_Handlers.Request;
import backgroundServices.API_Handlers.apiRequests.insertRequest.InsertRequestHandler;
import org.json.JSONObject;

public class InsertRequestAdapter implements Request {
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
