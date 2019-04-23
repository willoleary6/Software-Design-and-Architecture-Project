package Utilities;

import backgroundServices.API_Handlers.APIRequest;
import backgroundServices.API_Handlers.apiRequests.getRequest.GetDiscountsByFlightID;
import org.json.JSONObject;
import routeCalculation.Airport;
import routeCalculation.Flight;
import routeCalculation.FlightDiscountDecorator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JsonObjectConverter {
    private APIRequest dbHandler;

    public JsonObjectConverter(){
        dbHandler = new APIRequest();
    }

    public FlightDiscountDecorator jsonObjectToFlightDecorator(JSONObject jsonObject) {
        JSONObject depart = new JSONObject(jsonObject.getString("departureTime"));
        JSONObject arrive = new JSONObject(jsonObject.getString("arrivalTime"));
        return new FlightDiscountDecorator( new Flight(
                jsonObject.getInt("autoID"),
                jsonObject.getInt("departureAirport"),
                jsonObject.getInt("destinationAirport"),
                jsonObject.getInt("airlineID"),
                jsonObject.getString("flightNumber"),
                depart.getString("time"), arrive.getString("time"), depart.getString("day"),
                arrive.getString("day"),
                jsonObject.getInt("price")
        ), retrieveDiscountByFlightID(jsonObject.getInt("autoID")));

    }

    public Flight jsonObjectToFlight(JSONObject jsonObject) {
        JSONObject depart = new JSONObject(jsonObject.getString("departureTime"));
        JSONObject arrive = new JSONObject(jsonObject.getString("arrivalTime"));
        return new Flight(
                jsonObject.getInt("autoID"),
                jsonObject.getInt("departureAirport"),
                jsonObject.getInt("destinationAirport"),
                jsonObject.getInt("airlineID"),
                jsonObject.getString("flightNumber"),
                depart.getString("time"), arrive.getString("time"), depart.getString("day"),
                arrive.getString("day"),
                jsonObject.getInt("price")
        );

    }
    public Airport jsonObjectToAirport(JSONObject jsonObject) {
        return new Airport(jsonObject.getInt("autoID"),jsonObject.getString("name"));
    }

    private double retrieveDiscountByFlightID(int flightID){
        dbHandler.makeRequest(new GetDiscountsByFlightID(flightID));
        try {
            JSONObject[] response = dbHandler.getApiResponseResults();
            Double percentageDiscount = 0.0;
            Date now = new Date();
            Date startOfDiscount;
            Date endOfDiscount;
            DateFormat format = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss", Locale.ENGLISH);
            for(int i = 0; i < response.length;i++){
                startOfDiscount = format.parse(response[i].getString("discountStartDate"));
                endOfDiscount = format.parse(response[i].getString("discountEndDate"));
                if(startOfDiscount.getTime() < now.getTime() && endOfDiscount.getTime() > now.getTime()){
                    percentageDiscount+= response[i].getDouble("discountPercentage");
                }
            }
            return percentageDiscount;
        }catch (Exception e){
            return 0;
        }


    }
}
