package account;

import control.AirlineAccountController;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class VisitorTest {
    Factory factory;


    @Test
    void airlineVisitor(){
        factory = new EmployeeFactory();
        JSONObject obj = new JSONObject("{userType : 2, username: unitTest, userID: 69," +
                " extendedDataInJSON: \"{airlineID: 1}\"}");
        AirlineEmployee user =  (AirlineEmployee)factory.createUser(obj);
        AirlineAccountController control = new AirlineAccountController(user);
        //control.cancelFlight();
    }
}
