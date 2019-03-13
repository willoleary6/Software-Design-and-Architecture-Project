package booking;

import reservation.Hotel;
import routeCalculation.Flight;

public class Booking {
    private Flight flight;
    private Hotel hotelReservation;
    
    public Booking(Flight flight, Hotel hotelReservation) {
        this.flight = flight;
        this.hotelReservation = hotelReservation;
    }

    public Booking(Flight flight) {
        this.flight = flight;
    }

    public Flight getBookingFlight() {
        return this.flight;
    }

    public Hotel getBookingHotelReservation() {
        return this.hotelReservation;
    }
}
