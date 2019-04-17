package backgroundServices.API_Handlers;

import org.json.JSONObject;

/* File name : Animal.java */
public interface ApiRequestHandler {
    JSONObject[] getApiResponseResults();
    String [] getApiResponseKeys();
}