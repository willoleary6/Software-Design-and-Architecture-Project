package interceptor;

import java.util.ArrayList;

public class LogToServer {
    private ArrayList<LogMessage> messagesCache = new ArrayList<>();

    public void processNewLogMessage(LogMessage newMessage){
        messagesCache.add(newMessage);
        ArrayList<Boolean> messagesToRemoveFromCache = new ArrayList<>();
        for(int i = 0; i < messagesCache.size(); i++){
            messagesToRemoveFromCache.add(logMessageToServer(messagesCache.get(i)));
        }
        int offsetCounter = 0;
        for(int j = 0; j < messagesToRemoveFromCache.size(); j++){
            if (messagesToRemoveFromCache.get(j)){
                messagesCache.remove(messagesCache.get(j + offsetCounter));
                offsetCounter--;
            }
        }
    }

    public int getSizeOfMessageCache(){
        return messagesCache.size();
    }

    private Boolean logMessageToServer(LogMessage newMessage){
        System.out.println(
                "User id: "+newMessage.getUserID()+"\n"+
                "loggingType: "+newMessage.getLoggingType()+"\n"+
                "logMessage: "+newMessage.getLogMessage()+"\n"+
                "extendedData: "+newMessage.getExtendedDataInJSON()
        );
        return true;
    }
}
