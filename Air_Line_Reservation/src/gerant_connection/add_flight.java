package gerant_connection;

import java.sql.*;

public class add_flight {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Airline";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0000";

    public boolean addFlight(String flightNumber, String origin, String destination, 
                             String departuretime, int availableSeats) {
        String airplaneQuery = "SELECT id FROM Airplane WHERE capacity >= ? LIMIT 1";
        String flightInsertQuery = "INSERT INTO Flight (flightNumber, origin, destination, departureTime, availableSeats, airplaneId) " +
                                    "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Fetch an appropriate Airplane ID
            int airplaneId = -1;
            try (PreparedStatement airplaneStmt = connection.prepareStatement(airplaneQuery)) {
                airplaneStmt.setInt(1, availableSeats); // Match an airplane with enough capacity
                ResultSet rs = airplaneStmt.executeQuery();
                if (rs.next()) {
                    airplaneId = rs.getInt("id");
                } else {
                    System.out.println("No suitable airplane found.");
                    return false; // No airplane available
                }
            }

            // Insert the flight
            try (PreparedStatement flightStmt = connection.prepareStatement(flightInsertQuery)) {
                flightStmt.setString(1, flightNumber);
                flightStmt.setString(2, origin);
                flightStmt.setString(3, destination);
                flightStmt.setString(4, departuretime);
                flightStmt.setInt(5, availableSeats);
                flightStmt.setInt(6, airplaneId);

                int rowsAffected = flightStmt.executeUpdate();
                return rowsAffected > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
