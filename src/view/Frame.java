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
              JFrame frame = new JFrame("Le Projet 33");
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setPreferredSize(new Dimension(1000, 800));
              frame.setBackground(Color.BLACK);
              frame.add(new Menu());
              frame.pack();
              frame.setLocationRelativeTo(null);
              frame.setVisible(true);
            }
        });
    }


    void removePanel() {
        this.getContentPane().removeAll();
    }

    void addPanel(JPanel panel) {
        this.getContentPane().add(panel);
    }
}