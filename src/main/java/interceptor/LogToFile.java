package interceptor;

public class LogToFile implements NewLoggingInterceptor {

    private static LogToFile myInterceptor;

    private LogToFile(){

    }

    @Override
    public void logIn(LoggingContext context) {
        System.out.println(context.getUserID() + " Logged in");
    }

    @Override
    public void logOut(LoggingContext context) {
        System.out.println(context.getUserID() + " Logged out");
    }

    @Override
    public void accountChange(LoggingContext context) {
        System.out.println(context.getUserID());
    }

    @Override
    public void bookingMade(LoggingContext context) {
        System.out.println(context.getUserID());
    }

    public static NewLoggingInterceptor getInstanceOfInterceptor(){
        if(myInterceptor == null)
            return new LogToFile();
        else
            return myInterceptor;
    }
}
