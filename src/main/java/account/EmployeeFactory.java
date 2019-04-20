package account;

import org.json.JSONObject;

public class EmployeeFactory extends Factory{

    public EmployeeFactory(){}

    public User createUser(JSONObject user) {
        if(user.length() == 0) {
            return null;
        }
        else if(user.getInt("userType") == 2) {
            JSONObject airlineID = new JSONObject(user.getString("extendedDataInJSON"));
            return new AirlineEmployee(user.getString("username"), user.getInt("userID"),
                    user.getInt("userType"), airlineID.getInt("airlineID"));
        } else {
            return null;
        }
    }
}
