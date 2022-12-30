package model;

import controller.Controller;

public class Model {
    private Joueur[] Joueurs;
    private Controller controller;

    public Model(Controller controller) {
        this.controller = controller;

        this.Joueurs = new Joueur[4];
        initJoueurs();
    }

    public Joueur[] getJoueurs() {
        return Joueurs;
    }

    private void initJoueurs() {
        for (int i = 0; i < 3; i++) {
            this.Joueurs[i] = new Joueur("joueur  " + i, false);
        }
        this.Joueurs[3] = new Joueur("Vous", true);
    }

}
