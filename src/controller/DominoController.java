package controller;

import java.util.Arrays;

import Interfaces.TuileModelInterface;
import model.DominoModel;
import model.DominoTuileModel;
import model.Joueur;
import model.Model;
import view.Dominos.DominoTuile;
import view.Dominos.DominoView;

public class DominoController extends JeuController {
    private DominoModel model;
    private DominoView dominoView;

    public DominoController() {
        this.model = new DominoModel(this);
        this.dominoView = new DominoView(this, model);
        if (dominoView.getModel() == null)
            dominoView.setModel(model);
    }

    public void tourner90(TuileModelInterface tuile) {
        tuile.rotate90();
    }

    public DominoView getDominoView() {
        return dominoView;
    }

    public Joueur currentJoueur() {
        for (Joueur joueur : model.getJoueurs()) {
            if (joueur.estSonTour()) {
                return joueur;
            }
        }
        return null;
    }

    public void initJeu() {
        DominoTuileModel tmp = pivocher();
        tmp.setPosX(0);
        tmp.setPosY(0);
        model.getPanelDeJeu().add(tmp);
    }

    public DominoTuileModel pivocher() {
        return model.getTuiles().remove((int) (Math.random() * model.getTuiles().size()));
    }

    public void deposer(DominoTuileModel tuile, Joueur joueur, int positionX, int positionY) {
        if (peutEtreDeposer(tuile, positionX, positionY)) {
            tuile.setPosX(positionX);
            tuile.setPosY(positionY);
            model.getPanelDeJeu().add(tuile);
        } else {
            System.out.println("Tuile non déposé");
        }

    }

    public void deposer(DominoTuile tuile, Joueur joueur, int positionX, int positionY) {
        if (peutEtreDeposer(tuile.getDominoTuileModel(), positionX, positionY)) {
            tuile.makeUnDraggable(tuile);
            joueur.setScore(calculerScore(tuile.getDominoTuileModel(), positionX, positionY));
            System.out.println(calculerScore(tuile.getDominoTuileModel(), positionX, positionY));
            System.out.println("Tuile déposé");
        }

    }

    public boolean peutEtreDeposer(DominoTuileModel tuile, int positionX, int positionY) {
        boolean tmp = false;
        for (int i = 0; i < model.getPanelDeJeu().size(); i++) {
            if (model.getPanelDeJeu().get(i) != null) {

                System.out.println("positionX: " + positionX + " positionY: " + positionY);
                System.out.println("positionX: " + model.getPanelDeJeu().get(i).getPosX()
                        + " positionY: " + model.getPanelDeJeu().get(i).getPosY());

                boolean conditon1 = positionX >= model.getPanelDeJeu().get(i).getPosX() + 0
                        && positionX < model.getPanelDeJeu().get(i).getPosX() + 150;
                boolean conditon2 = positionX <= model.getPanelDeJeu().get(i).getPosX() - 0
                        && positionX > model.getPanelDeJeu().get(i).getPosX() - 150;

                boolean conditon3 = positionY >= model.getPanelDeJeu().get(i).getPosY() + 0
                        && positionY < model.getPanelDeJeu().get(i).getPosY() + 150;

                boolean conditon4 = positionY <= model.getPanelDeJeu().get(i).getPosY() - 0
                        && positionY > model.getPanelDeJeu().get(i).getPosY() - 150;

                boolean condition = ((conditon1 || conditon2) && (conditon3 || conditon4));

                if (condition) {
                    if (conditon1) {
                        if (Arrays.equals(tuile.getLeft(), model.getPanelDeJeu().get(i).getRight())) {
                            tmp = true;
                        }
                    } else if (conditon2) {
                        if (Arrays.equals(tuile.getRight(), model.getPanelDeJeu().get(i).getLeft())) {
                            tmp = true;
                        }
                    }

                    if (conditon3) {
                        if (Arrays.equals(tuile.getTop(), model.getPanelDeJeu().get(i).getBottom())) {
                            tmp = true;
                        }
                    } else if (conditon4) {
                        if (Arrays.equals(tuile.getBottom(), model.getPanelDeJeu().get(i).getTop())) {
                            tmp = true;
                        }
                    }

                    System.out.println("test");
                }
            }
        }
        return tmp;
    }

    public int calculerScore(DominoTuileModel tuile, int positionX, int positionY) {
        int tmp = 0;

        for (int i = 0; i < model.getPanelDeJeu().size(); i++) {
            boolean conditon1 = positionX >= model.getPanelDeJeu().get(i).getPosX() + 0
                    && positionX < model.getPanelDeJeu().get(i).getPosX() + 150;
            boolean conditon2 = positionX <= model.getPanelDeJeu().get(i).getPosX() - 0
                    && positionX > model.getPanelDeJeu().get(i).getPosX() - 150;

            boolean conditon3 = positionY >= model.getPanelDeJeu().get(i).getPosY() + 0
                    && positionY < model.getPanelDeJeu().get(i).getPosY() + 150;

            boolean conditon4 = positionY <= model.getPanelDeJeu().get(i).getPosY() - 0
                    && positionY > model.getPanelDeJeu().get(i).getPosY() - 150;

            if (model.getPanelDeJeu().get(i) != null) {
                if (conditon4) {
                    if (Arrays.equals(tuile.getBottom(), model.getPanelDeJeu().get(i).getTop())) {
                        tmp = tmp + tuile.getBottom()[0] + tuile.getBottom()[1] + tuile.getBottom()[2];
                    }
                }
                if (conditon3) {
                    if (Arrays.equals(tuile.getTop(), model.getPanelDeJeu().get(i).getBottom())) {
                        tmp = tmp + tuile.getTop()[0] + tuile.getTop()[1] + tuile.getTop()[2];

                    }
                }
                if (conditon1) {
                    if (Arrays.equals(tuile.getLeft(), model.getPanelDeJeu().get(i).getRight())) {
                        tmp = tmp + tuile.getLeft()[0] + tuile.getLeft()[1] + tuile.getLeft()[2];
                    }
                }
                if (conditon2) {
                    if (Arrays.equals(tuile.getRight(), model.getPanelDeJeu().get(i).getLeft())) {
                        tmp = tmp + tuile.getRight()[0] + tuile.getRight()[1] + tuile.getRight()[2];
                    }
                }
            }
        }
        return tmp;
    }

    public void skipPlayer() {
        this.model.setNextPlayer();
    }

    public void botPlay() {
        for (int i = 0; i < this.model.getJoueurs().size(); i++) {

        }
    }

    @Override
    public Model getModel() {
        return null;
    }

}
