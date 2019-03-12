package ui.view;

import javax.swing.*;

public class HotelSearchFrame extends JFrame {
    private JPanel panel;
    private JTable hotelTable;
    private JButton cancelButton;
    private JButton bookHotelButton;

    public HotelSearchFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setContentPane(panel);
        setLocationRelativeTo(null);
    }

    public JTable getHotelTable() {
        return hotelTable;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public JButton getBookHotelButton() {
        return bookHotelButton;
    }
}
