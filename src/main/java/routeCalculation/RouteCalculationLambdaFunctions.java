package routeCalculation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;

public interface RouteCalculationLambdaFunctions {

    int initialise();

    default ArrayList<Route> eliminateDuplicateTargets(ArrayList<Route> routes){
        ArrayList<Route> listOfAirports = new ArrayList<Route>();
        Route routeToRemove = null;
        Route matchedWith = null;
        for(Route currentRoute : routes){
            matchedWith = checkForDuplicate(listOfAirports, currentRoute.getDestination());
            if(matchedWith == null){
                listOfAirports.add(currentRoute);
            }else{
                routeToRemove = currentRoute;
                break;
            }
        }
        if(routeToRemove != null){
            if(calculateCostOfTraceBack(matchedWith, routes) <= calculateCostOfTraceBack(routeToRemove, routes)){
                routes.remove(matchedWith);
            }else {
                routes.remove(routeToRemove);
            }
            return eliminateDuplicateTargets(routes);
        }
        return routes;
    }

    default Route checkForDuplicate(ArrayList<Route> listOfRoutes, Airport currentAirport){
        for(Route airportCheck : listOfRoutes){
            if(airportCheck.getDestination() == currentAirport){
                return airportCheck;
            }
        }
        return null;
    }

    default double calculateCostOfTraceBack(Route routeToTraceBack, ArrayList<Route> listOfRoutes){
        double summaryCost = 0;
        Airport originAirport = routeToTraceBack.getOrigin();
        while (getRouteWithSpecifiedDestination(originAirport, listOfRoutes) != null) {
            summaryCost += routeToTraceBack.getCost();
            routeToTraceBack = getRouteWithSpecifiedDestination(originAirport, listOfRoutes);
            originAirport = routeToTraceBack.getOrigin();
        }
        return summaryCost;
    }


    default Route getRouteWithSpecifiedDestination(Airport target, ArrayList<Route> listOfRoutes) {
        for(int i = 0; i < listOfRoutes.size(); i++){
            if(listOfRoutes.get(i).getDestination().getAirportName().equals(target.getAirportName())){
                return listOfRoutes.get(i);
            }
        }
        return null;
    }

    default Airport getAirportByID(int airportID, ArrayList<Airport> listOfAirports) {
        Airport toReturn = null;
        for (int i = 0; i < listOfAirports.size(); i++) {
            if (airportID == listOfAirports.get(i).getAutoKey())
                toReturn = listOfAirports.get(i);
        }
        return toReturn;
    }

    default Date convertFlightTimeToDate(String day, String hour, Date startingDate){
        int minutes = 60*1000;
        LocalDate ld = startingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        ld = ld.with(TemporalAdjusters.next(DayOfWeek.valueOf(day.toUpperCase())));
        Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int minutesPassedInDay = convertStringToMinutes(hour);
        return new Date(date.getTime() + minutesPassedInDay * minutes);
    }

    default int convertStringToMinutes(String stringTime){
        String [] hoursAndMinutes = stringTime.split(":");
        int hoursToMinutes = Integer.parseInt(hoursAndMinutes[0])*60;
        int minutes = Integer.parseInt(hoursAndMinutes[1]);
        return hoursToMinutes+minutes;
    }
}
