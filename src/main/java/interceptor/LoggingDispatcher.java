package interceptor;

import java.util.ArrayList;

public class LoggingDispatcher implements LoggingInterceptor {
    private ArrayList<LoggingInterceptor> interceptors;
    private static LoggingDispatcher currentInstance;

    private LoggingDispatcher(){
        interceptors = new ArrayList<>();
    }

    public int getNumberOfInterceptors(){
        return interceptors.size();
    }

    public static LoggingDispatcher getCurrentInstance(){
        if(currentInstance == null){
            currentInstance = new LoggingDispatcher();
        }
        return currentInstance;
    }

    public void registerLogRequestInterceptor(LoggingInterceptor newInterceptor) {
        interceptors.add(newInterceptor);
    }

    public void removeLogRequestInterceptor(LoggingInterceptor interceptorToBeRemoved) {
        interceptors.remove(interceptorToBeRemoved);
    }

    @Override
    public void onLogRequest(LogMessage context) {
        LoggingInterceptor currentInterceptor = interceptors.get(interceptors.size()-1);
        currentInterceptor.onLogRequest(context);

    }
}
