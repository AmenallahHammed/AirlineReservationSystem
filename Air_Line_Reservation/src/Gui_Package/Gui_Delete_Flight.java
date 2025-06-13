package Gui_Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import gerant_connection.delete_flight;
public class Gui_Delete_Flight {
    public Gui_Delete_Flight() {
        // Fenêtre principale
        JFrame frame = new JFrame("Delete Flight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Label et champ pour l'ID du vol
        JLabel label = new JLabel("Flight ID:");
        label.setBounds(50, 50, 100, 25);
        JTextField flightIdField = new JTextField();
        flightIdField.setBounds(150, 50, 150, 25);

        // Bouton Delete
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 150, 100, 30);
        

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightNumber = flightIdField.getText();

                if (flightNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Flight ID cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                delete_flight deleteFlight = new delete_flight();
                if (deleteFlight.doesFlightExist(flightNumber)) {
                    boolean success = deleteFlight.deleteFlight(flightNumber);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, "Flight deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Failed to delete flight.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Flight ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        // Bouton Back
        JButton backButton = new JButton("Back");
        backButton.setBounds(200, 150, 100, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme la fenêtre actuelle
                new Menu(); // Retour à l'interface principale
            }
        });

        // Ajouter les composants au panel
        panel.add(label);
        panel.add(flightIdField);
        panel.add(deleteButton);
        panel.add(backButton);

        // Ajouter le panel à la fenêtre
        frame.add(panel);
        frame.setVisible(true);
    }

    
}
