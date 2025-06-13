package gerant_connection;

import java.sql.*;

public class delete_flight {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Airline";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0000";

    // Check if a flight exists in the database
    public boolean doesFlightExist(String flightNumber) {
        String query = "SELECT COUNT(*) FROM Flight WHERE flightNumber = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, flightNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Return true if the count is greater than 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Flight does not exist
    }

    // Delete a flight from the database
    public boolean deleteFlight(String flightNumber) {
        String query = "DELETE FROM Flight WHERE flightNumber = ?";

        if (!doesFlightExist(flightNumber)) {
            System.out.println("Flight with ID " + flightNumber + " does not exist.");
            return false; // Return false if the flight does not exist
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, flightNumber);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0; // Return true if a row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
