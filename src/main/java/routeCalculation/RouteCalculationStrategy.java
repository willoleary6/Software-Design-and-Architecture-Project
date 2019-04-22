package routeCalculation;

import routeCalculation.Airport;
import routeCalculation.Route;

import java.util.ArrayList;
import java.util.Date;

public interface RouteCalculationStrategy {
    ArrayList<Route> calculateBestRouteToDestination(
            Airport origin, Airport destination, Date departureDate,ArrayList<Airport> allAirports);
}
