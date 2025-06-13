package passenger_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class log_passenger {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Airline"; // Replace with your DB URL
    private static final String DB_USER = "root"; // Replace with your DB username
    private static final String DB_PASSWORD = "0000"; // Replace with your DB password

    public boolean checkLogin(String passengerId, String name) {
        String query = "SELECT * FROM Passenger WHERE id = ? AND name = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, passengerId);
            preparedStatement.setString(2, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if a matching record is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean searchPassenger(String passengerId) {
        String query = "SELECT * FROM Passenger WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, passengerId);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if a matching record is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
