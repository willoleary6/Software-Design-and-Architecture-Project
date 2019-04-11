package prototypes.interceptor;

public class Application {
    public void LogIn(Context currentContext, Dispatcher currentDispatcher){
        // creating a new interceptor to take this actions
        Interceptor logInInterceptor = ConcreteInterceptor.getInstanceOfInterceptorAction();

        currentDispatcher.registerDispatcher(logInInterceptor);
        currentDispatcher.preRequest(currentContext);
    }

    public void LogOut(Context currentContext, Dispatcher currentDispatcher){
        // creating a new interceptor to take this actions
        Interceptor logOutInterceptor = ConcreteInterceptor.getInstanceOfInterceptorAction();

        currentDispatcher.registerDispatcher(logOutInterceptor);
        currentDispatcher.preRequest(currentContext);
    }
}
