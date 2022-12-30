package view.Panels;

import javax.swing.JPanel;

import controller.Controller;
import model.DominoModel;

import javax.swing.*;
import java.awt.*;

public abstract class ControllPanel extends JPanel {
    private JPanel scores, buttons;
    private DominoModel model;
    private Controller controller;

    private JPanel pivocher, passer, abandonner, tourner90, retourVersMenu;
    private JButton pivocherButton, passerButton, abandonnerButton, tourner90Button, retourVersMenuButton;

    public ControllPanel(Controller controller, DominoModel model) {
        scores = new JPanel();
        buttons = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.model = model;
        this.controller = controller;

        initScores();
        initButtons();

        this.add(scores);
        this.add(Box.createVerticalGlue());
        this.add(buttons);

    }

    public void update() {
        this.removeAll();
        this.add(scores);
        this.add(buttons);
        this.revalidate();
        this.repaint();
    }

    public void setScores(JPanel scores) {
        this.scores = scores;
    }

    public void setButtons(JPanel buttons) {
        this.buttons = buttons;
    }

    public JPanel getScores() {
        return scores;
    }

    public JPanel getButtons() {
        return buttons;
    }

    public void initScores() {
        if (this.scores == null)
            this.scores = new JPanel();
        // set layout of scores to vertically align
        this.scores.setLayout(new BoxLayout(this.scores, BoxLayout.Y_AXIS));
        // add margin to scores
        this.scores.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        for (int i = 0; i < this.model.getJoueurs().size(); i++) {
            // make two JLabels for each player name and score and add them to a JPanel with
            // space in between
            JLabel name = new JLabel(this.model.getJoueurs().get(i).getNom());
            JLabel score = new JLabel(Integer.toString(this.model.getJoueurs().get(i).getPoint()));
            JPanel player = new JPanel();
            player.setLayout(new BoxLayout(player, BoxLayout.X_AXIS));
            player.add(name);
            // add all the space between name and score
            player.add(Box.createHorizontalGlue());
            player.add(score);
            // add vertical margin to the player JPanel
            player.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
            // add the player JPanel to the scores JPanel
            this.scores.add(player);

        }
    }

    public void initButtons() {
        // create a new JPanel for the buttons
        if (this.buttons == null)
            this.buttons = new JPanel();

        // set layout of buttons to vertically align
        this.buttons.setLayout(new BoxLayout(this.buttons, BoxLayout.Y_AXIS));
        // add margin to buttons
        this.buttons.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));

        pivocher = new JPanel();
        pivocherButton = new JButton("Pivocher");
        pivocherButton.setPreferredSize(new Dimension(200, 35));
        pivocher.add(pivocherButton);

        passer = new JPanel();
        passerButton = new JButton("Passer");
        passerButton.setPreferredSize(new Dimension(200, 35));
        passer.add(passerButton);

        abandonner = new JPanel();
        abandonnerButton = new JButton("Abandonner");
        abandonnerButton.setPreferredSize(new Dimension(200, 35));
        abandonner.add(abandonnerButton);

        tourner90 = new JPanel();
        tourner90Button = new JButton("Tourner 90");
        tourner90Button.setPreferredSize(new Dimension(200, 35));
        tourner90.add(tourner90Button);

        retourVersMenu = new JPanel();
        retourVersMenuButton = new JButton("Retour vers menu");
        retourVersMenuButton.setPreferredSize(new Dimension(200, 35));
        retourVersMenu.add(retourVersMenuButton);

        this.buttons.add(pivocher);
        this.buttons.add(passer);
        this.buttons.add(abandonner);
        this.buttons.add(tourner90);
        this.buttons.add(retourVersMenu);

    }

    public abstract void addPivocherListener();

    public abstract void addPasserListener();

    public abstract void addAbandonnerListener();

    public abstract void addTourner90Listener();

    public abstract void addRetourVersMenuListener();

    public JButton getPivocherButton() {
        return pivocherButton;
    }

    public JButton getPasserButton() {
        return passerButton;
    }

    public JButton getRetourVersMenuButton() {
        return retourVersMenuButton;
    }

    public JButton getAbandonnerButton() {
        return abandonnerButton;
    }

    public JPanel getTourner90() {
        return tourner90;
    }

}
