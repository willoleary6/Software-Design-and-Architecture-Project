import interceptor.*;
import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogToFileApp userLogFile = new LogToFileApp();
        LogToServerApp userLogServer = new LogToServerApp();
        LoggingDispatcher dispatcher = LoggingDispatcher.getInstanceOfDispatcher();
        userLogFile.loggingRegister(dispatcher);
        userLogServer.loggingRegister(dispatcher);
        ILoginCoordinator loginCoordinator = new LoginCoordinator();
        loginCoordinator.start();

    }
}
