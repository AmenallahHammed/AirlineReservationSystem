package Gui_Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import passenger_connection.book_ticket;

public class Gui_Book_Reservation {
    public Gui_Book_Reservation() {
        JFrame frame = new JFrame("Book a Reservation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        frame.add(panel);

        JLabel customerIdLabel = new JLabel("Customer ID:");
        JTextField customerIdField = new JTextField();
        JLabel flightIdLabel = new JLabel("Flight ID:");
        JTextField flightIdField = new JTextField();
        JLabel passengerNameLabel = new JLabel("Passenger Name:");
        JTextField passengerNameField = new JTextField();

        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(flightIdLabel);
        panel.add(flightIdField);
        panel.add(passengerNameLabel);
        panel.add(passengerNameField);

        JButton bookButton = new JButton("Book");
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerId = customerIdField.getText();
                String flightId = flightIdField.getText();
                String passengerName = passengerNameField.getText();

                if (customerId.isEmpty() || flightId.isEmpty() || passengerName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Call the Booking class method to book the flight
                book_ticket.bookFlight(customerId, flightId, passengerName);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close this window
                new Gui_Passenger_Menu(); // Go back to the main menu
            }
        });

        panel.add(bookButton);
        panel.add(backButton);

        frame.setVisible(true);
    }
}