package reservation;

import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;

public class Hotel {
    private String hotelName;
    private int airportID;
    private int liaisonUserID;
    private JSONObject additionalServices;

    public Hotel(String hotelName, int airportID, int liaisonUserID, JSONObject additionalServices){
        this.hotelName = hotelName;
        this.airportID = airportID;
        this.liaisonUserID = liaisonUserID;
        this.additionalServices = additionalServices;
    }

    public String getHotelName(){
        return this.hotelName;
    }

    public int getAirportID(){
        return this.airportID;
    }

    public int getLiaisonUserID(){
        return this.liaisonUserID;
    }


}
