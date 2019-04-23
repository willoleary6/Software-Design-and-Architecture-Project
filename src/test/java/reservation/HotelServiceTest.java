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
        assertEquals(20.05, testHotelService.getPrice().doubleValue());
    }

    @Test
    void getDescription() {
        HotelService testHotelService = new HotelService("test", 20.05, "test description");
        assertEquals(testHotelService.getDescription(), "test description");
    }
}