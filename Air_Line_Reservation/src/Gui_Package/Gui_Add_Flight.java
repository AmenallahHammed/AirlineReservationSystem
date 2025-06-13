package Gui_Package;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import gerant_connection.*;

public class Gui_Add_Flight {
    public Gui_Add_Flight() {
        JFrame frame = new JFrame("Add Flight");
        frame.setLayout(null);

        JLabel label1 = new JLabel("Flight ID:");
        label1.setBounds(50, 50, 100, 25);
        JTextField flightIdField = new JTextField();
        flightIdField.setBounds(150, 50, 150, 25);

        JLabel label2 = new JLabel("Destination:");
        label2.setBounds(50, 100, 100, 25);
        JTextField destinationField = new JTextField();
        destinationField.setBounds(150, 100, 150, 25);

        JLabel label3 = new JLabel("Departure:");
        label3.setBounds(50, 150, 100, 25);
        JTextField departureField = new JTextField();
        departureField.setBounds(150, 150, 150, 25);

        JLabel label4 = new JLabel("Date:");
        label4.setBounds(50, 200, 100, 25);
        JTextField dateField = new JTextField();
        dateField.setBounds(150, 200, 150, 25);

        JLabel label5 = new JLabel("Time:");
        label5.setBounds(50, 250, 100, 25);
        JTextField timeField = new JTextField();
        timeField.setBounds(150, 250, 150, 25);

        JLabel label6 = new JLabel("Capacity:");
        label6.setBounds(50, 300, 100, 25);
        JTextField capacityField = new JTextField();
        capacityField.setBounds(150, 300, 150, 25);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(80, 350, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String flightNumber = flightIdField.getText();
                    String origin = departureField.getText();
                    String destination = destinationField.getText();
                    String date = dateField.getText();
                    String time = timeField.getText();
                    int availableSeats = Integer.parseInt(capacityField.getText());

                    if (flightNumber.isEmpty() || origin.isEmpty() || destination.isEmpty() || date.isEmpty() || time.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    add_flight addFlight = new add_flight();
                    boolean success = addFlight.addFlight(flightNumber, origin, destination, date + " " + time, availableSeats);

                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Flight added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to add flight. Verify the input data.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Capacity must be a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 350, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Gui_Main();
            }
        });

        frame.add(label1);
        frame.add(flightIdField);
        frame.add(label2);
        frame.add(destinationField);
        frame.add(label3);
        frame.add(departureField);
        frame.add(label4);
        frame.add(dateField);
        frame.add(label5);
        frame.add(timeField);
        frame.add(label6);
        frame.add(capacityField);
        frame.add(submitButton);
        frame.add(backButton);

        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
    }
}
