package interceptor;

public interface LoggingInterceptor {
    void onLogRequest(LogMessage context);
}
