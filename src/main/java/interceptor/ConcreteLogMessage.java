package interceptor;

public class ConcreteLogMessage implements LogMessage{
    private int userID;
    private int loggingType;
    private String logMessage;
    private String extendedDataInJSON;

    public ConcreteLogMessage(int userID, int loggingType, String logMessage, String extendedDataInJSON){
        this.userID = userID;
        this.loggingType = loggingType;
        this.logMessage = logMessage;
        this.extendedDataInJSON = extendedDataInJSON;
    }

    public int getUserID() {
        return userID;
    }

    public int getLoggingType() {
        return loggingType;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public String getExtendedDataInJSON() {
        return extendedDataInJSON;
    }
}
