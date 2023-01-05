package controller;

import model.DominoTuileModel;
import model.Joueur;

public abstract class Jeu {

    public abstract Joueur currentJoueur();

    public abstract void initJeu();

    public abstract DominoTuileModel pivocher();

    public abstract void deposer(DominoTuileModel tuile, Joueur joueur, int positionX, int positionY);

    public abstract boolean peutEtreDeposer(DominoTuileModel tuile, int positionX, int positionY);

    public abstract boolean positionEstDisponible(int positionX, int positionY);

    public abstract int calculerScore(DominoTuileModel tuile, int positionX, int positionY);

    public abstract void commencerJeu();
}
