package view.Dominos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.Controller;
import model.DominoModel;
import model.DominoTuileModel;
import view.Panels.ControllPanel;
import view.Panels.JeuMainPanel;

public class Dominos extends JPanel {
    private DominoModel model;
    private Controller controller;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    private JeuMainPanel jeuPanel;
    private ControllPanel controllPanel;

    public Dominos(Controller controller, DominoModel model) {
        this.controller = controller;
        setPreferredSize(screenSize);
        this.setOpaque(false);

        controllPanel = new DominoControllPanel(controller, model);
        controllPanel.setPreferredSize(new Dimension(screenSize.width * 1 / 6, screenSize.height));

        jeuPanel = new JeuMainPanel();
        jeuPanel.setPreferredSize(new Dimension(screenSize.width * 5 / 6, screenSize.height));

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(controllPanel);
        this.add(jeuPanel);
    }

    public JeuMainPanel getJeuPanel() {
        return jeuPanel;
    }

    public ControllPanel getControllPanel() {
        return controllPanel;
    }

    public void initJeu() {
        DominoTuileModel tmp = this.model.getPanelDeJeu().get(0);
        Point viewCenter = this.jeuPanel.getViewCenter();
        DominoTuile tuile = new DominoTuile(tmp, this.controller);
        tuile.makeUnDraggable(tuile);
        this.jeuPanel.addTuile(tuile, (int) viewCenter.getX(), (int) viewCenter.getY());
        this.jeuPanel.setViewPosition((int) tuile.getBounds().getX(), (int) tuile.getBounds().getY() / 2 + 50);
    }

    public void pivocher() {
        DominoTuileModel tmp = this.controller.getDominoJeu().pivocher();
        Point viewCenter = this.jeuPanel.getViewCenter();
        DominoTuile tuile = new DominoTuile(tmp, this.controller);
        this.jeuPanel.addTuile(tuile, (int) viewCenter.getX() + 100, (int) viewCenter.getY() + 100);
        this.jeuPanel.setViewPosition((int) tuile.getBounds().getX(), (int) tuile.getBounds().getY() / 2 + 50);
    }

    public void skipPlayer() {
        this.controller.getDominoJeu().skipPlayer();
    }

    public void setModel(DominoModel model) {
        this.model = model;
    }

    public void tourner90() {
        if (this.jeuPanel.getLastTuile() instanceof DominoTuile) {
            DominoTuile tuile = this.jeuPanel.getLastTuile();
            tuile.getDominoTuileModel().rotate90();
            tuile.rotate();
            System.out.println("tourner90");
        }

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
            addTourner90Listener();
        }

        @Override
        public void addPivocherListener() {
            this.getPivocherButton().addActionListener(e -> {
                pivocher();
            });
        }

        @Override
        public void addPasserListener() {
            this.getPasserButton().addActionListener(e -> {
                skipPlayer();
            });
        }

        @Override
        public void addAbandonnerListener() {
            // TODO Auto-generated method stub

        }

        @Override
        public void addTourner90Listener() {
            this.getTourner90().addActionListener(e -> {
                tourner90();
            });
            System.out.println("addTourner90Listener");
        }

        @Override
        public void addRetourVersMenuListener() {
            this.getRetourVersMenuButton().addActionListener(e -> {
                controller.startMenu();
            });
        }
    }

}
