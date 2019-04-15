package booking;

public class FlightBooking implements Booking {

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public void addChildBooking() {

    }

    @Override
    public void removeChildBooking() {

    }
}

/*
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

 */