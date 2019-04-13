package interceptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogToServerTest {
    private ConcreteLogMessage testMessage;
    private LogToServer testLogger;
    @BeforeEach
    void setUp() {
        int userID = 1;
        int logType = 1;
        String logMessage = "Test";
        String extendedDataInJSON = "";
        testMessage = new ConcreteLogMessage(userID, logType, logMessage, extendedDataInJSON);

        testLogger = new LogToServer();
    }
    @Test
    void processNewLogMessage() {
        int answer = testLogger.getSizeOfMessageCache();
        testLogger.processNewLogMessage(testMessage);
        int result =  testLogger.getSizeOfMessageCache();
        assertEquals(answer,result);
    }

    @Test
    void getSizeOfMessageCache() {
        int answer = testLogger.getSizeOfMessageCache();
        int result = 0;
        assertEquals(answer,result);
    }
}