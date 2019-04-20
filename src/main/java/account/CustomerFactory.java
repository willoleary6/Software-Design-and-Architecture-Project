package account;


import org.json.JSONObject;

public class CustomerFactory extends Factory{

    public CustomerFactory(){}

    public User createUser(JSONObject user) {
        if(user.length() == 0) {
            return null;
        }
        else if(user.getInt("userType") == 0) {
            return new Customer(user.getString("username"), user.getInt("userID"),
                    user.getInt("userType"), user.getInt("loyaltyPoints"));
        } else {
            return null;
        }
    }

}
