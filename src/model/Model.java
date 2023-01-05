package model;

import java.util.ArrayList;

import controller.JeuController;

public class Model {
    private ArrayList<Joueur> Joueurs;
    private JeuController controller;

    public Model(JeuController controller) {
        this.controller = controller;

        this.Joueurs = new ArrayList<Joueur>();
        initJoueurs();
    }

    public ArrayList<Joueur> getJoueurs() {
        return Joueurs;
    }

    private void initJoueurs() {
        this.Joueurs.add(new Joueur("Vous  ", true));
        this.Joueurs.get(0).setEstSonTour(true);
        for (int i = 1; i < 4; i++) {
            this.Joueurs.add(new Joueur("Joueur  " + i, false));
        }
    }

    public void setNextPlayer() {
        for (int i = 0; i < Joueurs.size(); i++) {
            if (Joueurs.get(i).estSonTour()) {
                Joueurs.get(i).setEstSonTour(false);
                if (i == Joueurs.size() - 1) {
                    Joueurs.get(0).setEstSonTour(true);
                } else {
                    Joueurs.get(i + 1).setEstSonTour(true);
                }
                break;
            }
        }
    }

}
