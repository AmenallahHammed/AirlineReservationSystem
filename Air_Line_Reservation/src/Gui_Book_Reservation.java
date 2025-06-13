import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Gui_Book_Reservation {
    // Constructeur
    public Gui_Book_Reservation() {
        // Création de la fenêtre
        JFrame frame = new JFrame("Book a Reservation");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setResizable(false);

        // Création du panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        frame.add(panel);

        // Champs de saisie
        JLabel customerIdLabel = new JLabel("Customer ID:");
        JTextField customerIdField = new JTextField();
        JLabel flightIdLabel = new JLabel("Flight ID:");
        JTextField flightIdField = new JTextField();
        JLabel passengerNameLabel = new JLabel("Passenger Name:");
        JTextField passengerNameField = new JTextField();

        // Ajouter les composants au panel
        panel.add(customerIdLabel);
        panel.add(customerIdField);
        panel.add(flightIdLabel);
        panel.add(flightIdField);
        panel.add(passengerNameLabel);
        panel.add(passengerNameField);

        // Bouton "Book"
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

                try (Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Airline", "root", "faresdhib2005")) { // Connexion mise à jour

                    // Vérifier si le vol existe et a des places disponibles
                    String checkFlightQuery = "SELECT availableSeats FROM Flight WHERE flightNumber = ?";
                    PreparedStatement checkFlightStmt = connection.prepareStatement(checkFlightQuery);
                    checkFlightStmt.setString(1, flightId);
                    ResultSet rs = checkFlightStmt.executeQuery();

                    if (rs.next()) {
                        int availableSeats = rs.getInt("availableSeats");
                        if (availableSeats <= 0) {
                            JOptionPane.showMessageDialog(frame, "No seats available on this flight!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Réserver le vol
                        String bookQuery = "INSERT INTO Ticket (ticketId, passengerId, flightNumber, price, status) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement bookStmt = connection.prepareStatement(bookQuery);
                        String ticketId = "T" + System.currentTimeMillis(); // ID unique basé sur le temps
                        bookStmt.setString(1, ticketId);
                        bookStmt.setString(2, customerId);
                        bookStmt.setString(3, flightId);
                        bookStmt.setDouble(4, 100.00); // Exemple de prix
                        bookStmt.setString(5, "booked");

                        bookStmt.executeUpdate();

                        // Réduire le nombre de places disponibles
                        String updateSeatsQuery = "UPDATE Flight SET availableSeats = availableSeats - 1 WHERE flightNumber = ?";
                        PreparedStatement updateSeatsStmt = connection.prepareStatement(updateSeatsQuery);
                        updateSeatsStmt.setString(1, flightId);
                        updateSeatsStmt.executeUpdate();

                        JOptionPane.showMessageDialog(frame, "Reservation successful! Ticket ID: " + ticketId, "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Flight not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Bouton "Back"
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new main1(); // Retour à l'interface principale
            }
        });

        // Ajouter les boutons au panel
        panel.add(bookButton);
        panel.add(backButton);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
