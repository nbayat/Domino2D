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
import java.awt.event.MouseWheelEvent;

public class JeuMainPanel extends JPanel {

    private JPanel panel;
    JScrollPane scrollPane;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public JeuMainPanel() {

        JPanel panel1 = new JPanel();

        panel1.setLayout(null);
        panel1.setBackground(Color.white);
        panel1.setPreferredSize(new Dimension(2000, 2000));
        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        Insets insets = panel1.getInsets();
        panel.setBounds(25 + insets.left, 5 + insets.top, 300, 125);
        panel.setPreferredSize(new Dimension(100, 100));
        panel1.add(panel, null);

        scrollPane = new JScrollPane(panel1);
        scrollPane.setPreferredSize(new Dimension(screenSize.width * 5 / 6, screenSize.height * 95 / 100));
        scrollPane.setMinimumSize(new Dimension(800, 800));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(null);

        this.add(scrollPane);
    }

    public JPanel getPanel() {
        return panel;
    }
}