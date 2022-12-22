package model;

import model.interfaces.TuileModelInterface;

public class DominoTuileModel implements TuileModelInterface {
    private int[] masterTableu, left, right, top, bottom;
    // les valeurs possibles pour chaque cote de la tuile
    // en suite on va les mettre dans les tableaux de la maniere rendom
    private static final int[][] valeurPossible = {
            { 2, 0, 1 },
            { 6, 0, 2 },
            { 2, 0, 3 },
            { 3, 0, 4 },
            { 2, 7, 9 },
            { 5, 6, 2 }
    };

    public DominoTuileModel() {
        left = new int[3];
        right = new int[3];
        top = new int[3];
        bottom = new int[3];
        masterTableu = new int[12];
        init();
    }

    @Override
    public void init() {
        // on va mettre les valeurs dans les tableaux
        for (int i = 0; i < 3; i++) {
            int index = (int) (Math.random() * valeurPossible.length);
            left = valeurPossible[index].clone();
            index = (int) (Math.random() * valeurPossible.length);
            right = valeurPossible[index].clone();
            index = (int) (Math.random() * valeurPossible.length);
            top = valeurPossible[index].clone();
            index = (int) (Math.random() * valeurPossible.length);
            bottom = valeurPossible[index].clone();
        }
        // on va alors composer le tableau masterTableu avec les 4 sous tableaux
        // de la maniere qui correspond a notre view
        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                    masterTableu[i] = top[0];
                    break;
                case 1:
                    masterTableu[i] = top[1];
                    break;
                case 2:
                    masterTableu[i] = top[2];
                    break;
                case 3:
                    masterTableu[i] = left[0];
                    break;
                case 4:
                    masterTableu[i] = right[0];
                    break;
                case 5:
                    masterTableu[i] = left[1];
                    break;
                case 6:
                    masterTableu[i] = right[1];
                    break;
                case 7:
                    masterTableu[i] = left[2];
                    break;
                case 8:
                    masterTableu[i] = right[2];
                    break;
                case 9:
                    masterTableu[i] = bottom[0];
                    break;
                case 10:
                    masterTableu[i] = bottom[1];
                    break;
                case 11:
                    masterTableu[i] = bottom[2];
                    break;
                default:
                    break;
            }
        }
    }

    public int[] getMasterTableu() {
        return masterTableu;
    }

    @Override
    public void rotate90() {
        int[] temp = top;
        top = left;
        left = bottom;
        bottom = right;
        right = temp;
        init();
    }

    @Override
    public void rotate180() {
        rotate90();
        rotate90();
    }

    @Override
    public void rotate270() {
        rotate180();
        rotate90();
    }

}
