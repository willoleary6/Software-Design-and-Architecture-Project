package interceptor;

public class LoggingContext {
    private int userID;
    private String username;
    private int airlineID;
    private int flightID;
    private int bookingID;
    private String logMessage;
    private String extendedDataInJSON;

    public LoggingContext(int userID, String logMessage, String username){
        this.userID = userID;
        this.logMessage = logMessage;
        this.username = username;
        this.extendedDataInJSON = "";
    }

    public LoggingContext(int userID, String logMessage, String username, int bookingID){
        this.userID = userID;
        this.logMessage = logMessage;
        this.username = username;
        this.bookingID = bookingID;
        this.extendedDataInJSON = "";
    }

    public LoggingContext(int userID, String logMessage, String username, int airlineID, int flightID){
        this.userID = userID;
        this.logMessage = logMessage;
        this.username = username;
        this.airlineID = airlineID;
        this.flightID = flightID;
        this.extendedDataInJSON = "";
    }

    public int getUserID() {
        return userID;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public String getExtendedDataInJSON() {
        return extendedDataInJSON;
    }

    public String getUsername() {
        return username;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public void setExtendedDataInJSON(String extendedDataInJSON) {
        this.extendedDataInJSON = extendedDataInJSON;
    }
}
