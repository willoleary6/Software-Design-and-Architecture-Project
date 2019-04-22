package backgroundServices.API_Handlers.adapter;


import backgroundServices.API_Handlers.GetRequest;
import backgroundServices.API_Handlers.requests.get.GetRequestTest;
import org.json.JSONObject;

public class OtherAPIRequestAdapter implements GetRequestTest {
    private OtherAPIRequests adaptee;

    public OtherAPIRequestAdapter(OtherAPIRequests adaptee) {
        super();
        this.adaptee = adaptee;
    }

    @Override
    public void makeRequest() {

    }

    @Override
    public JSONObject[] getApiResponseResults() {
        return adaptee.getApiResponseResult();
    }

    @Override
    public String[] getApiResponseKeys() {
        return adaptee.getApiResponseKey();
    }
}
