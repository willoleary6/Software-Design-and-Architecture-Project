package ui.model;

import reservation.Hotel;
import routeCalculation.Route;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class HotelSearchTableModel extends AbstractTableModel {
    private String[] columnNames = { "Hotel Name",  "Price" };
    List<Hotel> hotels;

    public HotelSearchTableModel(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public int getRowCount() {
        return hotels.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Hotel hotel = hotels.get(rowIndex);
        switch (columnIndex) {
            case -1: return hotel;
            case 0: return hotel.getHotelName();
            case 1: return hotel.getPrice();
            default: return null;
        }
    }
}
