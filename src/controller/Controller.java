package controller;

import model.DominoModel;
import view.Frame;
import view.Dominos.Dominos;

public class Controller {
    private Frame frame;
    private DominoModel dominosmodel = null;
    private Dominos dominosView = null;

    private JeuDomino dominoJeu = null;

    public Controller() {
        frame = new Frame(this);
    }

    public void startDomino() {
        frame.removePanel();
        dominosmodel = new DominoModel(this);
        dominosView = new Dominos(this, dominosmodel);
        dominosView.setModel(dominosmodel);
        dominoJeu = new JeuDomino(this, dominosmodel);
        dominoJeu.initJeu();
        dominosView.initJeu();
        frame.addPanel(dominosView);
    }

    public void startMenu() {
        frame.setPanelToMenu();
    }

}
