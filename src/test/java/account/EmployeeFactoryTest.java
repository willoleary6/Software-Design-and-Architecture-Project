package account;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    Factory factory = new EmployeeFactory();

    // Test passes an empty json to factory expects null back
    @Test
    void createUserEmptyJson() {
        User a =  factory.createUser(new JSONObject());
        assertEquals(a, null);
    }

    // passes a json with wrong user type expects null
    @Test
    void createUserWrongType() {
        User a =  factory.createUser(new JSONObject("{userType : 0}"));
        assertEquals(a, null);
    }

    // passes correct json and expects correct object returned
    @Test
    void createUserCorrect() {
        JSONObject obj = new JSONObject("{userType : 1, username: unitTest, userID: 69," +
                " extendedDataInJSON: 675}");
        AirlineEmployee a =  (AirlineEmployee)factory.createUser(obj);
        AirlineEmployee correctA = new AirlineEmployee("unitTest", 69, 1, 675);
        assertEquals(a.getUserName(), correctA.getUserName());
        assertEquals(a.getAirlineID(),correctA.getAirlineID());
        assertEquals(a.getUserType(), correctA.getUserType());
        assertEquals(a.getUserID(), correctA.getUserID());
    }
}