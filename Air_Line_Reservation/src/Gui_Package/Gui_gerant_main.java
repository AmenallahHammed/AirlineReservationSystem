package Gui_Package;
import javax.swing.*;

import gerant_connection.delete_flight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_gerant_main {
    public Gui_gerant_main() {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Menu - Airline Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Taille de la fenêtre
        frame.setResizable(false); // Empêche le redimensionnement de la fenêtre

        // Panel principal pour contenir les boutons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Layout en grille avec 4 lignes et 1 colonne

        // Bouton pour ajouter un vol
        JButton addFlightButton = new JButton("Add a Flight");
        addFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_Add_Flight(); // Ouvrir l'interface pour ajouter un vol
            }
        });

        // Bouton pour supprimer un vol
        JButton deleteButton = new JButton("Delete a flight");
        deleteButton.setBounds(150, 100, 100, 30);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_Delete_Flight(); // Ouvrir l'interface pour ajouter un vol
            }
        });
        

        // Bouton pour modifier un vol
        JButton modifyFlightButton = new JButton("Modify a Flight");
        modifyFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_Modify_Flight();
            }
        });

        // Bouton pour quitter l'application
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fermer l'application
            }
        });

        // Ajouter les boutons au panel
        panel.add(addFlightButton);
        panel.add(deleteButton);
        panel.add(modifyFlightButton);
        panel.add(exitButton);

        // Ajouter le panel au frame
        frame.add(panel);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

   
}
