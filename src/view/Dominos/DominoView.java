package view.Dominos;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.DominoController;
import model.DominoModel;
import model.DominoTuileModel;
import model.Joueur;
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

    public void initView() {
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

    public void returnToMenu() {
        this.controller.retourVersMenu();
    }

    public void isFinished(Joueur winner) {
        Object[] options = { "OK" };
        int n = JOptionPane.showOptionDialog(this, "Le jeu est fini --> " + winner.getNom() + " est le winner",
                "Fin du jeu", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 0) {

            System.exit(0);
        }

    }

    public void skipPlayer() {
        this.controller.skipPlayer();
        this.revalidate();
        this.repaint();

    }

    public void setModel(DominoModel model) {
        this.model = model;
    }

    public void tourner90() {
        if (this.jeuPanel.getLastTuile() instanceof DominoTuile) {
            DominoTuile tuile = this.jeuPanel.getLastTuile();
            controller.tourner90(tuile);
        }

    }

    public void disablePivocher() {
        this.getDominoControllPanel().diablePivocher();
    }

    public void enablePivocher() {
        this.getDominoControllPanel().enablePivocher();
    }

    public DominoControllPanel getDominoControllPanel() {
        return (DominoControllPanel) this.controllPanel;
    }

    public void updateScores() {
        this.getDominoControllPanel().updateScores();
        this.revalidate();
        this.repaint();
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
            addPasserListener();
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

        }

        @Override
        public void addRetourVersMenuListener() {
            this.getRetourVersMenuButton().addActionListener(e -> {
                returnToMenu();
            });
        }

        public void diablePivocher() {
            this.getPivocherButton().setEnabled(false);
            revalidate();
            repaint();
        }

        public void enablePivocher() {
            this.getPivocherButton().setEnabled(true);
            revalidate();
            repaint();
        }
    }
}
