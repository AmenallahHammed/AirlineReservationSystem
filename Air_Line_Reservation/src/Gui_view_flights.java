import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Gui_view_flights {

    public Gui_view_flights() {
        // Create a frame for the Available Flights window
        JFrame frame = new JFrame("Available Flights");

        // Set the layout manager (null for absolute positioning)
        frame.setLayout(null);

        // Column names for the table
        String[] columnNames = {"Flight Number", "Departure", "Destination", "Available Seats", "Plane ID"};

        // Sample data for the table (replace with actual data from the database)
        Object[][] data = {
            {"123", "New York", "Los Angeles", 50, "A1"},
            {"456", "Paris", "London", 30, "B2"},
            {"789", "Tokyo", "Seoul", 20, "C3"}
        };

        // Create a table with the data and column names
        JTable flightTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(50, 50, 1000, 100); // Position and size of the table

        // Set column widths
        setColumnWidths(flightTable);

        // Create the "Back" button
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 270, 100, 30); // Position of the button at the bottom center
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new main1(); // Retour à l'interface principale
            }
        });

        // Add components to the frame
        frame.add(scrollPane); // Add the table
        frame.add(backButton); // Add the Back button

        // Set frame size, close operation, and make it visible
        frame.setSize(1100, 350); // Adjusted size for the table and button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method to set column widths
    private void setColumnWidths(JTable table) {
        // Set widths for each column
        TableColumn column;

        // Set width for Flight Number column
        column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(150); // Flight Number

        // Set width for Departure column
        column = table.getColumnModel().getColumn(1);
        column.setPreferredWidth(150); // Departure

        // Set width for Destination column
        column = table.getColumnModel().getColumn(2);
        column.setPreferredWidth(150); // Destination

        // Set width for Available Seats column
        column = table.getColumnModel().getColumn(3);
        column.setPreferredWidth(150); // Available Seats

        // Set width for Plane ID column
        column = table.getColumnModel().getColumn(4);
        column.setPreferredWidth(150); // Plane ID
    }

    
}
