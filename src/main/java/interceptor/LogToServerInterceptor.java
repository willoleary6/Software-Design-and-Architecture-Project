package interceptor;

import backgroundServices.API_Handlers.insertRequestHandler;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class LogToServerInterceptor implements LoggingInterceptor{

    private static LogToServerInterceptor myInterceptor;


    private void logMessageToServer(LoggingContext context){
        insertRequestHandler insertApiRequestHandler = new insertRequestHandler();
        insertApiRequestHandler.addNewLog(
                context.getUserID(),
                1,
                context.getLogMessage(),
                context.getExtendedDataInJSON()
        );

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
