package ui.view;

import javax.swing.*;

public class BookingCheckoutFrame extends JFrame {
    private JPanel panel1;
    private JButton mainMenuButton;
    private JButton confirmButton;
    private JTable table1;

    public BookingCheckoutFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JTable getBookingCheckoutTable() {
        return table1;
    }

    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    public JButton getConfirmBookingButton() {
        return confirmButton;
    }
}
