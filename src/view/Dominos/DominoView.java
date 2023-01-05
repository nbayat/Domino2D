package view.Dominos;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.DominoController;
import controller.JeuController;
import model.DominoModel;
import model.DominoTuileModel;
import view.Panels.ControllPanel;
import view.Panels.JeuMainPanel;

public class DominoView extends JPanel {
    private DominoModel model;
    private DominoController controller;

    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    private JeuMainPanel jeuPanel;
    private ControllPanel controllPanel;

    public DominoView(DominoController controller, DominoModel model) {
        this.controller = (DominoController) controller;
        this.model = model;
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

    public DominoModel getModel() {
        return model;
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
        DominoTuileModel tmp = controller.pivocher();
        Point viewCenter = this.jeuPanel.getViewCenter();
        DominoTuile tuile = new DominoTuile(tmp, this.controller);
        this.jeuPanel.addTuile(tuile, (int) viewCenter.getX() + 100, (int) viewCenter.getY() + 100);
        this.jeuPanel.setViewPosition((int) tuile.getBounds().getX(), (int) tuile.getBounds().getY() / 2 + 50);
    }

    public void skipPlayer() {
        this.controller.skipPlayer();
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
        public DominoControllPanel(DominoController controller, DominoModel model) {
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

        }
    }

}
