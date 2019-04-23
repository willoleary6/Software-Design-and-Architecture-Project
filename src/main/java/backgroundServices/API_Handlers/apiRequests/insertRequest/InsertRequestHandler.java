package backgroundServices.API_Handlers.apiRequests.insertRequest;

import backgroundServices.resourceReader.Reader;
import org.json.JSONObject;

import java.util.Properties;

public abstract class InsertRequestHandler implements InsertRequestTest {
    protected Reader myReader;
    protected Properties apiProperties;
    protected JSONObject apiResponse;

    protected InsertRequestHandler() {
        myReader = new Reader();
        apiProperties = myReader.readFromResources("src/main/resources/APIs.properties");
    }

    public  boolean requestIsSuccessful(){
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
        return true;
    }
}
