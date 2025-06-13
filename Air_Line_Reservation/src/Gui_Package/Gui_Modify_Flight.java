package Gui_Package;
import gerant_connection.gerant_modifier;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Modify_Flight {
    private JTextField flightNumberField, originField, destinationField, departureTimeField, availableSeatsField;

    public Gui_Modify_Flight() {
        // Fenêtre principale
        JFrame frame = new JFrame("Modify Flight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Labels et champs pour les détails du vol
        JLabel labelFlightNumber = new JLabel("Flight Number:");
        labelFlightNumber.setBounds(50, 50, 150, 25);
        flightNumberField = new JTextField();
        flightNumberField.setBounds(200, 50, 200, 25);

        JLabel labelOrigin = new JLabel("Origin:");
        labelOrigin.setBounds(50, 100, 150, 25);
        originField = new JTextField();
        originField.setBounds(200, 100, 200, 25);

        JLabel labelDestination = new JLabel("Destination:");
        labelDestination.setBounds(50, 150, 150, 25);
        destinationField = new JTextField();
        destinationField.setBounds(200, 150, 200, 25);

        JLabel labelDepartureTime = new JLabel("Departure Time:");
        labelDepartureTime.setBounds(50, 200, 150, 25);
        departureTimeField = new JTextField();
        departureTimeField.setBounds(200, 200, 200, 25);

        JLabel labelAvailableSeats = new JLabel("Available Seats:");
        labelAvailableSeats.setBounds(50, 250, 150, 25);
        availableSeatsField = new JTextField();
        availableSeatsField.setBounds(200, 250, 200, 25);

        // Bouton pour charger les détails
        JButton loadButton = new JButton("Find");
        loadButton.setBounds(100, 400, 100, 30);
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNumber = flightNumberField.getText();
                if (flightNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a Flight Number!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Charger les détails du vol depuis la base de données
                gerant_modifier.loadFlightDetails(flightNumber);

                // Optionnel: Si les détails sont trouvés, on peut les remplir dans les champs
                // Exemple d'affichage simulé
                originField.setText("Sample Origin");
                destinationField.setText("Sample Destination");
                departureTimeField.setText("2024-12-25 10:00:00");
                availableSeatsField.setText("150");
            }
        });

        // Bouton pour enregistrer les modifications
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(220, 400, 100, 30);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNumber = flightNumberField.getText();
                String origin = originField.getText();
                String destination = destinationField.getText();
                String departureTime = departureTimeField.getText();
                String availableSeats = availableSeatsField.getText();

                // Vérifier si les champs sont remplis
                if (flightNumber.isEmpty() || origin.isEmpty() || destination.isEmpty() || 
                    departureTime.isEmpty() || availableSeats.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Enregistrer les modifications dans la base de données
                gerant_modifier.saveFlightDetails(flightNumber, origin, destination, departureTime, 
                        Integer.parseInt(availableSeats));
            }
        });

        // Bouton Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(340, 400, 100, 30); // Position ajustée pour le bouton Back
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_gerant_main(); // Retour à l'interface principale
            }
        });

        // Ajouter les composants au panel
        panel.add(labelFlightNumber);
        panel.add(flightNumberField);
        panel.add(labelOrigin);
        panel.add(originField);
        panel.add(labelDestination);
        panel.add(destinationField);
        panel.add(labelDepartureTime);
        panel.add(departureTimeField);
        panel.add(labelAvailableSeats);
        panel.add(availableSeatsField);
        panel.add(loadButton);
        panel.add(saveButton);
        panel.add(backButton);

        // Ajouter le panel à la fenêtre
        frame.add(panel);
        frame.setVisible(true);
    }
}
