package interceptor;

public class LogToServerApp {

    public void loggingRegister(LoggingDispatcher dispatcher){
        LoggingInterceptor logging = LogToServerInterceptor.getInstanceOfInterceptor();
        dispatcher.registerInterceptor(logging);
    }

    public void removeInterceptor(LoggingDispatcher dispatcher){
        LoggingInterceptor logging = LogToServerInterceptor.getInstanceOfInterceptor();
        dispatcher.removeInterceptor(logging);
    }
}
