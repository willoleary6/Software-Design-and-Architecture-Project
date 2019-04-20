package booking;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reservation.Hotel;
import routeCalculation.Airport;
import routeCalculation.Flight;
import routeCalculation.FlightDiscountDecorator;
import routeCalculation.Route;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FlightBookingTest {
    FlightBooking testBooking;
    @BeforeEach
    void setUp() {
        testBooking = new FlightBooking(
                        new Route(
                                new Airport(0, "test"),
                                new Airport(1, "test"),
                                new FlightDiscountDecorator(
                                        new Flight(
                                                0,
                                                0,
                                                1,
                                                0,
                                                "",
                                                "",
                                                "",
                                                "",
                                                "",
                                                70),
                                        20
                                ),
                                70
                        )
                );
        HotelBooking testHotelBooking = new HotelBooking(
                new Hotel(
                        "",
                        0,
                        0.0,
                        1,
                        new JSONObject("{}")
                )
        );
        testBooking.addChildBooking(testHotelBooking);
    }

    @Test
    void getNumberOfChildBookings() {
        int results = testBooking.getNumberOfChildBookings();
        int answer = 1;

        assertEquals(answer ,results);
    }
    @Test
    void getTotalCost() {
        int answer = 70;
        assertEquals(answer ,testBooking.getTotalCost());
    }

    @Test
    void getListOfCosts() {
        ArrayList<Double> results = testBooking.getListOfCosts();
        ArrayList<Double> answer = new ArrayList<>();
        answer.add(70.00);
        answer.add(0.00);

        assertEquals(answer ,results);
    }

    @Test
    void addChildBooking() {
        HotelBooking testHotelBooking = new HotelBooking(
                new Hotel("", 0,  0.0, 1, new JSONObject("{}"))
        );
        int answer = testBooking.getNumberOfChildBookings()+1;
        testBooking.addChildBooking(testHotelBooking);
        int results = testBooking.getNumberOfChildBookings();

        assertEquals(answer ,results);
    }

    @Test
    void removeChildBooking() {
        HotelBooking testHotelBooking = new HotelBooking(
                new Hotel("", 0,  0.0, 1, new JSONObject("{}"))
        );
        testBooking.addChildBooking(testHotelBooking);
        int answer = testBooking.getNumberOfChildBookings()-1;

        testBooking.removeChildBooking(testHotelBooking);
        int results = testBooking.getNumberOfChildBookings();
        assertEquals(answer ,results);
    }

    @Test
    void getListOfNames() {
        ArrayList<String> answer = new ArrayList<>();
        answer.add(": test - test");
        answer.add("");

        ArrayList<String>  results = testBooking.getListOfNames();
        assertEquals(answer ,results);
    }

    @Test
    void getListOfTypeOfComposites() {
        ArrayList<String> answer = new ArrayList<>();
        answer.add("Flight");
        answer.add("Hotel");

        ArrayList<String>  results = testBooking.getListOfTypeOfComposites();
        assertEquals(answer ,results);
    }
}