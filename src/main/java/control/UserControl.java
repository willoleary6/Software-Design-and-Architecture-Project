package control;

import account.*;
import backgroundServices.API_Handlers.APIRequest;
import backgroundServices.API_Handlers.apiRequests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.apiRequests.getRequest.GetUserInformation;
import backgroundServices.API_Handlers.apiRequests.insertRequest.AddNewUser;
import org.json.JSONObject;

public class UserControl {

    private Factory factory;
    private FactoryProducer prodcuer;
    // simple factory pattern implemented to support extensibility of user types and to better manage dependencies
    private APIRequest dbPullHandler, dbInsertHandler;


    public UserControl(){
        prodcuer = new FactoryProducer();
        dbPullHandler = new APIRequest();
        dbInsertHandler = new APIRequest();
    }

    /**
     * Method that sets the user factory by using the factory producer based on the user type
     * then uses the user factory to create the user and return it
     */
    public User getUser(String username, String password) {
        dbPullHandler.makeRequest(new GetUserInformation(username, password));
        try {
            JSONObject[] obj = dbPullHandler.getApiResponseResults();
            // check credentials match then passes type to factory producer and passes object to factor
            if(obj[0].get("password").equals(password) && obj[0].get("username").equals(username)) {
                factory = prodcuer.produceFactory(obj[0].getInt("userType"));
                return factory.createUser(obj[0]);
            }
            else {
                return null;
            }
        } catch( Exception e) {
            return null;
        }
    }

    public User createUser(String username, String password, String email, int userType) {
        dbInsertHandler.makeRequest(new InsertRequestAdapter(new AddNewUser(username, email, password)));
        try {
            JSONObject[] obj = dbInsertHandler.getApiResponseResults();
            return getUser(username, password);
        } catch( Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private Boolean validateUsername(String username){
        String pattern = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        return username.matches(pattern);
    }

    private Boolean validatePassword(String password){
        String pattern = "(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,15})$";
        return password.matches(pattern);
    }


}
