package account;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {
    Factory factory = new CustomerFactory();

    // Test passes an empty json to factory expects null back
    @Test
    void createUserEmptyJson() {
        User a =  factory.createUser(new JSONObject());
        assertEquals(a, null);
    }

    // passes a json with wrong user type expects null
    @Test
    void createUserWrongType() {
        User a =  factory.createUser(new JSONObject("{userType : 1}"));
        assertEquals(a, null);
    }

    // passes correct json and expects correct object returned
    @Test
    void createUserCorrect() {
        JSONObject obj = new JSONObject("{userType : 0, username: unitTest, userID: 69," +
                " loyaltyPoints: 67}");
        Customer a =  (Customer)factory.createUser(obj);
        Customer correctA = new Customer("unitTest", 69, 0, 67);
        assertEquals(a.getUserName(), correctA.getUserName());
        assertEquals(a.getPoints().getNumOfPoints(),correctA.getPoints().getNumOfPoints());
        assertEquals(a.getPoints().getValueOfPointsInEuro(), a.getPoints().getValueOfPointsInEuro());
        assertEquals(a.getUserType(), correctA.getUserType());
        assertEquals(a.getUserID(), correctA.getUserID());
    }
}