package Gui_Package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gerant_connection.*;
public class Gui_Main {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Airline Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Taille de la fenêtre
        frame.setResizable(false); // Empêche le redimensionnement de la fenêtre 

        // Panel principal pour contenir les boutons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10)); // Layout en grille avec 5 lignes et 1 colonne

        // Titre
        JLabel titleLabel = new JLabel("Welcome to our agency", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Changer la police et la taille
        titleLabel.setForeground(Color.RED); // Changer la couleur du texte
        panel.add(titleLabel); // Ajouter le label au panel

        // Créer les boutons et ajouter des ActionListener pour chaque bouton 
        JButton boss = new JButton("Gérant");
        boss.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt for the password
                String password = JOptionPane.showInputDialog(frame, "Enter password:", "Authentication", JOptionPane.PLAIN_MESSAGE);

                // Verify the password
                if (password != null && Password_Verification.verify(password)) {
                    new Gui_gerant_main(); // Open the manager interface
                } else {
                    JOptionPane.showMessageDialog(frame, "Password incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //passenger button
        JButton passenger= new JButton("Passenger");
        passenger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_Inscrit_Passenger(); // Ouvrir l'interface pour afficher les vols
            }
        });

       
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fermer l'application
            }
        });

        // Ajouter les boutons au panel
        panel.add(boss);
        panel.add(passenger);
        panel.add(exitButton);

        // Ajouter le panel au frame
        frame.add(panel);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
