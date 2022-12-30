package view.Dominos;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.Controller;
import model.DominoModel;
import view.Panels.ControllPanel;
import view.Panels.JeuMainPanel;

public class Dominos extends JPanel {
    private DominoModel model;
    private Controller controller;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Dominos(Controller controller, DominoModel model) {
        this.controller = controller;
        setPreferredSize(screenSize);
        this.setOpaque(false);

        DominoControllPanel controllPanel = new DominoControllPanel(controller, model);
        controllPanel.setPreferredSize(new Dimension(screenSize.width * 1 / 6, screenSize.height));

        JeuMainPanel jeuPanel = new JeuMainPanel();
        jeuPanel.setPreferredSize(new Dimension(screenSize.width * 5 / 6, screenSize.height));

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(controllPanel);
        this.add(jeuPanel);
    }

    public void setModel(DominoModel model) {
        this.model = model;
    }

    public class DominoControllPanel extends ControllPanel {
        public DominoControllPanel(Controller controller, DominoModel model) {
            super(controller, model);
        }

        @Override
        public void initButtons() {
            super.initButtons();
            addPivocherListener();
            addRetourVersMenuListener();
        }

        @Override
        public void addPivocherListener() {
            this.getPivocherButton().addActionListener(e -> {
                System.out.println("Pivocher");
            });
        }

        @Override
        public void addPasserListener() {
            // TODO Auto-generated method stub

        }

        @Override
        public void addAbandonnerListener() {
            // TODO Auto-generated method stub

        }

        @Override
        public void addTourner90Listener() {
            // TODO Auto-generated method stub

        }

        @Override
        public void addRetourVersMenuListener() {
            this.getRetourVersMenuButton().addActionListener(e -> {
                controller.startMenu();
            });
        }
    }
}
