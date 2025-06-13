package Gui_Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui_Passenger_Menu {
    public Gui_Passenger_Menu() {
        // Création de la fenêtre
        JFrame frame = new JFrame("Passenger Menu");
        frame.setLayout(null);

        // Panel principal pour contenir les boutons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // 4 lignes, 1 colonne, espacement vertical et horizontal
        panel.setBounds(50, 30, 300, 200); // Position et taille du panel

        // Label de titre
        JLabel titleLabel = new JLabel("The Service Provided", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Changer la police et la taille
        titleLabel.setForeground(Color.RED); // Changer la couleur du texte
        panel.add(titleLabel); // Ajouter le label au panel

        // Bouton view flight
        JButton viewButton = new JButton("View Flights");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_view_flights(); // Ouvre l'interface Menu
            }
        });

        // Bouton book reservation
        JButton bookButton = new JButton("Book Reservation");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_Book_Reservation(); // Ouvre l'interface Menu
            }
        });

        // Bouton Back
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new Gui_Main();
            }
        });

        // Ajouter les boutons au panel
        panel.add(viewButton);
        panel.add(bookButton);
        panel.add(backButton);

        // Ajouter le panel à la fenêtre
        frame.add(panel);

        // Paramètres de la fenêtre
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }
}
