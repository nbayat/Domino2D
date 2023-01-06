package controller;

import view.Frame;

public class Controller {
    private Frame frame;
    private DominoController dominoController;

    public Controller() {
        frame = new Frame(this);
    }

    public void startDomino() {
        frame.removePanel();
        dominoController = new DominoController(this);
        frame.addPanel(dominoController.getDominoView());
    }

    public void startMenu() {
        frame.setPanelToMenu();
    }

}
