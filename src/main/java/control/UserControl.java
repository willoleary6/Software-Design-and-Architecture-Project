package control;

import account.CustomerFactory;
import account.EmployeeFactory;
import account.Factory;
import account.User;
import backgroundServices.API_Handlers.GetRequestHandler;
import backgroundServices.API_Handlers.InsertRequestHandler;
import org.json.JSONObject;

public class UserControl {

    private Factory factory;
    // simple factory pattern implemented to support extensibility of user types and to better manage dependencies
    private GetRequestHandler dbPullHandler;
    private InsertRequestHandler dbInsertHandler;


    public UserControl(){
        // dbPullHandler = new GetRequestHandler();
        dbPullHandler = new GetRequestHandler();
        dbInsertHandler = new InsertRequestHandler();
    }

    public User getUser(String username, String password){
        dbPullHandler.getUserInformation(username,password);
        try {
            JSONObject[] obj = dbPullHandler.getApiResponseResults();
            if(obj[0].get("password").equals(password) && obj[0].get("username").equals(username)) {
                if(obj[0].getInt("userType") == 0) {
                    factory = new CustomerFactory();
                    return factory.createUser(obj[0]);
                }
                else if (obj[0].getInt("userType") == 1){
                    factory = new EmployeeFactory();
                    return factory.createUser(obj[0]);
                } else
                    return null;
            }
            else {
                return null;
            }
        } catch( Exception e) {
            return null;
        }
    }

    public User createUser(String username, String password, String email, int userType){
        dbInsertHandler.addNewUser(username, email, password);
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
