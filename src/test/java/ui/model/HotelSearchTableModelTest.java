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
        assertEquals(testSearchTableModel.getColumnCount(), 4);
    }

    @Test
    void getColumnName() {
        assertEquals(testSearchTableModel.getColumnName(0), "Hotel Name");
        assertEquals(testSearchTableModel.getColumnName(1), "Airport");
        assertEquals(testSearchTableModel.getColumnName(2), "Liaison User ID");
        assertEquals(testSearchTableModel.getColumnName(3), "Additional Services");

    }

    @Test
    void getValueAt() {
        assertEquals(testSearchTableModel.getValueAt(0,0), "test");
        assertEquals(testSearchTableModel.getValueAt(0,1), 1);
        assertEquals(testSearchTableModel.getValueAt(0,2), 1);
        assertEquals(testSearchTableModel.getValueAt(0,3), null);
    }

}