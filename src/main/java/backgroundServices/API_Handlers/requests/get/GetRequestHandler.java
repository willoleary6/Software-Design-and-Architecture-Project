package backgroundServices.API_Handlers.requests.get;

import backgroundServices.resourceReader.Reader;
import org.json.JSONObject;

import java.util.Properties;

public abstract class GetRequestHandler implements GetRequestTest  {
    protected Reader myReader;
    protected Properties apiProperties;
    protected JSONObject apiResponse;

    protected GetRequestHandler() {
        myReader = new Reader();
        apiProperties = myReader.readFromResources("src/main/resources/APIs.properties");
    }

    /**
     * Method that formats the AWS response to the last query executed and returns a JSON object.
     * @return Returns an array of JSONObjects that contain the response from AWS.
     */
    public JSONObject[] getApiResponseResults() {
        // getRequest the raw results data and remove any characters we cant play with.
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
            if(!resultsArray[i].isEmpty()){
                formatedDataFromAPI[i] = new JSONObject(resultsArray[i]);
            }

        }
        return formatedDataFromAPI;
    }

    /**
     * Method that formats and returns an array of keys to be used access the server response of the last query.
     * @return String array containing the keys to the last server response.
     */
    public String [] getApiResponseKeys() {
        // remove any problem characters and split it on the comma.

        return apiResponse.get("keys").toString()
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll(" ", "")
                .replaceAll("\"", "").split(",");
    }

}
