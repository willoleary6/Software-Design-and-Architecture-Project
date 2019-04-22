package backgroundServices.API_Handlers.adapter;


import backgroundServices.API_Handlers.GetRequest;
import org.json.JSONObject;

public class OtherAPIRequestAdapter implements GetRequest {
    private OtherAPIRequests adaptee;

    public OtherAPIRequestAdapter(OtherAPIRequests adaptee) {
        super();
        this.adaptee = adaptee;
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
