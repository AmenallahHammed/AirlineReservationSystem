package Gui_Package;
import passenger_connection.view_flight;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableColumn;
import java.util.List;

public class Gui_view_flights {

    public Gui_view_flights() {
        // Créer une fenêtre pour afficher les vols disponibles
        JFrame frame = new JFrame("Available Flights");

        // Définir le gestionnaire de mise en page (null pour positionnement absolu)
        frame.setLayout(null);

        // Colonnes pour le tableau
        String[] columnNames = {"Flight Number", "Departure", "Destination", "Available Seats", "Plane ID"};

        // Récupérer les données des vols depuis la base de données
        List<String[]> flights = view_flight.getAllFlights();

        // Convertir les données en tableau pour le JTable
        Object[][] data = new Object[flights.size()][5];
        for (int i = 0; i < flights.size(); i++) {
            data[i] = flights.get(i);
        }

        // Créer un tableau avec les données et les colonnes
        JTable flightTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(50, 50, 1000, 150); // Position et taille du tableau

        // Définir les largeurs des colonnes
        setColumnWidths(flightTable);

        // Créer le bouton "Back"
        JButton backButton = new JButton("Back");
        backButton.setBounds(150, 270, 100, 30); // Position du bouton
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fermer cette fenêtre
                new Gui_Passenger_Menu(); // Retourner à l'interface principale
            }
        });

        // Ajouter les composants à la fenêtre
        frame.add(scrollPane); // Ajouter le tableau
        frame.add(backButton); // Ajouter le bouton "Back"

        // Paramètres de la fenêtre
        frame.setSize(1100, 350); // Taille ajustée pour le tableau et le bouton
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Méthode pour définir les largeurs des colonnes
    private void setColumnWidths(JTable table) {
        // Définir les largeurs pour chaque colonne
        TableColumn column;

        // Largeur pour la colonne "Flight Number"
        column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(150); // Flight Number

        // Largeur pour la colonne "Departure"
        column = table.getColumnModel().getColumn(1);
        column.setPreferredWidth(150); // Departure

        // Largeur pour la colonne "Destination"
        column = table.getColumnModel().getColumn(2);
        column.setPreferredWidth(150); // Destination

        // Largeur pour la colonne "Available Seats"
        column = table.getColumnModel().getColumn(3);
        column.setPreferredWidth(150); // Available Seats

        // Largeur pour la colonne "Plane ID"
        column = table.getColumnModel().getColumn(4);
        column.setPreferredWidth(150); // Plane ID
    }
}