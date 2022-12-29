package view.JeuPanel;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.DominoModel;
import view.JeuMainPanel;
import view.JeuComponet.DominoTuile;

public class Dominos extends JPanel {
    private DominoModel model;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Dominos() {
        model = new DominoModel();
        setPreferredSize(screenSize);
        this.setOpaque(false);

        JPanel red = new JPanel();
        red.setBackground(Color.RED);
        red.setPreferredSize(new Dimension(screenSize.width * 1 / 6, screenSize.height));

        JeuMainPanel jeuPanel = new JeuMainPanel();
        jeuPanel.setPreferredSize(new Dimension(screenSize.width * 5 / 6, screenSize.height));

        DominoTuile test = new DominoTuile();
        // jeuPanel.setPanel(test, 20, 100);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(red);
        this.add(jeuPanel);
    }

}
