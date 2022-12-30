package view.Panels;

import javax.swing.JPanel;

import model.DominoModel;

import javax.swing.*;
import java.awt.*;

public class ControllPanel extends JPanel {
    private JPanel scores, buttons;
    private DominoModel model;

    public ControllPanel() {
        scores = new JPanel();
        buttons = new JPanel();
        this.model = new DominoModel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
        for (int i = 0; i < this.model.getJoueurs().length; i++) {
            // make two JLabels for each player name and score and add them to a JPanel with
            // space in between
            JLabel name = new JLabel(this.model.getJoueurs()[i].getNom());
            JLabel score = new JLabel(Integer.toString(this.model.getJoueurs()[i].getPoint()));
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

        JPanel pivocher = new JPanel();
        JButton pivocherButton = new JButton("Pivocher");
        pivocherButton.setPreferredSize(new Dimension(200, 35));
        pivocher.add(pivocherButton);

        JPanel passer = new JPanel();
        JButton passerButton = new JButton("Passer");
        passerButton.setPreferredSize(new Dimension(200, 35));
        passer.add(passerButton);

        JPanel abandonner = new JPanel();
        JButton abandonnerButton = new JButton("Abandonner");
        abandonnerButton.setPreferredSize(new Dimension(200, 35));
        abandonner.add(abandonnerButton);

        JPanel tourner90 = new JPanel();
        JButton tourner90Button = new JButton("Tourner 90");
        tourner90Button.setPreferredSize(new Dimension(200, 35));
        tourner90.add(tourner90Button);

        JPanel retourVersMenu = new JPanel();
        JButton retourVersMenuButton = new JButton("Retour vers menu");
        retourVersMenuButton.setPreferredSize(new Dimension(200, 35));
        retourVersMenu.add(retourVersMenuButton);

        this.buttons.add(pivocher);
        this.buttons.add(passer);
        this.buttons.add(abandonner);
        this.buttons.add(tourner90);
        this.buttons.add(retourVersMenu);

    }
}
