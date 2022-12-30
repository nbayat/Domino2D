package model;

public class DominoModel {
    private Joueur[] Joueurs;
    private DominoTuileModel[] tuiles;

    public DominoModel() {
        this.Joueurs = new Joueur[4];
        initJoueurs();
        this.tuiles = new DominoTuileModel[28];
        initTuile();
    }

    public Joueur[] getJoueurs() {
        return Joueurs;
    }

    public DominoTuileModel[] getTuiles() {
        return tuiles;
    }

    private void initJoueurs() {
        for (int i = 0; i < 3; i++) {
            this.Joueurs[i] = new Joueur("joueur  " + i, false);
        }
        this.Joueurs[3] = new Joueur("Vous", true);
    }

    private void initTuile() {
        for (int i = 0; i < 28; i++) {
            this.tuiles[i] = new DominoTuileModel();
        }
    }
}
