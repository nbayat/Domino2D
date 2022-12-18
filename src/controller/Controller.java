package controller;

import view.Frame;
import view.JeuPanel.Dominos;

public class Controller {
    public Controller() {
        Frame frame = new Frame(this);
    }

    void initDominos() {
        Dominos dominos = new Dominos(); 
    }
}
