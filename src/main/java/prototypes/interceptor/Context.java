package prototypes.interceptor;

public class Context {
    /*
    This object seems to be the courier as such of the messages past
    to the concrete interceptor.
     */
    private long timeOccurred;
    private String userName;

    Context(long timeOccurred, String userName){
        this.timeOccurred = timeOccurred;
        this.userName = userName;
    }


    public long getTimeOccurred() {
        return timeOccurred;
    }

    public String getUserName() {
        return userName;
    }
}
