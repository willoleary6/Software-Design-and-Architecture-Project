package interceptor;

public class LogToFileApp {

    public void loggingRegister(LoggingDispatcher dispatcher){
        LoggingInterceptor logging = LogToFileInterceptor.getInstanceOfInterceptor();
        dispatcher.registerInterceptor(logging);
    }

    public void removeInterceptor(LoggingDispatcher dispatcher){
        LoggingInterceptor logging = LogToFileInterceptor.getInstanceOfInterceptor();
        dispatcher.removeInterceptor(logging);
    }
}
