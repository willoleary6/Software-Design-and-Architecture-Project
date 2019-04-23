import interceptor.*;
import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // create interceptor applications
        LogToFileApp userLogFile = new LogToFileApp();
        LogToServerApp userLogServer = new LogToServerApp();

        // get instance of dispatcher
        LoggingDispatcher dispatcher = LoggingDispatcher.getInstanceOfDispatcher();

        // create and register interceptors
        userLogFile.loggingRegister(dispatcher);
        userLogServer.loggingRegister(dispatcher);

        ILoginCoordinator loginCoordinator = new LoginCoordinator();
        loginCoordinator.start();

    }
}
