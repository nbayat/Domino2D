package controller;

import view.Frame;
import view.Panels.Dominos;

public class Controller {
    public Controller() {
        Frame frame = new Frame(this);
    }

    void initDominos() {
        Dominos dominos = new Dominos();
    }
}
