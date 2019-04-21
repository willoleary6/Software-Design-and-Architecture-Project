package interceptor;

public class LogToFileApp {

    public void loggingRegister(NewLoggingDispatcher dispatcher){
        NewLoggingInterceptor logging = LogToFileInterceptor.getInstanceOfInterceptor();
        dispatcher.registerInterceptor(logging);
    }

    public void removeInterceptor(NewLoggingDispatcher dispatcher){
        NewLoggingInterceptor logging = LogToFileInterceptor.getInstanceOfInterceptor();
        dispatcher.removeInterceptor(logging);
    }
}
