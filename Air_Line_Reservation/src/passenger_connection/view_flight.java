package passenger_connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class view_flight {

    // Méthode pour récupérer tous les vols disponibles
    public static List<String[]> getAllFlights() {
        List<String[]> flights = new ArrayList<>();

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Airline?useSSL=false&serverTimezone=UTC",
                    "root",
                    "0000"
            );

            // Préparer la requête SQL
            String sql = "SELECT flightNumber, origin, destination, availableSeats, airplaneId FROM Flight";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Récupérer les résultats
            while (resultSet.next()) {
                String[] flightData = {
                    resultSet.getString("flightNumber"),
                    resultSet.getString("origin"),
                    resultSet.getString("destination"),
                    String.valueOf(resultSet.getInt("availableSeats")),
                    String.valueOf(resultSet.getInt("airplaneId"))
                };
                flights.add(flightData);
            }

            // Fermer la connexion
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erreur de base de données: " + ex.getMessage());
        }

        return flights;
    }
}