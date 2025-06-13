package Gui_Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class Gui_Passenger {
    public Gui_Passenger() {
        // Création de la fenêtre
        JFrame frame = new JFrame("Add Passenger");
        frame.setLayout(null);

        // Label de titre
        JLabel titleLabel = new JLabel("Please submit to benefit from our services", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Police et taille
        titleLabel.setForeground(Color.BLUE); // Couleur
        titleLabel.setBounds(50, 10, 300, 30);
        frame.add(titleLabel);

        // Label et champ pour Passenger ID
        JLabel label1 = new JLabel("Passenger ID:");
        label1.setBounds(50, 50, 100, 25);
        JTextField passengerIdField = new JTextField();
        passengerIdField.setBounds(150, 50, 150, 25);

        // Label et champ pour le nom
        JLabel label2 = new JLabel("Name:");
        label2.setBounds(50, 100, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 150, 25);

        // Label et champ pour les informations de contact
        JLabel label3 = new JLabel("Contact Info:");
        label3.setBounds(50, 150, 100, 25);
        JTextField contactInfoField = new JTextField();
        contactInfoField.setBounds(150, 150, 150, 25);

        // Bouton Submit
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(70, 200, 100, 30); // Corrected position
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_Passenger_Menu(); // Ouvre l'interface Menu
            }
        });

      
        // Bouton Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(210, 200, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
               new Gui_Main();
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
        frame.add(backButton);

        // Paramètres de la fenêtre
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

   
}

// Nouvelle classe pour l'interface Service
