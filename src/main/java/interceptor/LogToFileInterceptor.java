package interceptor;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogToFileInterceptor implements NewLoggingInterceptor {

    private static LogToFileInterceptor myInterceptor;
    private File file = new File("src/main/log/log.txt");
    private String filePath = "src/main/log/log.txt";
    private DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private LogToFileInterceptor(){

    }

    @Override
    public void logIn(LoggingContext context) {
        Date date = new Date();
        String output = "user id: " + context.getUserID() + ", username: " + context.getUsername() + ", msg: " +
                context.getLogMessage() + " at " + sdf.format(date) + "\n";
        System.out.println(output);
        writeToFile(output);
    }

    @Override
    public void logOut(LoggingContext context) {
        Date date = new Date();
        String output = "user id: " + context.getUserID() + ", username: " + context.getUsername() + ", msg: " +
                context.getLogMessage() + " at " + sdf.format(date);
        System.out.println(output);
        writeToFile(output);
    }

    @Override
    public void accountChange(LoggingContext context) {
        Date date = new Date();
        String output = "user id: " + context.getUserID() + ", AirlineID: " + context.getAirlineID() +
                ", username: " + context.getUsername() + ", msg: " + context.getLogMessage() + " flightID: "
                + context.getFlightID() + " at " + sdf.format(date);
        System.out.println(output);
        writeToFile(output);
    }

    @Override
    public void bookingMade(LoggingContext context) {
        Date date = new Date();
        String output = "user id: " + context.getUserID() + ", username: " + context.getUsername() + ", msg: " +
                context.getLogMessage() + " at " + sdf.format(date);
        System.out.println(output);
        writeToFile(output);
    }

    public static NewLoggingInterceptor getInstanceOfInterceptor(){
        if(myInterceptor == null)
            return new LogToFileInterceptor();
        else
            return myInterceptor;
    }


    public void writeToFile(String output) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(output);
            writer.newLine();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
