package model;

import java.util.ArrayList;

import controller.DominoController;

public class DominoModel extends Model {
    private ArrayList<DominoTuileModel> tuiles;
    private ArrayList<DominoTuileModel> panelDeJeu = new ArrayList<DominoTuileModel>();

    public DominoModel(DominoController controller) {
        super(controller);
        this.tuiles = new ArrayList<DominoTuileModel>();
        initTuile();
    }

    public ArrayList<DominoTuileModel> getTuiles() {
        return tuiles;
    }

    private void initTuile() {
        for (int i = 0; i < 28; i++) {
            this.tuiles.add(new DominoTuileModel());
        }
    }

    public ArrayList<DominoTuileModel> getPanelDeJeu() {
        return panelDeJeu;
    }
}
