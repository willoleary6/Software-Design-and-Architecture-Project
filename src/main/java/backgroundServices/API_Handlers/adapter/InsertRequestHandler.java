package backgroundServices.API_Handlers.adapter;

import backgroundServices.resourceReader.Reader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.util.Properties;

public class InsertRequestHandler implements OtherAPIRequests {
    private Properties apiProperties;
    private JSONObject apiResponse;

    public InsertRequestHandler(){
        Reader myReader = new Reader();
        apiProperties = myReader.readFromResources("src/main/resources/APIs.properties");
    }

    public void addNewUser(String username, String email, String password) {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewUser"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"username\":\""+username+"\"," +
                                    "\"email\":\""+email+"\"," +
                                    "\"password\":\""+password+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void addNewHotel(String hotelName, int airport, int liason, String extendedDataInJSON) {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewHotel"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"name\":\""+hotelName+"\"," +
                                    "\"airport\":\""+airport+"\"," +
                                    "\"liason\":\""+liason+"\"," +
                                    "\"extendedDataInJSON\":\""+extendedDataInJSON+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void addNewLog(int userID, int type, String message, String extendedDataInJSON) {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewLog"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"userID\":\""+userID+"\"," +
                                    "\"type\":\""+type+"\"," +
                                    "\"message\":\""+message+"\"," +
                                    "\"extendedDataInJSON\":\""+extendedDataInJSON+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }


    public void addNewDiscount(String userID, String flightID,String discountStartDate,
                               String discountEndDate, String discountPercentage) {
        try {
            HttpResponse<String> jsonResponse =
                    Unirest.post(apiProperties.getProperty("insertUrl")+apiProperties.getProperty("addNewDiscount"))
                            .header("accept", "application/json")
                            .body("" +
                                    "{" +
                                    "\"userID\":\""+userID+"\"," +
                                    "\"flightID\":\""+flightID+"\"," +
                                    "\"discountStartDate\":\""+discountStartDate+"\"," +
                                    "\"discountEndDate\":\""+discountEndDate+"\"," +
                                    "\"discountPercentage\":\""+discountPercentage+"\"" +
                                    "}")
                            .asString();

            apiResponse =  new JSONObject(jsonResponse.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that formats the AWS response to the last query executed and returns a JSON object.
     * @return Returns an array of JSONObjects that contain the response from AWS.
     */
    public JSONObject [] getApiResponseResult() {
        // getRequest the raw results data and remove any characters we cant play with.
        System.out.println(apiResponse);
        String results = apiResponse.get("results").toString()
                .replaceAll("\\[", "").replaceAll("\\]", "");
        /*
         Since we need to convert this string to an array we need to
         specify where to split the string with out causing "issues".
        */
        results = results.replaceAll("\\},", "}~,");

        String [] resultsArray = results.split("~,") ;
        // store results in array of JSONs
        JSONObject [] formatedDataFromAPI = new JSONObject[resultsArray.length];
        for (int i = 0; i < resultsArray.length; i++){
            formatedDataFromAPI[i] = new JSONObject("{result:"+resultsArray[i]+"}");
        }
        return formatedDataFromAPI;
    }

    /**
     * Method that formats and returns an array of keys to be used access the server response of the last query.
     * @return String array containing the keys to the last server response.
     */
    public String [] getApiResponseKey() {
        // remove any problem characters and split it on the comma.

        return apiResponse.get("keys").toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("\"", "").split(",");
    }

}
