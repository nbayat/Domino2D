package model;

import Interfaces.TuileModelInterface;

public class DominoTuileModel implements TuileModelInterface {
    private int[] masterTableu, left, right, top, bottom;
    private boolean dispoTop = false, dispoBottom = false, dispoLeft = false, dispoRight = false;

    private int posX, posY; // pour savoir la position relative de la tuile

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
        posX = -1000;
        posY = -1000;
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

    // mode terminal
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < masterTableu.length; i++) {
            str += masterTableu[i] + " ";
        }
        return str;
    }

    // mode terminal
    public void print() {
        System.out.println("");
        System.out.print("  ");
        for (int i : top) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(left[0] + " " + "      " + right[0] + "  ");
        System.out.println(left[1] + " " + "      " + right[1] + "  ");
        System.out.println(left[2] + " " + "      " + right[2] + "  ");
        System.out.print("  ");
        for (int i : bottom) {
            System.out.print(i + " ");
        }
        if (posX != -1000 && posY != -1000) {
            System.out.println("  " + "posX: " + posX + " posY: " + posY);
        } else {
            System.out.println("");
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int[] getLeft() {
        return left;
    }

    public int[] getBottom() {
        return bottom;
    }

    public int[] getRight() {
        return right;
    }

    public int[] getTop() {
        return top;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setBottom(int[] bottom) {
        this.bottom = bottom;
    }

    public void setLeft(int[] left) {
        this.left = left;
    }

    public void setRight(int[] right) {
        this.right = right;
    }

    public void setTop(int[] top) {
        this.top = top;
    }

    public boolean getdispoTop() {
        return dispoTop;
    }

    public boolean getdispoBottom() {
        return dispoBottom;
    }

    public boolean getdispoLeft() {
        return dispoLeft;
    }

    public boolean getdispoRight() {
        return dispoRight;
    }

    public void setdispoTop(boolean dispo) {
        dispoTop = dispo;
    }

    public void setdispoBottom(boolean dispo) {
        dispoBottom = dispo;
    }

    public void setdispoLeft(boolean dispo) {
        dispoLeft = dispo;
    }

    public void setdispoRight(boolean dispo) {
        dispoRight = dispo;
    }
}
