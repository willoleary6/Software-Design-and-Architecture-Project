/*package interceptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggingDispatcherTest {
    private LoggingDispatcher testDispatcher;
    private LoggingInterceptor firstInterceptor;
    @BeforeEach
    void setUp() {
        testDispatcher = testDispatcher.getCurrentInstance();
        firstInterceptor = new LoggingInterceptor() {
            LogToServerInterceptor testLog = new LogToServerInterceptor();
            @Override
            public void onLogRequest(LogMessage context) {
                testLog.processNewLogMessage(context);
            }
        };
        testDispatcher.getCurrentInstance().registerLogRequestInterceptor(firstInterceptor);
    }

    @Test
    void getNumberOfInterceptors() {
        int results = testDispatcher.getNumberOfInterceptors();
        int answer = 4;

        assertEquals(answer ,results);
    }

    @Test
    void getCurrentInstance() {
        LoggingDispatcher result = testDispatcher.getCurrentInstance();
        LoggingDispatcher answer = testDispatcher;
        assertEquals(answer,result);
    }

    @Test
    void registerLogRequestInterceptor() {
        int answer = testDispatcher.getNumberOfInterceptors()+1;
        LoggingInterceptor interceptor = new LoggingInterceptor() {
            LogToServerInterceptor testLog = new LogToServerInterceptor();
            @Override
            public void onLogRequest(LogMessage context) {
                testLog.processNewLogMessage(context);
            }
        };
        testDispatcher.getCurrentInstance().registerLogRequestInterceptor(interceptor);
        int result =  testDispatcher.getNumberOfInterceptors();
        assertEquals(answer,result);
    }

    @Test
    void removeLogRequestInterceptor() {
        int answer = testDispatcher.getNumberOfInterceptors()-1;
        testDispatcher.getCurrentInstance().removeLogRequestInterceptor(firstInterceptor);
        int result =  testDispatcher.getNumberOfInterceptors();
        assertEquals(answer,result);
    }
}*/