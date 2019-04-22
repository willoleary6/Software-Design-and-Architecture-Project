package interceptor;

import backgroundServices.API_Handlers.insertRequestHandler;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class LogToServerInterceptor implements LoggingInterceptor{

    private static LogToServerInterceptor myInterceptor;

    /*public void processNewLogMessage(LogMessage newMessage){
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
    }*/


    private void logMessageToServer(LoggingContext context){
        insertRequestHandler insertApiRequestHandler = new insertRequestHandler();
        insertApiRequestHandler.addNewLog(
                context.getUserID(),
                1,
                context.getLogMessage(),
                context.getExtendedDataInJSON()
        );
        //JSONObject[] responseKeys = insertApiRequestHandler.getApiResponseResults();
        /*if(Arrays.toString(responseKeys).equals("[{\"result\":null}]")){
            return true;
        }
        return false;*/
    }

    @Override
    public void logIn(LoggingContext context) {
        logMessageToServer(context);
    }

    @Override
    public void logOut(LoggingContext context) {
        logMessageToServer(context);
    }

    @Override
    public void accountChange(LoggingContext context) {
        logMessageToServer(context);
    }

    @Override
    public void bookingMade(LoggingContext context) {
        logMessageToServer(context);
    }

    public static LoggingInterceptor getInstanceOfInterceptor(){
        if(myInterceptor == null) {
            myInterceptor = new LogToServerInterceptor();
            return myInterceptor;
        }
        else
            return myInterceptor;
    }
}
