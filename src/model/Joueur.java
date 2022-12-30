package model;

public class Joueur {
    private int point;
    private String nom;
    private boolean estHumain;
    private boolean estSonTour;

    public Joueur(String nom, boolean estHumain) {
        this.nom = nom;
        this.estHumain = estHumain;
        this.estSonTour = false;
        this.point = 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPoint() {
        return point;
    }

    public boolean estSonTour() {
        return this.estSonTour;
    }

    public void setEstSonTour(boolean estSonTour) {
        this.estSonTour = estSonTour;
    }

}
