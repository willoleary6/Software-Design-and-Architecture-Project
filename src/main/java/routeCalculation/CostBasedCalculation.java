package routeCalculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.PriorityQueue;

public class CostBasedCalculation implements RouteCalculationStrategy {
    private RouteCalculationLambdaFunctions routeCalculationsLambdaFunctions;

    public CostBasedCalculation(){
        routeCalculationsLambdaFunctions = () -> 0;
        routeCalculationsLambdaFunctions.initialise();
    }
    @Override
    public ArrayList<Route> calculateBestRouteToDestination(Airport origin, Airport destination, Date departureDate, ArrayList<Airport> allAirports) {
        ArrayList<Route> chain_of_routes_to_every_destination = new ArrayList<>();
        origin.setMinimumDistance(0.);
        PriorityQueue<Airport> airportQueue = new PriorityQueue<Airport>();
        // start with our departure airport
        RouteCalculationLambdaFunctions grapherLambdaFunctions = () -> 0;
        grapherLambdaFunctions.initialise();
        airportQueue.add(origin);
        while (!airportQueue.isEmpty()) {
            Airport currentAirport = airportQueue.poll();
            // run through each of the flights leaving this airport.
            for (Edge currentFlight :  currentAirport.getEdges()) {
                double costOfCurrentFlight, costThroughCurrentAirport;
                // find target airport through the flight destination
                Airport targetAirport = grapherLambdaFunctions.getAirportByID(currentFlight.getTarget(), allAirports);

                costOfCurrentFlight = currentFlight.getWeight();
                // calculate the cost of getting to this next node
                costThroughCurrentAirport = currentAirport.getMinimumDistance() + costOfCurrentFlight;
                if (costThroughCurrentAirport < targetAirport.getMinimumDistance()) {
                    // seems like a valid route, lets add it to our list
                    chain_of_routes_to_every_destination.add(new Route(currentAirport, targetAirport, currentFlight, costOfCurrentFlight));
                    targetAirport.setMinimumDistance(costThroughCurrentAirport);
                    airportQueue.add(targetAirport);
                    chain_of_routes_to_every_destination = grapherLambdaFunctions.eliminateDuplicateTargets(chain_of_routes_to_every_destination);
                }
            }
        }

        Route traceBack;
        ArrayList<Route> routeToDestination = new ArrayList<Route>();
        do{
            traceBack = routeCalculationsLambdaFunctions.getRouteWithSpecifiedDestination(destination, chain_of_routes_to_every_destination);
            destination = traceBack.getOrigin();
            routeToDestination.add(traceBack);
        }while(traceBack.getOrigin() != origin);
        Collections.reverse(routeToDestination);
        return routeToDestination;
    }
}
