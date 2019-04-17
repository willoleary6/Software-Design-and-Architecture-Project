package reservation;

import org.json.JSONObject;

public class Hotel {
    private String hotelName;
    private int airportID;
    private int liaisonUserID;
    private HotelService [] additionalServices;

    public Hotel(String hotelName, int airportID, int liaisonUserID, JSONObject extendedDataInJSON){
        this.hotelName = hotelName;
        this.airportID = airportID;
        this.liaisonUserID = liaisonUserID;
        this.additionalServices = extractAdditionalServicesFromExtendedDataInJSON(extendedDataInJSON);
    }

    private HotelService [] extractAdditionalServicesFromExtendedDataInJSON(JSONObject extendedDataInJSON){
        try{

            // getRequest the raw results data and remove any characters we cant play with.
            String results = extendedDataInJSON.get("additional_services").toString()
                    .replaceAll("\\[", "").replaceAll("\\]", "");
            /*
             Since we need to convert this string to an array we need to
             specify where to split the string with out causing "issues".
            */
            results = results.toString()
                    .replaceAll("\\},", "}~,");

            String [] resultsArray = results.split("~,") ;
            // store results in array of JSONs
            HotelService [] listOfHotelServices = new HotelService[resultsArray.length];
            for (int i = 0; i < resultsArray.length; i++){
                if(!resultsArray[i].isEmpty()){
                    JSONObject tempJSONObject =  new JSONObject(resultsArray[i]);
                    listOfHotelServices[i] = new HotelService(tempJSONObject.getString("name"),
                            tempJSONObject.getDouble("price"),tempJSONObject.getString("description"));
                }

            }
            return listOfHotelServices;
       }catch (Exception e){
           return null;
       }
    }

    public HotelService [] getAdditionalServices(){
        return additionalServices;
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
