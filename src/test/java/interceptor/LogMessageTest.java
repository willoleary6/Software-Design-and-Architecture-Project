package interceptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteLogMessageTest {
    private ConcreteLogMessage testLogMessage;
    @BeforeEach
    void setUp() {
        int userID = 1;
        int logType = 1;
        String logMessage = "Test";
        String extendedDataInJSON = "";
        testLogMessage = new ConcreteLogMessage(userID, logType, logMessage, extendedDataInJSON);
    }

    @Test
    void getUserID() {
        int result = testLogMessage.getUserID();
        int trueResult = 1;
        assertEquals(trueResult, result);
    }

    @Test
    void getLoggingType() {
        int result = testLogMessage.getLoggingType();
        int trueResult = 1;
        assertEquals(trueResult, result);
    }

    @Test
    void getLogMessage() {
        String result = testLogMessage.getLogMessage();
        String trueResult = "Test";
        assertEquals(trueResult, result);
    }

    @Test
    void getExtendedDataInJSON() {
        String result = testLogMessage.getExtendedDataInJSON();
        String trueResult = "";
        assertEquals(trueResult, result);
    }
}