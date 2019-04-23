package account;

import backgroundServices.API_Handlers.APIRequest;
import backgroundServices.API_Handlers.apiRequests.getRequest.GetBookingByID;
import org.json.JSONObject;

public class Customer extends User implements UserVisitable {

    private LoyaltyPoints points;
    private JSONObject[] bookings;

    public Customer(String userName, int userID, int userType, int loyaltyPoints){
        this.setUserName(userName);
        this.setUserID(userID);
        this.setUserType(userType);
        points = new LoyaltyPoints(loyaltyPoints);
    }

    public LoyaltyPoints getPoints() {
        return points;
    }

    @Override
    public void accept(UserVisitor visitor) {
        visitor.visit(this);
    }

    public void showBookings() {
        for(JSONObject i : bookings)
        System.out.println(i);
    }

    public boolean hasBookings(){
        APIRequest dbPullHandler = new APIRequest();
        dbPullHandler.makeRequest(new GetBookingByID(getUserID()));
        if(dbPullHandler.getApiResponseResults() == null)
            return false;
        else {
            bookings = dbPullHandler.getApiResponseResults();
            return true;
        }
    }
}
