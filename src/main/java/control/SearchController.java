package control;

import Utilities.JsonObjectConverter;
import backgroundServices.API_Handlers.getRequestHandler;
import org.json.JSONObject;
import routeCalculation.*;

import java.util.ArrayList;
import java.util.Date;

//import routeCalculation.CostGrapher;

public class SearchController {
    private getRequestHandler dbHandler;
    private JsonObjectConverter jsonObjectConverter;
    private ArrayList<Airport> airports = new ArrayList<Airport>();

    public SearchController(){
        dbHandler = new getRequestHandler();
        jsonObjectConverter = new JsonObjectConverter();
        retrieveAirports();
    }

    public ArrayList<Route> searchForFlight(Airport departure, Airport destination, Date departureDate, boolean costBased) {
        int searchType = costBased ? 0 : 1;
        Grapher g = new Grapher(searchType);
        g.startCalculation(departure, airports, departureDate);
        ArrayList<Route> routeToDestination =  g.calculateTraceBack(destination);
        return routeToDestination;
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public void retrieveAirports(){
        dbHandler.getAllAirports();
        JSONObject[] response = dbHandler.getApiResponseResults();
        airports.clear();
        for(int i = 0; i < response.length;i++) {
            airports.add(jsonObjectConverter.jsonObjectToAirport(response[i]));
            airports.get(i).setFlightsDeparting(retrieveFlightsFromServerByAirport(airports.get(i).getAutoKey()));
        }

    }

    private ArrayList<FlightDiscountDecorator> retrieveFlightsFromServerByAirport(int departureAirportID){
        dbHandler.getFlightsByDepartureAirport(departureAirportID);
        ArrayList<FlightDiscountDecorator> flights = new ArrayList<FlightDiscountDecorator>();
        JSONObject[] response = dbHandler.getApiResponseResults();
        for(int i = 0; i < response.length;i++) {
            flights.add(jsonObjectConverter.jsonObjectToFlightDecorator(response[i]));
        }
        return flights;
    }

    /**
     *  method to retrieve all flights as opposed to flight decorator
     * @return all flights
     */
    public ArrayList<Flight> retrieveAllFlightsFromServer(){
        dbHandler.getAllFlights();
        ArrayList<Flight> flights = new ArrayList<Flight>();
        JSONObject[] response = dbHandler.getApiResponseResults();
        for(JSONObject i : response)
            flights.add(jsonObjectConverter.jsonObjectToFlight(i));
        return flights;
    }


}