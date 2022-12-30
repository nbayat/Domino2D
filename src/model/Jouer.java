package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Jouer {
    private DominoModel dominosmodel;
    private ArrayList<DominoTuileModel> panelDeJeu = new ArrayList<DominoTuileModel>();

    public Jouer() {
        dominosmodel = new DominoModel(null);
    }

    public void printCurrentPlayer() {
        System.out.println("Joueur courant -> " + dominosmodel.getJoueurs()[0].getNom());
    }

    public void printALLPlayers() {
        for (int i = 0; i < dominosmodel.getJoueurs().length; i++) {
            System.out.println("Joueur " + i + " -> " + dominosmodel.getJoueurs()[i].getNom());
        }
    }

    public void printALLTuiles() {
        for (DominoTuileModel tuile : dominosmodel.getTuiles()) {
            // System.out.println(tuile);
            tuile.print();

        }
    }

    private void initJeu() {
        DominoTuileModel tmp = pivocher();
        tmp.setPosX(0);
        tmp.setPosY(0);
        panelDeJeu.add(tmp);
    }

    private DominoTuileModel pivocher() {
        return dominosmodel.getTuiles().remove(dominosmodel.getTuiles().size() - 1);
    }

    private void deposer(DominoTuileModel tuile, Joueur joueur, int positionX, int positionY) {
        if (peutEtreDeposer(tuile, positionX, positionY)) {
            tuile.setPosX(positionX);
            tuile.setPosY(positionY);
            panelDeJeu.add(tuile);
        } else {
            System.out.println("Tuile non déposé");
        }

    }

    private boolean peutEtreDeposer(DominoTuileModel tuile, int positionX, int positionY) {
        boolean tmp = false;
        for (int i = 0; i < panelDeJeu.size(); i++) {
            if (panelDeJeu.get(i) != null) {
                if (positionX == panelDeJeu.get(i).getPosX() && positionY == panelDeJeu.get(i).getPosY() + 1) {
                    if (Arrays.equals(tuile.getBottom(), panelDeJeu.get(i).getTop())) {
                        tmp = true;
                    } else {
                        return false;
                    }
                }
                if (positionX == panelDeJeu.get(i).getPosX() && positionY == panelDeJeu.get(i).getPosY() - 1) {
                    if (Arrays.equals(tuile.getTop(), panelDeJeu.get(i).getBottom())) {
                        tmp = true;
                    } else {
                        return false;
                    }
                }
                if (positionX == panelDeJeu.get(i).getPosX() + 1 && positionY == panelDeJeu.get(i).getPosY()) {
                    if (Arrays.equals(tuile.getLeft(), panelDeJeu.get(i).getRight())) {
                        tmp = true;
                    } else {
                        return false;
                    }
                }
                if (positionX == panelDeJeu.get(i).getPosX() - 1 && positionY == panelDeJeu.get(i).getPosY()) {
                    if (Arrays.equals(tuile.getRight(), panelDeJeu.get(i).getLeft())) {
                        tmp = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return tmp;
    }

    public int calculerScore(DominoTuileModel tuile, int positionX, int positionY) {
        int tmp = 0;
        for (int i = 0; i < panelDeJeu.size(); i++) {
            if (panelDeJeu.get(i) != null) {
                if (positionX == panelDeJeu.get(i).getPosX() && positionY == panelDeJeu.get(i).getPosY() + 1) {
                    if (Arrays.equals(tuile.getBottom(), panelDeJeu.get(i).getTop())) {
                        tmp = tmp + tuile.getBottom()[0] + tuile.getBottom()[1] + tuile.getBottom()[2];
                    }
                }
                if (positionX == panelDeJeu.get(i).getPosX() && positionY == panelDeJeu.get(i).getPosY() - 1) {
                    if (Arrays.equals(tuile.getTop(), panelDeJeu.get(i).getBottom())) {
                        tmp = tmp + tuile.getTop()[0] + tuile.getTop()[1] + tuile.getTop()[2];

                    }
                }
                if (positionX == panelDeJeu.get(i).getPosX() + 1 && positionY == panelDeJeu.get(i).getPosY()) {
                    if (Arrays.equals(tuile.getLeft(), panelDeJeu.get(i).getRight())) {
                        tmp = tmp + tuile.getLeft()[0] + tuile.getLeft()[1] + tuile.getLeft()[2];
                    }
                }
                if (positionX == panelDeJeu.get(i).getPosX() - 1 && positionY == panelDeJeu.get(i).getPosY()) {
                    if (Arrays.equals(tuile.getRight(), panelDeJeu.get(i).getLeft())) {
                        tmp = tmp + tuile.getRight()[0] + tuile.getRight()[1] + tuile.getRight()[2];
                    }
                }
            }
        }
        return tmp;
    }

    // print all tuiles in panel de jeu
    public void printPanelDeJeu() {
        for (DominoTuileModel tuile : panelDeJeu) {
            tuile.print();
        }
    }

    public static void main(String[] args) {
        Jouer jouer = new Jouer();
        jouer.printCurrentPlayer();
        jouer.printALLPlayers();

        jouer.initJeu();
        jouer.printPanelDeJeu();

        DominoTuileModel tmp = jouer.pivocher();

        // tmp.setLeft(jouer.panelDeJeu.get(0).getRight());

        tmp.print();

        jouer.deposer(tmp, null, 1, 0);
        // jouer.printPanelDeJeu();
        System.out.println(jouer.calculerScore(tmp, 1, 0));

        System.out.println(jouer.peutEtreDeposer(tmp, 1, 0));
        System.out.println(jouer.peutEtreDeposer(tmp, -1, 0));
    }
}
