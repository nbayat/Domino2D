package controller;

import java.util.Arrays;

import model.DominoModel;
import model.DominoTuileModel;
import model.Joueur;
import model.Model;
import view.Dominos.DominoTuile;
import view.Dominos.DominoView;

public class DominoController extends JeuController {
    private DominoModel model;
    private DominoView dominoView;
    private Controller controller;

    public DominoController() {
        this.model = new DominoModel(this);
        this.dominoView = new DominoView(this, model);
        initJeu();
    }

    public int quiAPlusDeNote() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < model.getJoueurs().size(); i++) {
            if (model.getJoueurs().get(i).getScore() > max) {
                max = model.getJoueurs().get(i).getScore();
                index = i;
            }
        }
        return index;
    }

    public DominoController(Controller controller) {
        this();
        this.controller = controller;
    }

    void joueurSonTourBOT(Joueur joueur) {
        if (joueur.estSonTour() && !joueur.estHumain()) {
            dominoView.pivocher();
            DominoTuile tuile = dominoView.getJeuPanel().getLastTuile();
            for (int i = 0; i < model.getPanelDeJeu().size() - 1; i++) {
                for (int t = 0; t < 4; t++) {
                    if (Arrays.equals(tuile.getDominoTuileModel().getLeft(),
                            model.getPanelDeJeu().get(i).getRight())
                            && !model.getPanelDeJeu().get(i).getdispoRight()
                            && peutEtreDeposer(tuile.getDominoTuileModel(),
                                    model.getPanelDeJeu().get(i).getPosX(), model.getPanelDeJeu().get(i).getPosY())) {
                        deposer(tuile, joueur, model.getPanelDeJeu().get(i).getPosX() + 100,
                                model.getPanelDeJeu().get(i).getPosY());
                        this.model.setNextPlayer();
                        return;
                    }
                    if (Arrays.equals(tuile.getDominoTuileModel().getRight(),
                            model.getPanelDeJeu().get(i).getLeft())
                            && !model.getPanelDeJeu().get(i).getdispoLeft()
                            && peutEtreDeposer(tuile.getDominoTuileModel(),
                                    model.getPanelDeJeu().get(i).getPosX(), model.getPanelDeJeu().get(i).getPosY())) {
                        deposer(tuile, joueur, model.getPanelDeJeu().get(i).getPosX() - 100,
                                model.getPanelDeJeu().get(i).getPosY());
                        this.model.setNextPlayer();
                        return;
                    }
                    if (Arrays.equals(tuile.getDominoTuileModel().getBottom(),
                            model.getPanelDeJeu().get(i).getTop())
                            && !model.getPanelDeJeu().get(i).getdispoTop()
                            && peutEtreDeposer(tuile.getDominoTuileModel(),
                                    model.getPanelDeJeu().get(i).getPosX(), model.getPanelDeJeu().get(i).getPosY())) {
                        deposer(tuile, joueur, model.getPanelDeJeu().get(i).getPosX(),
                                model.getPanelDeJeu().get(i).getPosY() - 150);
                        this.model.setNextPlayer();

                        return;
                    }
                    if (Arrays.equals(tuile.getDominoTuileModel().getTop(),
                            model.getPanelDeJeu().get(i).getBottom())
                            && !model.getPanelDeJeu().get(i).getdispoBottom()
                            && peutEtreDeposer(tuile.getDominoTuileModel(),
                                    model.getPanelDeJeu().get(i).getPosX(), model.getPanelDeJeu().get(i).getPosY())) {
                        deposer(tuile, joueur, model.getPanelDeJeu().get(i).getPosX(),
                                model.getPanelDeJeu().get(i).getPosY() + 150);
                        this.model.setNextPlayer();
                        return;
                    }
                    tourner90(tuile);
                }

            }
            System.out.println("skipping " + joueur.getNom());
            skipPlayer();
            return;
        }
    }

    public void tourner90(DominoTuile tuile) {
        tuile.getDominoTuileModel().rotate90();
        tuile.rotate();
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

    public void jeuer() {
        for (Joueur joueur : model.getJoueurs()) {
            this.isFinished();
            for (Joueur joueur2 : model.getJoueurs()) {
                System.out.println(joueur2);
            }
            System.out.println(joueur.getNom());
            if (joueur.estSonTour() && !joueur.estHumain()) {
                joueurSonTourBOT(joueur);
                System.out.println("done " + joueur.getNom());

            }
            if (joueur.estHumain() && joueur.estSonTour()) {
                System.out.println("C'est à " + joueur.getNom() + " de jouer");
                System.out.println("done " + joueur.getNom());
                return;
            }

        }
        System.out.println("Current" + currentJoueur().getNom());
    }

    public void initJeu() {
        DominoTuileModel tmp = pivocher();
        model.getPanelDeJeu().add(tmp);
        dominoView.initView();
    }

    public DominoTuileModel pivocher() {
        isFinished();
        if (model.getTuiles().size() > 0) {
            DominoTuileModel tmp = model.getTuiles().remove((int) (Math.random() * model.getTuiles().size()));
            model.getPanelDeJeu().add(tmp);
            return tmp;
        }
        return null;
    }

    public void deposer(DominoTuile tuile, Joueur joueur, int positionX, int positionY) {
        if (true) {

            dominoView.getJeuPanel().removeLastTuile();
            dominoView.getJeuPanel().addTuile(tuile, positionX, positionY);
            tuile.getDominoTuileModel().setIsPlaced(true);
            tuile.makeUnDraggable(tuile);
            joueur.setScore(joueur.getScore() + calculerScore(tuile.getDominoTuileModel(), positionX, positionY));
            dominoView.updateScores();
            System.out.println(joueur.getNom() + " a déposé une tuile");
        }
    }

    public void isFinished() {
        if (this.model.getTuiles().size() <= 0) {
            dominoView.isFinished(model.getJoueurs().get(quiAPlusDeNote()));
        }
    }

    public boolean peutEtreDeposer(DominoTuileModel tuile, int positionX, int positionY) {
        boolean tmp = false;
        for (int i = 0; i < model.getPanelDeJeu().size(); i++) {

            boolean conditon1 = positionX >= model.getPanelDeJeu().get(i).getPosX() + 0
                    && positionX < model.getPanelDeJeu().get(i).getPosX() + 100;
            boolean conditon2 = positionX <= model.getPanelDeJeu().get(i).getPosX() - 0
                    && positionX > model.getPanelDeJeu().get(i).getPosX() - 100;

            boolean conditon3 = positionY >= model.getPanelDeJeu().get(i).getPosY() + 0
                    && positionY < model.getPanelDeJeu().get(i).getPosY() + 100;

            boolean conditon4 = positionY <= model.getPanelDeJeu().get(i).getPosY() - 0
                    && positionY > model.getPanelDeJeu().get(i).getPosY() - 100;

            boolean condition5 = positionX == model.getPanelDeJeu().get(i).getPosX();
            boolean condition6 = positionY == model.getPanelDeJeu().get(i).getPosY();
            boolean condition = ((conditon1 || conditon2) && (conditon3 || conditon4));

            if (condition) {
                if (conditon1 && !condition6) {
                    if (!Arrays.equals(tuile.getLeft(), model.getPanelDeJeu().get(i).getRight())) {
                        System.out.println(false + "1");
                        return false;
                    }
                }
                if (conditon2 && !condition6) {
                    if (!Arrays.equals(tuile.getRight(), model.getPanelDeJeu().get(i).getLeft())) {
                        System.out.println(false + "2");
                        return false;
                    }
                }
                if (conditon3 && !condition5) {
                    if (!Arrays.equals(tuile.getTop(), model.getPanelDeJeu().get(i).getBottom())) {
                        System.out.println(false + "3");

                        return false;
                    }
                }
                if (conditon4 && !condition5) {
                    if (!Arrays.equals(tuile.getBottom(), model.getPanelDeJeu().get(i).getTop())) {
                        System.out.println(false + "4");

                        return false;
                    }
                }
            }
            System.out.println(true);
        }
        return true;
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
                        tuile.setdispoBottom(true);
                        model.getPanelDeJeu().get(i).setdispoTop(true);
                    }
                }
                if (conditon3) {
                    if (Arrays.equals(tuile.getTop(), model.getPanelDeJeu().get(i).getBottom())) {
                        tmp = tmp + tuile.getTop()[0] + tuile.getTop()[1] + tuile.getTop()[2];
                        tuile.setdispoTop(true);
                        model.getPanelDeJeu().get(i).setdispoBottom(true);
                    }
                }
                if (conditon1) {
                    if (Arrays.equals(tuile.getLeft(), model.getPanelDeJeu().get(i).getRight())) {
                        tmp = tmp + tuile.getLeft()[0] + tuile.getLeft()[1] + tuile.getLeft()[2];
                        tuile.setdispoLeft(true);
                        model.getPanelDeJeu().get(i).setdispoRight(true);
                    }
                }
                if (conditon2) {
                    if (Arrays.equals(tuile.getRight(), model.getPanelDeJeu().get(i).getLeft())) {
                        tmp = tmp + tuile.getRight()[0] + tuile.getRight()[1] + tuile.getRight()[2];
                        tuile.setdispoRight(true);
                        model.getPanelDeJeu().get(i).setdispoLeft(true);
                    }
                }
            }
        }
        return tmp;
    }

    public void skipPlayer() {
        if (!model.getPanelDeJeu().get(model.getPanelDeJeu().size() - 1).isPlaced()) {

            if (!this.currentJoueur().estHumain()) {
                dominoView.getJeuPanel().dialogBox("Le joueur " + this.currentJoueur().getNom() + " a passé son tour");
            }
            model.removeLastTuile();
            this.dominoView.getJeuPanel().removeLastTuile();
        }
        if (currentJoueur().estHumain()) {
            this.model.setNextPlayer();
            this.jeuer();
        } else {
            this.model.setNextPlayer();
        }
    }

    public void nextPlayer() {
        if (currentJoueur().estHumain()) {
            this.model.setNextPlayer();
            this.jeuer();
        } else {
            this.model.setNextPlayer();
        }
    }

    @Override
    public Model getModel() {
        return null;
    }

    public void retourVersMenu() {
        this.controller.startMenu();
    }

}
