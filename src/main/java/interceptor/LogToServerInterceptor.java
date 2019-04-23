package interceptor;

import backgroundServices.API_Handlers.APIRequest;
import backgroundServices.API_Handlers.apiRequests.adaptors.InsertRequestAdapter;
import backgroundServices.API_Handlers.apiRequests.insertRequest.AddNewLog;

public class LogToServerInterceptor implements LoggingInterceptor{

    private static LogToServerInterceptor myInterceptor;

    /*public void processNewLogMessage(LogMessage newMessage){
        messagesCache.add(newMessage);
        ArrayList<Boolean> messagesToRemoveFromCache = new ArrayList<>();
        for(int i = 0; i < messagesCache.size(); i++){
            messagesToRemoveFromCache.add(logMessageToServer(messagesCache.getRequest(i)));
        }
        int offsetCounter = 0;
        for(int j = 0; j < messagesToRemoveFromCache.size(); j++){
            if (messagesToRemoveFromCache.getRequest(j)){
                messagesCache.remove(messagesCache.getRequest(j + offsetCounter));
                offsetCounter--;
            }
        }
    }*/


    private void logMessageToServer(LoggingContext context){
        APIRequest insertApiRequestHandler = new APIRequest();
        insertApiRequestHandler.makeRequest(new InsertRequestAdapter(new AddNewLog(
                context.getUserID(),
                1,
                context.getLogMessage(),
                context.getExtendedDataInJSON()
        )));
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
