import interceptor.LogMessage;
import interceptor.LogToServer;
import interceptor.LoggingDispatcher;
import interceptor.LoggingInterceptor;
import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoggingInterceptor interceptor = new LoggingInterceptor() {
            LogToServer testLog = new LogToServer();
            @Override
            public void onLogRequest(LogMessage context) {
                testLog.processNewLogMessage(context);
            }
        };
        LoggingDispatcher.getCurrentInstance().registerLogRequestInterceptor(interceptor);

        ILoginCoordinator loginCoordinator = new LoginCoordinator();
        loginCoordinator.start();

    }
}
