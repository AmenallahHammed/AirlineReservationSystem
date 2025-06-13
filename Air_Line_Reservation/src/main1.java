import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main1 {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Airline Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Taille de la fenêtre
        frame.setResizable(false); // Empêche le redimensionnement de la fenêtre

        // Panel principal pour contenir les boutons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // Layout en grille avec 5 lignes et 1 colonne

        // Titre
        JLabel titleLabel = new JLabel("Welcome to Airline Reservation System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Changer la police et la taille
        titleLabel.setForeground(Color.BLUE); // Changer la couleur du texte
        panel.add(titleLabel); // Ajouter le label au panel

        // Créer les boutons et ajouter des ActionListener pour chaque bouton
        JButton addFlightButton = new JButton("Add Flight");
        addFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_Add_Flight(); // Ouvrir l'interface pour ajouter un vol
            }
        });

        JButton viewFlightsButton = new JButton("View Flights");
        viewFlightsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_view_flights(); // Ouvrir l'interface pour afficher les vols
            }
        });

        JButton bookReservationButton = new JButton("Book Reservation");
        bookReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Gui_Book_Reservation(); // Ouvrir l'interface pour réserver un vol
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fermer l'application
            }
        });

        // Ajouter les boutons au panel
        panel.add(addFlightButton);
        panel.add(viewFlightsButton);
        panel.add(bookReservationButton);
        panel.add(exitButton);

        // Ajouter le panel au frame
        frame.add(panel);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
