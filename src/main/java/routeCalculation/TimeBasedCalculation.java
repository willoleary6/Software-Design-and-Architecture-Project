package routeCalculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.PriorityQueue;

public class TimeBasedCalculation implements RouteCalculationStrategy {
    private RouteCalculationLambdaFunctions routeCalculationLambdaFunctions;

    public TimeBasedCalculation(){
        routeCalculationLambdaFunctions = () -> 0;
        routeCalculationLambdaFunctions.initialise();
    }
    @Override
    public ArrayList<Route> calculateBestRouteToDestination(Airport origin, Airport destination, Date departureDate, ArrayList<Airport> allAirports) {
        ArrayList<Route> chain_of_routes_to_every_destination = new ArrayList<>();
        origin.setMinimumDistance(0.);
        PriorityQueue<Airport> airportQueue = new PriorityQueue<Airport>();
        ArrayList<Airport> visitedAirports = new ArrayList<Airport>();

        // start with our departure airport
        airportQueue.add(origin);
        Date sourceDate = new Date();
        while (!airportQueue.isEmpty()) {
            Airport currentAirport = airportQueue.poll();
            // run through each of the flights leaving this airport.
            Date targetDate;
            for (Edge currentEdge :  currentAirport.getEdges()) {
                Flight currentFlight = ((FlightDiscountDecorator)currentEdge).getFlight();
                double costOfCurrentFlight, costThroughCurrentAirport;
                // find target airport through the flight destination
                Airport targetAirport = routeCalculationLambdaFunctions.getAirportByID(currentFlight.getTarget(), allAirports);
                // Date and time of arrival date for current flight
                targetDate = routeCalculationLambdaFunctions.convertFlightTimeToDate(currentFlight.getArriveDay(),
                        currentFlight.getArriveTime(), departureDate);
                costOfCurrentFlight = targetDate.getTime() - sourceDate.getTime();
                // calculate the cost of getting to this next node
                costThroughCurrentAirport = currentAirport.getMinimumDistance() + costOfCurrentFlight;
                if (costThroughCurrentAirport < targetAirport.getMinimumDistance()
                        && (!visitedAirports.contains(targetAirport))) {
                    // seems like a valid route, lets add it to our list
                    chain_of_routes_to_every_destination.add(new Route(currentAirport, targetAirport, currentEdge, currentEdge.getWeight()));
                    targetAirport.setMinimumDistance(costThroughCurrentAirport);
                    airportQueue.add(targetAirport);
                    visitedAirports.add(targetAirport);
                    sourceDate =  routeCalculationLambdaFunctions.convertFlightTimeToDate(currentFlight.getDepartDay(),
                            currentFlight.getDepartTime(), departureDate);
                    chain_of_routes_to_every_destination = routeCalculationLambdaFunctions.eliminateDuplicateTargets(chain_of_routes_to_every_destination);
                }
            }
        }

        Route traceBack;
        ArrayList<Route> routeToDestination = new ArrayList<Route>();
        do{
            traceBack = routeCalculationLambdaFunctions.getRouteWithSpecifiedDestination(destination, chain_of_routes_to_every_destination);
            destination = traceBack.getOrigin();
            routeToDestination.add(traceBack);
        }while(traceBack.getOrigin() != origin);
        Collections.reverse(routeToDestination);
        return routeToDestination;
    }
}
