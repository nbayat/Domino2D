package model;

public class Joueur {
    private int score;
    private String nom;
    private boolean estHumain;
    private boolean estSonTour;

    public Joueur(String nom, boolean estHumain) {
        this.nom = nom;
        this.estHumain = estHumain;
        this.estSonTour = false;
        this.score = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPoint() {
        return score;
    }

    public boolean estSonTour() {
        return this.estSonTour;
    }

    public void setEstSonTour(boolean estSonTour) {
        this.estSonTour = estSonTour;
    }

    public boolean estHumain() {
        return this.estHumain;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Joueur [nom=" + nom + ", estHumain=" + estHumain + ", estSonTour=" + estSonTour + ", score=" + score
                + "]";
    }

}
