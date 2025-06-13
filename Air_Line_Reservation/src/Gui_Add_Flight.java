import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui_Add_Flight {
    public Gui_Add_Flight() {
        // Create a frame for the Add Flight window
        JFrame frame = new JFrame("Add Flight");
        frame.setLayout(null);

        // Flight ID label and text field
        JLabel label1 = new JLabel("Flight ID:");
        label1.setBounds(50, 50, 100, 25);
        JTextField flightIdField = new JTextField();
        flightIdField.setBounds(150, 50, 150, 25);

        // Destination label and text field
        JLabel label2 = new JLabel("Destination:");
        label2.setBounds(50, 100, 100, 25);
        JTextField destinationField = new JTextField();
        destinationField.setBounds(150, 100, 150, 25);

        // Departure label and text field
        JLabel label3 = new JLabel("Departure:");
        label3.setBounds(50, 150, 100, 25);
        JTextField departureField = new JTextField();
        departureField.setBounds(150, 150, 150, 25);

        // Date label and text field
        JLabel label4 = new JLabel("Date:");
        label4.setBounds(50, 200, 100, 25);
        JTextField dateField = new JTextField();
        dateField.setBounds(150, 200, 150, 25);

        // Time label and text field
        JLabel label5 = new JLabel("Time:");
        label5.setBounds(50, 250, 100, 25);
        JTextField timeField = new JTextField();
        timeField.setBounds(150, 250, 150, 25);

        // Capacity label and text field
        JLabel label6 = new JLabel("Capacity:");
        label6.setBounds(50, 300, 100, 25);
        JTextField capacityField = new JTextField();
        capacityField.setBounds(150, 300, 150, 25);

        // Submit button 
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 350, 100, 30); 

        // Back button 
        JButton backButton = new JButton("Back");
        backButton.setBounds(210, 350, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Ferme cette fenêtre
                new main1(); // Retour à l'interface principale
            }
        });

        // Add components to the frame
        frame.add(label1);
        frame.add(flightIdField);
        frame.add(label2);
        frame.add(destinationField);
        frame.add(label3);
        frame.add(departureField);
        frame.add(label4);
        frame.add(dateField);
        frame.add(label5);
        frame.add(timeField);
        frame.add(label6);
        frame.add(capacityField);
        frame.add(submitButton);
        frame.add(backButton);

        // frame size and color
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.CYAN);
    }
}
