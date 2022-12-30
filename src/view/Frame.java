package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import controller.Controller;
import view.Panels.Background;
import view.Panels.Dominos;

import java.awt.*;
import javax.swing.*;

import java.io.IOException;

public class Frame extends JFrame {
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Frame(Controller controller) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Le Projet 33 - BAYAT Nima");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                try {
                    setContentPane(new Background());
                } catch (IOException e) {
                }
                setPreferredSize(screenSize);
                // setResizable(false);
                setLocationRelativeTo(null);
                // addPanel(new Menu());
                add(new Dominos());
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