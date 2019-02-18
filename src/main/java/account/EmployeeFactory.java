package account;

import org.json.JSONObject;

public class EmployeeFactory extends Factory{

    public EmployeeFactory(){}

    public User createUser(JSONObject user) {
        if(user.getInt("userType") == 1) {
            return new AirlineEmployee(user.getString("username"), user.getInt("userID"),
                    user.getInt("userType"), user.getInt("extendedDataInJSON"));
        } else {
            return null;
        }
    }
}
