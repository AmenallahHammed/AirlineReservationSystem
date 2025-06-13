package passenger_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class sign_passenger {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Airline"; // Replace with your DB URL
    private static final String DB_USER = "root"; // Replace with your DB username
    private static final String DB_PASSWORD = "0000"; // Replace with your DB password

    public boolean signPassenger(String passengerId, String name, String contactInfo) {
        String insertQuery = "INSERT INTO Passenger (id, name, contactInfo) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, passengerId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, contactInfo);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Return true if insert was successful
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
