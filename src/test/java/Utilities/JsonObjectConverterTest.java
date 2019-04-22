package Utilities;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import routeCalculation.Airport;
import routeCalculation.Flight;
import routeCalculation.FlightDiscountDecorator;

import static org.junit.jupiter.api.Assertions.*;

class JsonObjectConverterTest {

    @Test
    void jsonObjectToFlightDecorator() {
        JSONObject testObject = new JSONObject(
                "{" +
                        "\"departureTime\":\"" +
                        "{" +
                        "\\\"day\\\":\\\"Tuesday\\\"," +
                        "\\\"time\\\":\\\"14:00\\\"" +
                        "}\"," +
                        "\"departureAirport\":1," +
                        "\"arrivalTime\":" +
                        "\"{\\\"day\\\":\\\"Tuesday\\\",\\\"time\\\":\\\"15:00\\\"}\"," +
                        "\"price\":40,\"extendedDataInJSON\":null," +
                        "\"autoID\":0," +
                        "\"isActive\":1," +
                        "\"flightNumber\":\"K4535\"," +
                        "\"destinationAirport\":2," +
                        "\"airlineID\":1" +
                        "}"
        );
        Flight testFlight = new Flight(
                0,
                1,
                2,
                1,
                "K4535",
                "14:00",
                "15:00",
                "Tuesday",
                "Tuesday",
                40
        );
        FlightDiscountDecorator testFlightDecorator = new FlightDiscountDecorator(testFlight, 0.0);
        JsonObjectConverter testConverter = new JsonObjectConverter();
        assertEquals(testConverter.jsonObjectToFlightDecorator(testObject).getWeight(), testFlightDecorator.getWeight());
    }

    @Test
    void jsonObjectToFlight() {
        JSONObject testFlightObject = new JSONObject("{" +
                "\"departureTime\":\"" +
                "{" +
                "\\\"day\\\":\\\"Tuesday\\\"," +
                "\\\"time\\\":\\\"14:00\\\"" +
                "}\"," +
                "\"departureAirport\":1," +
                "\"arrivalTime\":" +
                "\"{\\\"day\\\":\\\"Tuesday\\\",\\\"time\\\":\\\"15:00\\\"}\"," +
                "\"price\":40,\"extendedDataInJSON\":null," +
                "\"autoID\":0," +
                "\"isActive\":1," +
                "\"flightNumber\":\"K4535\"," +
                "\"destinationAirport\":2," +
                "\"airlineID\":1" +
                "}");
        Flight testFlight = new Flight(
                0,
                1,
                2,
                1,
                "K4535",
                "14:00",
                "15:00",
                "Tuesday",
                "Tuesday",
                40
        );
        JsonObjectConverter testConverter = new JsonObjectConverter();
        assertEquals(testConverter.jsonObjectToFlight(testFlightObject).getWeight(), testFlight.getWeight());
    }

    @Test
    void jsonObjectToAirport() {
        JSONObject testAirportObject = new JSONObject("{\"autoID\":1,\"name\":\"Shannon\"}");
        JsonObjectConverter testConverter = new JsonObjectConverter();
        Airport testAirport = new Airport(1, "Shannon");
        assertEquals(testConverter.jsonObjectToAirport(testAirportObject).getAutoKey(), testAirport.getAutoKey());
    }
}