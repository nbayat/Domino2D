package controller;

import view.Frame;

public class Main {
    public static void main(String[] args) {
        try {
            new Frame();
        } catch (Exception e) {
            System.out.println("echec de l'initialisation de l'application!");
        }
    }
}
