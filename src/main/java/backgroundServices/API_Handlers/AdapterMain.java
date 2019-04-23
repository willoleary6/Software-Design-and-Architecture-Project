package backgroundServices.API_Handlers;


import backgroundServices.API_Handlers.apiRequests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.apiRequests.getRequest.GetAllAirports;
import backgroundServices.API_Handlers.apiRequests.insertRequest.AddNewUser;

public class AdapterMain {
    public static void main(String[] args) {
        APIRequest apiGetRequest = new APIRequest();
        apiGetRequest.makeRequest(new GetAllAirports());

        APIRequest apiRequest = new APIRequest();
        apiRequest.makeRequest(new InsertRequestAdapter(new AddNewUser("Test", "Test", "Test")));
    }
}
