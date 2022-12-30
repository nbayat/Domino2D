package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jouer {
    private DominoModel dominosModel;
    private ArrayList<DominoTuileModel> panelDeJeu = new ArrayList<DominoTuileModel>();

    public Jouer() {
        dominosModel = new DominoModel(null);
    }

    public void printCurrentPlayer() {
        System.out.println("Joueur courant -> " + dominosModel.getJoueurs().get(0).getNom());
    }

    public void printALLPlayers() {
        for (int i = 0; i < dominosModel.getJoueurs().size(); i++) {
            System.out.println("Joueur " + i + " -> " + dominosModel.getJoueurs().get(i).getNom());
        }
    }

    public void printALLTuiles() {
        for (DominoTuileModel tuile : dominosModel.getTuiles()) {
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
        System.out.println(dominosModel.getTuiles().size() + " ___________");
        return dominosModel.getTuiles().remove((int) (Math.random() * dominosModel.getTuiles().size()));
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

    public void commencerJeu(Scanner scanner) {
        while (this.dominosModel.getTuiles().size() > 0) {
            System.out.println("OK");
            for (Joueur j : this.dominosModel.getJoueurs()) {
                System.out.println(j);
            }
            for (int i = 0; i < this.dominosModel.getJoueurs().size(); i++) {
                Joueur j = this.dominosModel.getJoueurs().get(i);
                if (j.estSonTour()) {
                    System.out.println("OK1");
                    if (j.estHumain() == true && i > 200) { // test
                        // use scanner to get input
                        System.out.println("Veuillez saisir la position X");
                        int positionX = scanner.nextInt();
                        System.out.println("Veuillez saisir la position Y");
                        int positionY = scanner.nextInt();
                        DominoTuileModel tuile = this.pivocher();
                        if (this.peutEtreDeposer(tuile, positionX, positionY)) {
                            this.deposer(tuile, j, positionX, positionY);
                            j.setScore(j.getScore() + this.calculerScore(tuile, positionX, positionY));

                        } else {
                            System.out.println("Vous ne pouvez pas déposer cette tuile, Detruire !!");
                        }
                        this.dominosModel.setNextPlayer();
                        this.printPanelDeJeu();
                        break;
                    } else {
                        DominoTuileModel tuile = this.pivocher();
                        for (DominoTuileModel t : this.panelDeJeu) {
                            if (this.peutEtreDeposer(tuile, t.getPosX(), t.getPosY() + 1)) {
                                this.deposer(tuile, j, t.getPosX(), t.getPosY() + 1);
                                j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX(), t.getPosY() + 1));
                                break;
                            }
                            if (this.peutEtreDeposer(tuile, t.getPosX(), t.getPosY() - 1)) {
                                this.deposer(tuile, j, t.getPosX(), t.getPosY() - 1);
                                j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX(), t.getPosY() - 1));
                                break;
                            }
                            if (this.peutEtreDeposer(tuile, t.getPosX() + 1, t.getPosY())) {
                                this.deposer(tuile, j, t.getPosX() + 1, t.getPosY());
                                j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX() + 1, t.getPosY()));
                                break;
                            }
                            if (this.peutEtreDeposer(tuile, t.getPosX() - 1, t.getPosY())) {
                                this.deposer(tuile, j, t.getPosX() - 1, t.getPosY());
                                j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX() - 1, t.getPosY()));
                                break;
                            }
                        }
                        this.dominosModel.setNextPlayer();
                        this.printPanelDeJeu();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Jouer jouer = new Jouer();
        jouer.printCurrentPlayer();
        jouer.printALLPlayers();

        jouer.initJeu();
        jouer.printPanelDeJeu();

        Scanner scanner = new Scanner(System.in);

        jouer.commencerJeu(scanner);
    }

}
