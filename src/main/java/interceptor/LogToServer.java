package interceptor;

import backgroundServices.API_Handlers.adapter.InsertRequestHandler;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class LogToServer {
    private ArrayList<LogMessage> messagesCache = new ArrayList<>();

    public void processNewLogMessage(LogMessage newMessage){
        messagesCache.add(newMessage);
        ArrayList<Boolean> messagesToRemoveFromCache = new ArrayList<>();
        for(int i = 0; i < messagesCache.size(); i++){
            messagesToRemoveFromCache.add(logMessageToServer(messagesCache.get(i)));
        }
        int offsetCounter = 0;
        for(int j = 0; j < messagesToRemoveFromCache.size(); j++){
            if (messagesToRemoveFromCache.get(j)){
                messagesCache.remove(messagesCache.get(j + offsetCounter));
                offsetCounter--;
            }
        }
    }

    public int getSizeOfMessageCache(){
        return messagesCache.size();
    }

    private Boolean logMessageToServer(LogMessage newMessage){
        InsertRequestHandler insertApiRequestHandler = new InsertRequestHandler();
        insertApiRequestHandler.addNewLog(
                newMessage.getUserID(),
                newMessage.getLoggingType(),
                newMessage.getLogMessage(),
                newMessage.getExtendedDataInJSON()
        );
        JSONObject[] responseKeys = insertApiRequestHandler.getApiResponseResults();
        if(Arrays.toString(responseKeys).equals("[{\"result\":null}]")){
            return true;
        }
        return false;
    }
}
