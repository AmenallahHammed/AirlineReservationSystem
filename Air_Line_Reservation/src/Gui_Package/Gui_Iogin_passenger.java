package Gui_Package;

import passenger_connection.log_passenger;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui_Iogin_passenger {
    public Gui_Iogin_passenger() {
        // Création de la fenêtre
        JFrame frame = new JFrame("Passenger Login");
        frame.setLayout(null);

        // Label de titre
        JLabel titleLabel = new JLabel("Passenger Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setBounds(50, 10, 300, 30);
        frame.add(titleLabel);

        // Label et champ pour le nom
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 60, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 60, 150, 25);

        // Label et champ pour Passenger ID
        JLabel passengerIdLabel = new JLabel("Passenger ID:");
        passengerIdLabel.setBounds(50, 110, 100, 25);
        JTextField passengerIdField = new JTextField();
        passengerIdField.setBounds(150, 110, 150, 25);

        // Bouton Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 170, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String passengerId = passengerIdField.getText();

                if (name.isEmpty() || passengerId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    log_passenger logPassenger = new log_passenger();
                    boolean success = logPassenger.checkLogin(passengerId, name);

                    if (success) {
                    	 JOptionPane.showMessageDialog(frame, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                         frame.dispose(); // Close the login window
                         new Gui_Passenger_Menu(); // Open the Passenger Menu
                    } else {
                        JOptionPane.showMessageDialog(frame, "Passenger not found. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Bouton Search (Rech)
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(160, 170, 100, 30);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerId = passengerIdField.getText();

                if (passengerId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Passenger ID is required for search!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    log_passenger logPassenger = new log_passenger();
                    boolean found = logPassenger.searchPassenger(passengerId);

                    if (found) {
                        JOptionPane.showMessageDialog(frame, "Passenger exists in the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Passenger not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Bouton Exit
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(270, 170, 100, 30);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Ajouter les composants à la fenêtre
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passengerIdLabel);
        frame.add(passengerIdField);
        frame.add(loginButton);
        frame.add(searchButton);
        frame.add(exitButton);

        // Paramètres de la fenêtre
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
}
