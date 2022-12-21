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
}
