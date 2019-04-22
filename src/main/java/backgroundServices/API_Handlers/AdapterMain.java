package backgroundServices.API_Handlers;


import backgroundServices.API_Handlers.adapter.OtherAPIRequestAdapter;
import backgroundServices.API_Handlers.requests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.requests.get.GetAllAirports;
import backgroundServices.API_Handlers.requests.get.GetRequestHandler;
import backgroundServices.API_Handlers.requests.insert.AddNewUser;
import backgroundServices.API_Handlers.requests.insert.InsertRequestHandler;
import org.omg.CORBA.Request;

public class AdapterMain {
    public static void main(String[] args) {
        /*GetAllAirports getAllAirports = new GetAllAirports();
        getAllAirports.makeRequest();
        System.out.println(getAllAirports.getApiResponseResults()[0]);

        AddNewUser addNewUser = new AddNewUser("Test", "Test", "Test");
        addNewUser.makeRequest();
        System.out.println(addNewUser.requestIsSuccessful());*/

        APIRequest apiGetRequest = new APIRequest();
        apiGetRequest.makeRequest(new GetAllAirports());

        APIRequest apiRequest = new APIRequest();
        apiRequest.makeRequest(new InsertRequestAdapter(new AddNewUser("Test", "Test", "Test")));
    }
}
