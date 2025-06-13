package Gui_Package;

import passenger_connection.sign_passenger;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui_Inscrit_Passenger {
    public Gui_Inscrit_Passenger() {
        // Création de la fenêtre
        JFrame frame = new JFrame("Add Passenger");
        frame.setLayout(null);

        // Label de titre
        JLabel titleLabel = new JLabel("Please submit to benefit from our services", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Police et taille
        titleLabel.setForeground(Color.BLUE); // Couleur
        titleLabel.setBounds(50, 10, 350, 30);
        frame.add(titleLabel);

        // Label et champ pour Passenger ID
        JLabel label1 = new JLabel("Passenger ID:");
        label1.setBounds(50, 50, 100, 25);
        JTextField passengerIdField = new JTextField();
        passengerIdField.setBounds(150, 50, 200, 25);

        // Label et champ pour le nom
        JLabel label2 = new JLabel("Name:");
        label2.setBounds(50, 100, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 25);

        // Label et champ pour les informations de contact
        JLabel label3 = new JLabel("Contact Info:");
        label3.setBounds(50, 150, 100, 25);
        JTextField contactInfoField = new JTextField();
        contactInfoField.setBounds(150, 150, 200, 25);

        // Bouton Submit
        JButton submitButton = new JButton("Sign In");
        submitButton.setBounds(50, 200, 100, 30);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passengerId = passengerIdField.getText();
                String name = nameField.getText();
                String contactInfo = contactInfoField.getText();

                if (passengerId.isEmpty() || name.isEmpty() || contactInfo.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Call the Sign_Passenger class to insert passenger details
                    sign_passenger signPassenger = new sign_passenger();
                    boolean success = signPassenger.signPassenger(passengerId, name, contactInfo);

                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Passenger registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        passengerIdField.setText("");
                        nameField.setText("");
                        contactInfoField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error registering passenger. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Bouton Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(170, 200, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_Iogin_passenger(); // Ouvre l'interface de login
            }
        });

        // Bouton Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(290, 200, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_Main(); // Retourne à l'interface principale
            }
        });

        // Ajouter les composants à la fenêtre
        frame.add(label1);
        frame.add(passengerIdField);
        frame.add(label2);
        frame.add(nameField);
        frame.add(label3);
        frame.add(contactInfoField);
        frame.add(submitButton);
        frame.add(loginButton);
        frame.add(backButton);

        // Paramètres de la fenêtre
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
}
