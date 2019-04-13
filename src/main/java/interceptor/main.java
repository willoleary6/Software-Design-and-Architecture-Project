package interceptor;

public class main {
    public static void main (String [] args){
        LogToServer testLog = new LogToServer();
        int userID = 1;
        int logType = 1;
        String logMessage = "Test will ";
        String extendedDataInJSON = "";

        //testLog.proccessNewLogMessage(newMessage);

        LoggingInterceptor interceptor = new LoggingInterceptor() {
            LogToServer testLog = new LogToServer();
            @Override
            public void onLogRequest(LogMessage context) {
                testLog.processNewLogMessage(context);
            }
        };
        LoggingDispatcher.getCurrentInstance().registerLogRequestInterceptor(interceptor);
        // hooks simply copy and paste following commands to where ever else in the instance.
        ConcreteLogMessage newMessage = new ConcreteLogMessage(userID, logType, logMessage, extendedDataInJSON);
        LoggingDispatcher.getCurrentInstance().onLogRequest(newMessage);
    }
}
