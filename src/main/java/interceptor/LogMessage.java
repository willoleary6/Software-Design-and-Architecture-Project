package interceptor;

public interface LogMessage {
     int getUserID();
     int getLoggingType();
     String getLogMessage();
     String getExtendedDataInJSON();
}
