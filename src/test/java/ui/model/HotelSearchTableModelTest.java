package ui.model;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import reservation.Hotel;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelSearchTableModelTest {
    private List<Hotel> hotelList = Arrays.asList(new Hotel[]{new Hotel("test", 1,
            1,1, new JSONObject("{}"))});
    private HotelSearchTableModel testSearchTableModel = new HotelSearchTableModel(hotelList);

    @Test
    void getRowCount() {
        assertEquals(testSearchTableModel.getRowCount(), 1);
    }

    @Test
    void getColumnCount() {
        assertEquals(testSearchTableModel.getColumnCount(), 2);
    }

    @Test
    void getColumnName() {
        assertEquals(testSearchTableModel.getColumnName(0), "Hotel Name");
        assertEquals(testSearchTableModel.getColumnName(1), "Price");
    }

    @Test
    void getValueAt() {
        assertEquals(testSearchTableModel.getValueAt(0,0), "test");
        assertEquals(testSearchTableModel.getValueAt(0,1), 1.0);
        assertEquals(testSearchTableModel.getValueAt(0,2), null);
        assertEquals(testSearchTableModel.getValueAt(0,3), null);
    }

}