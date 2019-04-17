package ui.model;

import booking.Booking;
import booking.BookingComposite;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookingCheckoutTableModel extends AbstractTableModel {
    private Booking bookings;
    private String[] columnNames = { "Name", "Type", "Cost"};

    public BookingCheckoutTableModel(Booking bookings) {
        this.bookings = bookings;
    }

    @Override
    public int getRowCount() {
        return ((bookings.getListOfNames()).size())+1; //accounting for total
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return getListOfNamesAndTotal(rowIndex);
            case 1:
                return getListOfTypesAndTotal(rowIndex);
            case 2:
                return getListOfCostsAndTotal(rowIndex);
            default:
                return "";
        }
    }
    private String getListOfNamesAndTotal(int rowIndex){
        ArrayList<String> listOfNames = (this.bookings.getListOfNames());
        listOfNames.add("Total");
        return listOfNames.get(rowIndex);
    }

    private double getListOfCostsAndTotal(int rowIndex){
        ArrayList<Double> listOfCosts = (this.bookings.getListOfCosts());
        listOfCosts.add(this.bookings.getTotalCost());
        return listOfCosts.get(rowIndex);
    }
    private String getListOfTypesAndTotal(int rowIndex){
        ArrayList<String> listOfTypes = (this.bookings.getListOfTypeOfComposites());
        listOfTypes.add("");
        return listOfTypes.get(rowIndex);
    }
}
