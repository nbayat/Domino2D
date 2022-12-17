package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;


public class Frame {
    public Frame() {
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
}