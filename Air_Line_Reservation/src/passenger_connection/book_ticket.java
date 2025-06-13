package passenger_connection;
import javax.swing.*;
import java.sql.*;

public class book_ticket {
    public static void bookFlight(String customerId, String flightId, String passengerName) {
        // Connect to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Airline", "root", "0000")) {

            // Check if the flight exists and has available seats
            String checkFlightQuery = "SELECT availableSeats FROM Flight WHERE flightNumber = ?";
            PreparedStatement checkFlightStmt = connection.prepareStatement(checkFlightQuery);
            checkFlightStmt.setString(1, flightId);
            ResultSet rs = checkFlightStmt.executeQuery();

            if (rs.next()) {
                int availableSeats = rs.getInt("availableSeats");
                if (availableSeats <= 0) {
                    JOptionPane.showMessageDialog(null, "No seats available on this flight!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Generate a unique ticket ID
                String ticketId = "T" + System.currentTimeMillis();

                // Book the ticket
                String bookQuery = "INSERT INTO Ticket (ticketId, passengerId, flightNumber, price, status) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement bookStmt = connection.prepareStatement(bookQuery);
                bookStmt.setString(1, ticketId);
                bookStmt.setString(2, customerId);
                bookStmt.setString(3, flightId);
                bookStmt.setDouble(4, 100.00);  // Assume a fixed price
                bookStmt.setString(5, "booked");
                bookStmt.executeUpdate();

                // Update available seats in the Flight table
                String updateSeatsQuery = "UPDATE Flight SET availableSeats = availableSeats - 1 WHERE flightNumber = ?";
                PreparedStatement updateSeatsStmt = connection.prepareStatement(updateSeatsQuery);
                updateSeatsStmt.setString(1, flightId);
                updateSeatsStmt.executeUpdate();

                // Fetch the ticket details for display
                String ticketDetailsQuery = "SELECT * FROM Ticket WHERE ticketId = ?";
                PreparedStatement ticketStmt = connection.prepareStatement(ticketDetailsQuery);
                ticketStmt.setString(1, ticketId);
                ResultSet ticketRs = ticketStmt.executeQuery();

                if (ticketRs.next()) {
                    String ticketInfo = "Ticket ID: " + ticketRs.getString("ticketId") + "\n"
                            + "Passenger Name: " + passengerName + "\n"
                            + "Flight Number: " + ticketRs.getString("flightNumber") + "\n"
                            + "Price: $" + ticketRs.getDouble("price") + "\n"
                            + "Status: " + ticketRs.getString("status");
                    JOptionPane.showMessageDialog(null, ticketInfo, "Ticket Details", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Flight not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}