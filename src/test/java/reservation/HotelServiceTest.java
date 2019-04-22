package reservation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelServiceTest {

    @Test
    void getName() {
        HotelService testHotelService = new HotelService("test", 20.05, "test description");
        assertEquals(testHotelService.getName(), "test");
    }

    @Test
    void getPrice() {
        HotelService testHotelService = new HotelService("test", 20.05, "test description");
        assertEquals(java.util.Optional.ofNullable(testHotelService.getPrice()), 20.05);
    }

    @Test
    void getDescription() {
        HotelService testHotelService = new HotelService("test", 20.05, "test description");
        assertEquals(testHotelService.getDescription(), "test description");
    }
}