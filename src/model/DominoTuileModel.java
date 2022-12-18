package model;

public class DominoTuileModel {
    private int[] masterTableu, droite, gauche, haut, bas;

    public DominoTuileModel() {
        masterTableu = new int[12];
        randomize();
    }

    public void randomize() {
        for (int i = 0; i < 12; i++) {
            masterTableu[i] = (int) (Math.random() * 10);
        }
    }

    void fillDroit() {
        for (int i = 0; i < 4; i++) {
            droite[i] = masterTableu[i];
        }
    }

    void fillGauche() {
        for (int i = 0; i < 4; i++) {
            gauche[i] = masterTableu[i + 4];
        }
    }

    void fillHaut() {
        for (int i = 0; i < 4; i++) {
            haut[i] = masterTableu[i + 8];
        }
    }

    void fillBas() {
        for (int i = 0; i < 4; i++) {
            bas[i] = masterTableu[i + 12];
        }
    }

}
