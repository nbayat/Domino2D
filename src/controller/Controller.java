package controller;

import model.DominoModel;
import view.Frame;
import view.Panels.Dominos;

public class Controller {
    private Frame frame;
    private DominoModel dominosmodel = null;
    private Dominos dominosView = null;

    public Controller() {
        frame = new Frame(this);
    }

    public void startDomino() {
        frame.removePanel();
        dominosView = new Dominos();
        dominosmodel = new DominoModel();
        frame.addPanel(dominosView);
    }

}
