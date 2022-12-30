package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

import controller.Controller;

public class Menu extends JPanel {

    public Menu(Controller controller) {
        // initialisation du panel
        setBorder(new EmptyBorder(50, 50, 50, 50));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.setBackground(Color.BLACK);
        // Button de dominos carrés
        JButton dominosbutton = new JButton("Les dominos carrés");
        dominosbutton.setPreferredSize(new DimensionUIResource(200, 50));
        dominosbutton.addActionListener(e -> controller.startDomino());
        // Button de Carcassonne
        JButton CarcassonneButton = new JButton("Carcassonne");
        CarcassonneButton.setPreferredSize(new DimensionUIResource(200, 50));
        // Jlabel de titre
        JLabel title = new JLabel("Le Projet 33 - BAYAT Nima");
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        // change color of titre to blue
        title.setForeground(Color.YELLOW);
        // ajouter les boutons au panel
        add(title, gbc);
        add(Box.createVerticalStrut(100));
        add(dominosbutton, gbc);
        add(Box.createVerticalStrut(50));
        add(CarcassonneButton, gbc);
    }

}
