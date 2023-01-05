import controller.DominoController;

public class Terminal extends DominoController {
    /*
     * public void printCurrentPlayer() {
     * System.out.println(currentJoueur().getNom());
     * }
     * 
     * public void printALLPlayers() {
     * for (int i = 0; i < model.getJoueurs().size(); i++) {
     * System.out.println("Joueur " + i + " -> " +
     * model.getJoueurs().get(i).getNom());
     * }
     * }
     * 
     * public void printALLTuiles() {
     * for (DominoTuileModel tuile : model.getTuiles()) {
     * tuile.print();
     * }
     * }
     * 
     * public void printPanelDeJeu() {
     * for (DominoTuileModel tuile : model.getPanelDeJeu()) {
     * tuile.print();
     * }
     * }
     * 
     * public void commencerJeuTerminal(Scanner scanner) {
     * while (this.model.getTuiles().size() > 0) {
     * System.out.println("OK");
     * for (Joueur j : this.model.getJoueurs()) {
     * System.out.println(j);
     * }
     * for (int i = 0; i < this.model.getJoueurs().size(); i++) {
     * Joueur j = this.model.getJoueurs().get(i);
     * if (j.estSonTour()) {
     * System.out.println("OK1");
     * if (j.estHumain() == true && i > 200) { // test
     * // use scanner to get input
     * System.out.println("Veuillez saisir la position X");
     * int positionX = scanner.nextInt();
     * System.out.println("Veuillez saisir la position Y");
     * int positionY = scanner.nextInt();
     * DominoTuileModel tuile = this.pivocher();
     * if (this.peutEtreDeposer(tuile, positionX, positionY)) {
     * this.deposer(tuile, j, positionX, positionY);
     * j.setScore(j.getScore() + this.calculerScore(tuile, positionX, positionY));
     * 
     * } else {
     * System.out.println("Vous ne pouvez pas déposer cette tuile, Detruire !!");
     * }
     * this.model.setNextPlayer();
     * this.printPanelDeJeu();
     * break;
     * } else {
     * DominoTuileModel tuile = this.pivocher();
     * for (DominoTuileModel t : this.model.getPanelDeJeu()) {
     * if (this.peutEtreDeposer(tuile, t.getPosX(), t.getPosY() + 1)) {
     * this.deposer(tuile, j, t.getPosX(), t.getPosY() + 1);
     * j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX(), t.getPosY()
     * + 1));
     * break;
     * }
     * if (this.peutEtreDeposer(tuile, t.getPosX(), t.getPosY() - 1)) {
     * this.deposer(tuile, j, t.getPosX(), t.getPosY() - 1);
     * j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX(), t.getPosY()
     * - 1));
     * break;
     * }
     * if (this.peutEtreDeposer(tuile, t.getPosX() + 1, t.getPosY())) {
     * this.deposer(tuile, j, t.getPosX() + 1, t.getPosY());
     * j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX() + 1,
     * t.getPosY()));
     * break;
     * }
     * if (this.peutEtreDeposer(tuile, t.getPosX() - 1, t.getPosY())) {
     * this.deposer(tuile, j, t.getPosX() - 1, t.getPosY());
     * j.setScore(j.getScore() + this.calculerScore(tuile, t.getPosX() - 1,
     * t.getPosY()));
     * break;
     * }
     * }
     * this.model.setNextPlayer();
     * this.printPanelDeJeu();
     * break;
     * }
     * }
     * }
     * }
     * }
     * 
     * @Override
     * public int calculerScore(DominoTuileModel tuile, int positionX, int
     * positionY) {
     * int tmp = 0;
     * for (int i = 0; i < model.getPanelDeJeu().size(); i++) {
     * if (model.getPanelDeJeu().get(i) != null) {
     * if (positionX == model.getPanelDeJeu().get(i).getPosX()
     * && positionY == model.getPanelDeJeu().get(i).getPosY() + 1) {
     * if (Arrays.equals(tuile.getBottom(), model.getPanelDeJeu().get(i).getTop()))
     * {
     * tmp = tmp + tuile.getBottom()[0] + tuile.getBottom()[1] +
     * tuile.getBottom()[2];
     * }
     * }
     * if (positionX == model.getPanelDeJeu().get(i).getPosX()
     * && positionY == model.getPanelDeJeu().get(i).getPosY() - 1) {
     * if (Arrays.equals(tuile.getTop(), model.getPanelDeJeu().get(i).getBottom()))
     * {
     * tmp = tmp + tuile.getTop()[0] + tuile.getTop()[1] + tuile.getTop()[2];
     * 
     * }
     * }
     * if (positionX == model.getPanelDeJeu().get(i).getPosX() + 1
     * && positionY == model.getPanelDeJeu().get(i).getPosY()) {
     * if (Arrays.equals(tuile.getLeft(), model.getPanelDeJeu().get(i).getRight()))
     * {
     * tmp = tmp + tuile.getLeft()[0] + tuile.getLeft()[1] + tuile.getLeft()[2];
     * }
     * }
     * if (positionX == model.getPanelDeJeu().get(i).getPosX() - 1
     * && positionY == model.getPanelDeJeu().get(i).getPosY()) {
     * if (Arrays.equals(tuile.getRight(), model.getPanelDeJeu().get(i).getLeft()))
     * {
     * tmp = tmp + tuile.getRight()[0] + tuile.getRight()[1] + tuile.getRight()[2];
     * }
     * }
     * }
     * }
     * return tmp;
     * }
     * 
     * @Override
     * public boolean positionEstDisponible(int positionX, int positionY) {
     * for (int i = 0; i < model.getPanelDeJeu().size(); i++) {
     * if (model.getPanelDeJeu().get(i) != null) {
     * if (positionX == model.getPanelDeJeu().get(i).getPosX()
     * && positionY == model.getPanelDeJeu().get(i).getPosY()) {
     * return false;
     * }
     * }
     * }
     * return true;
     * }
     * 
     * @Override
     * public boolean peutEtreDeposer(DominoTuileModel tuile, int positionX, int
     * positionY) {
     * if (!positionEstDisponible(positionX, positionY))
     * return false;
     * boolean tmp = false;
     * for (int i = 0; i < model.getPanelDeJeu().size(); i++) {
     * if (model.getPanelDeJeu().get(i) != null) {
     * if (positionX == model.getPanelDeJeu().get(i).getPosX()
     * && positionY == model.getPanelDeJeu().get(i).getPosY() + 1) {
     * if (Arrays.equals(tuile.getBottom(), model.getPanelDeJeu().get(i).getTop()))
     * {
     * tmp = true;
     * } else {
     * return false;
     * }
     * }
     * if (positionX == model.getPanelDeJeu().get(i).getPosX()
     * && positionY == model.getPanelDeJeu().get(i).getPosY() - 1) {
     * if (Arrays.equals(tuile.getTop(), model.getPanelDeJeu().get(i).getBottom()))
     * {
     * tmp = true;
     * } else {
     * return false;
     * }
     * }
     * if (positionX == model.getPanelDeJeu().get(i).getPosX() + 1
     * && positionY == model.getPanelDeJeu().get(i).getPosY()) {
     * if (Arrays.equals(tuile.getLeft(), model.getPanelDeJeu().get(i).getRight()))
     * {
     * tmp = true;
     * } else {
     * return false;
     * }
     * }
     * if (positionX == model.getPanelDeJeu().get(i).getPosX() - 1
     * && positionY == model.getPanelDeJeu().get(i).getPosY()) {
     * if (Arrays.equals(tuile.getRight(), model.getPanelDeJeu().get(i).getLeft()))
     * {
     * tmp = true;
     * } else {
     * return false;
     * }
     * }
     * }
     * }
     * return tmp;
     * }
     */
}
