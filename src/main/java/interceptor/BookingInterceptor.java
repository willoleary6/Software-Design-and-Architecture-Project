package interceptor;

public interface BookingInterceptor {
    void flightBooked(FlightBookingContext context);
    void hotelBooked(HotelBookingContext context);
}
