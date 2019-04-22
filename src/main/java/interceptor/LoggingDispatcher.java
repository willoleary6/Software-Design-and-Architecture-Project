package interceptor;

import java.util.ArrayList;

public class LoggingDispatcher implements LoggingInterceptor {

    ArrayList<LoggingInterceptor> interceptors = new ArrayList<>();

    private static LoggingDispatcher myDispatcher;

    private LoggingDispatcher() {

    }

    @Override
    public void logIn(LoggingContext context) {
        for(LoggingInterceptor i : interceptors)
            i.logIn(context);
    }

    @Override
    public void logOut(LoggingContext context) {
        for(LoggingInterceptor i : interceptors)
            i.logOut(context);
    }

    @Override
    public void accountChange(LoggingContext context) {
        for(LoggingInterceptor i : interceptors)
            i.accountChange(context);
    }

    @Override
    public void bookingMade(LoggingContext context) {
        for(LoggingInterceptor i : interceptors)
            i.bookingMade(context);
    }

    public void registerInterceptor(LoggingInterceptor interceptor) {
        interceptors.add(interceptor);
        System.out.println("New interceptor added");
    }

    public void removeInterceptor(LoggingInterceptor interceptor) {
        interceptors.remove(interceptor);
        System.out.println("Interceptor removed");
    }

    public static LoggingDispatcher getInstanceOfDispatcher() {
        if(myDispatcher == null) {
            myDispatcher = new LoggingDispatcher();
            return myDispatcher;
        } else
            return myDispatcher;
    }

}
