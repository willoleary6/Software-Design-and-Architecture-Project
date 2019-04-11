package prototypes.interceptor;

public interface Interceptor {
    void preRequest(Context contextObject);
    void postRequest(Context contextObject);
}
