import interceptor.*;
import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogToFileApp userLog = new LogToFileApp();
        NewLoggingDispatcher dispatcher = NewLoggingDispatcher.getInstanceOfDispatcher();
        userLog.loggingRegister(dispatcher);
        ILoginCoordinator loginCoordinator = new LoginCoordinator();
        loginCoordinator.start();

    }
}
