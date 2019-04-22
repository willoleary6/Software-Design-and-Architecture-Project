package interceptor;

public interface LoggingInterceptor {
    void logIn(LoggingContext context);
    void logOut(LoggingContext context);
    void accountChange(LoggingContext context);
    void bookingMade(LoggingContext context);
}
