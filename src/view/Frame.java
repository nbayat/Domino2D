package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;


public class Frame extends JFrame{
    public Frame(Controller controller) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              setTitle("Le Projet 33 - BAYAT Nima");
              setDefaultCloseOperation(EXIT_ON_CLOSE);
              setPreferredSize(new Dimension(1000, 800));
              setBackground(Color.BLACK);
              addPanel(new Menu());
              pack();
              setLocationRelativeTo(null);
              setVisible(true);
            }
        });
    }


    void removePanel() {
        this.getContentPane().removeAll();
    }

    void addPanel(JPanel panel) {
        this.getContentPane().add(panel);
        refresh();
    }

    void refresh() {
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    void setPanel(JPanel panel) {
        removePanel();
        addPanel(panel);
    }

    void setPanelToMenu() {
        setPanel(new Menu());
    }
}