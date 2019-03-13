package ui.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelSearchFrameTest {

    @Test
    void getHotelTable() {
        HotelSearchFrame testHotelSearchFrame = new HotelSearchFrame();
        boolean notNull = false;
        if(testHotelSearchFrame.getHotelTable() != null){
            notNull = true;
        }
        assertEquals(notNull, true);
    }

    @Test
    void getCancelButton() {
        HotelSearchFrame testHotelSearchFrame = new HotelSearchFrame();
        boolean notNull = false;
        if(testHotelSearchFrame.getCancelButton() != null){
            notNull = true;
        }
        assertEquals(notNull, true);
    }

    @Test
    void getBookHotelButton() {
        HotelSearchFrame testHotelSearchFrame = new HotelSearchFrame();
        boolean notNull = false;
        if(testHotelSearchFrame.getBookHotelButton() != null){
            notNull = true;
        }
        assertEquals(notNull, true);
    }
}