package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.OverlayLayout;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JeuMainPanel extends JPanel {

    private JPanel panel;
    JScrollPane scrollPane;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public JeuMainPanel() {
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        this.add(panel);
    }

    public JPanel getPanel() {
        return panel;
    }
}