package gerant_connection;

import javax.swing.*;
import java.sql.*;

public class gerant_modifier {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Airline";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "0000";

    // Fonction pour récupérer les détails du vol à partir de la base de données
    public static void loadFlightDetails(String flightNumber) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Établir la connexion à la base de données
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Requête pour récupérer les détails du vol
            String query = "SELECT * FROM Flight WHERE flightNumber = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, flightNumber);
            rs = stmt.executeQuery();

            // Si le vol existe, afficher ses informations
            if (rs.next()) {
                String origin = rs.getString("origin");
                String destination = rs.getString("destination");
                String departureTime = rs.getString("departureTime");
                int availableSeats = rs.getInt("availableSeats");

                // Remplir les champs avec les détails récupérés
                JOptionPane.showMessageDialog(null, "Flight Details Loaded:\n"
                        + "Origin: " + origin + "\n"
                        + "Destination: " + destination + "\n"
                        + "Departure Time: " + departureTime + "\n"
                        + "Available Seats: " + availableSeats, "Flight Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Flight not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fermeture des ressources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Fonction pour enregistrer les modifications du vol dans la base de données
    public static void saveFlightDetails(String flightNumber, String origin, String destination, 
                                         String departureTime, int availableSeats) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Établir la connexion à la base de données
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Requête pour mettre à jour les détails du vol
            String query = "UPDATE Flight SET origin = ?, destination = ?, departureTime = ?, "
                           + "availableSeats = ? WHERE flightNumber = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, origin);
            stmt.setString(2, destination);
            stmt.setString(3, departureTime);
            stmt.setInt(4, availableSeats);
            stmt.setString(5, flightNumber);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Flight details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Flight not found for update.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Fermeture des ressources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
