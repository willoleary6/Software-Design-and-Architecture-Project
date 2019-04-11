package prototypes.interceptor;

public class ConcreteFrameWork {
    public static void main(String[] args) {
        // This is the start point

        // main dispatcher, looks like this boy will be used to create new interceptors
        Dispatcher myDispatcher = Dispatcher.getInstanceOfDispatcher();  // create dispatcher singleton
        // the object that executing the base task (log in)
        Application userLog = new Application();


        userLog.LogIn(new Context(System.nanoTime(),"user 1" ), myDispatcher);
        //userLog.LogIn(new Context(System.nanoTime(),"user 2" ), myDispatcher);


        userLog.LogOut(new Context(System.nanoTime(),"user 1" ), myDispatcher);
        //userLog.LogOut(new Context(System.nanoTime(),"user 2" ), myDispatcher);

    }
}
