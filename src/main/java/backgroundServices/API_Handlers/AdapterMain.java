package backgroundServices.API_Handlers;


import backgroundServices.API_Handlers.requests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.requests.get.GetAllAirports;
import backgroundServices.API_Handlers.requests.insert.insertRequests.AddNewUser;

public class AdapterMain {
    public static void main(String[] args) {
        APIRequest apiGetRequest = new APIRequest();
        apiGetRequest.makeRequest(new GetAllAirports());

        APIRequest apiRequest = new APIRequest();
        apiRequest.makeRequest(new InsertRequestAdapter(new AddNewUser("Test", "Test", "Test")));
    }
}
