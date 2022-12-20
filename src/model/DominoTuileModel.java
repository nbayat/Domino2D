package model;

public class DominoTuileModel {
    private int[] masterTableu = new int[12];

    public DominoTuileModel() {
        randomize();
    }

    public void randomize() {
        for (int i = 0; i < 12; i++) {
            masterTableu[i] = (int) (Math.random() * 10);
        }
    }

    public int[] getMasterTableu() {
        return masterTableu;
    }

}
