package interceptor;

import java.util.ArrayList;

public class NewLoggingDispatcher implements NewLoggingInterceptor {

    ArrayList<NewLoggingInterceptor> interceptors = new ArrayList<>();

    private static NewLoggingDispatcher myDispatcher;

    private NewLoggingDispatcher() {

    }

    @Override
    public void logIn(LoggingContext context) {
        for(NewLoggingInterceptor i : interceptors)
            i.logIn(context);
    }

    @Override
    public void logOut(LoggingContext context) {
        for(NewLoggingInterceptor i : interceptors)
            i.logOut(context);
    }

    @Override
    public void accountChange(LoggingContext context) {
        for(NewLoggingInterceptor i : interceptors)
            i.accountChange(context);
    }

    @Override
    public void bookingMade(LoggingContext context) {
        for(NewLoggingInterceptor i : interceptors)
            i.bookingMade(context);
    }

    public void registerInterceptor(NewLoggingInterceptor interceptor) {
        interceptors.add(interceptor);
        System.out.println("New interceptor added");
    }

    public void removeInterceptor(NewLoggingInterceptor interceptor) {
        interceptors.remove(interceptor);
        System.out.println("Interceptor removed");
    }

    public static NewLoggingDispatcher getInstanceOfDispatcher() {
        if(myDispatcher == null) {
            myDispatcher = new NewLoggingDispatcher();
            return myDispatcher;
        } else
            return myDispatcher;
    }

}
