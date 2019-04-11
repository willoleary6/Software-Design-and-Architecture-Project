package prototypes.interceptor;

import java.util.ArrayList;

public class ConcreteInterceptor implements Interceptor {
    // logging actions
    private ArrayList<String> DetailsOfLogin = new ArrayList<String>();
    private ArrayList<String> DetailsOfLogout = new ArrayList<String>();

    private static ConcreteInterceptor interceptorAction;

    private ConcreteInterceptor() {

    }
    public static ConcreteInterceptor getInstanceOfInterceptorAction(){
        if(interceptorAction == null){
            return new ConcreteInterceptor();
        }else{
            return interceptorAction;
        }
    }

    public void preRequest(Context context){
        System.out.println("The time when\t"+context.getUserName()+"\tuser is connected\t"+context.getTimeOccurred());
        DetailsOfLogin.add(context.getUserName()+"\t"+context.getTimeOccurred());
    }

    public void postRequest(Context context){
        System.out.println("The time when\t"+context.getUserName()+"\tuser is connected\t"+context.getTimeOccurred());
        DetailsOfLogout.add(context.getUserName()+"\t"+context.getTimeOccurred());
    }

}
