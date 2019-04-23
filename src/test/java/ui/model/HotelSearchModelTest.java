package ui.model;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import reservation.Hotel;
import routeCalculation.Airport;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HotelSearchModelTest {

    @Test
    void getTableModel() {
        HotelSearchModel testModel = new HotelSearchModel(new Airport(1, "test"));
        List<Hotel> hotelList = Arrays.asList(new Hotel[]{new Hotel("Shannon Hotel", 1,70, 1, new JSONObject("{}"))});
        assertEquals(hotelList.get(0).getHotelName(), testModel.getTableModel().hotels.get(0).getHotelName());
    }
}