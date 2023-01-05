package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import controller.Controller;
import view.Dominos.Dominos;

import java.awt.*;
import javax.swing.*;

import java.io.IOException;

public class Frame extends JFrame {
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private Controller controller;

    public Frame(Controller controller) {
        this.controller = controller;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Le Projet 33 - BAYAT Nima");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setPreferredSize(screenSize);
                // setResizable(false);
                setLocationRelativeTo(null);
                setPanel(new Menu(controller));
                pack();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        });
    }

    public void removePanel() {
        this.getContentPane().removeAll();
    }

    public void addPanel(JPanel panel) {
        this.getContentPane().add(panel);
        refresh();
    }

    public void refresh() {
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }

    public void setPanel(JPanel panel) {
        removePanel();
        addPanel(panel);
    }

    public void setPanelToMenu() {
        setPanel(new Menu(controller));
    }

}