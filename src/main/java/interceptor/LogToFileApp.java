package interceptor;

public class LogToFileApp {

    public void loggingRegister(NewLoggingDispatcher dispatcher){
        NewLoggingInterceptor logging = LogToFile.getInstanceOfInterceptor();
        dispatcher.registerInterceptor(logging);
    }

    public void removeInterceptor(NewLoggingDispatcher dispatcher){
        NewLoggingInterceptor logging = LogToFile.getInstanceOfInterceptor();
        dispatcher.removeInterceptor(logging);
    }
}
