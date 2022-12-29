package view;

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

        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.yellow);
        panel.setPreferredSize(new Dimension(2000, 2000));

        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(screenSize.width * 5 / 6, screenSize.height * 95 / 100));
        scrollPane.setMinimumSize(new Dimension(800, 800));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(16);

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(null);

        this.add(scrollPane);
    }

    // set the view of scrol pane to the center of the panel
    public void setViewCenter() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JViewport viewport = scrollPane.getViewport();
                Rectangle viewRect = viewport.getViewRect();
                Dimension viewSize = viewport.getViewSize();
                int x = (viewSize.width - viewRect.width) / 2;
                int y = (viewSize.height - viewRect.height) / 2;
                viewport.setViewPosition(new Point(x, y));
            }
        });
    }

    // set the view of scrol pane to given x and y
    public void setViewPosition(int x, int y) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JViewport viewport = scrollPane.getViewport();
                viewport.setViewPosition(new Point(x, y));
            }
        });
    }

    // get the position of center of the scroll pane
    public Point getViewCenter() {
        JViewport viewport = scrollPane.getViewport();
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        int x = (viewSize.width - viewRect.width) / 2;
        int y = (viewSize.height - viewRect.height) / 2;
        return new Point(x, y);
    }

    // set the given jpanel at given position in the scroll pane withou resizing
    public void setPanel(JPanel panel, int x, int y) {
        Insets insets = this.panel.getInsets();
        panel.setBackground(null);
        panel.setBounds(25 + insets.left, 5 + insets.top, (int) panel.getPreferredSize().getWidth(),
                (int) panel.getPreferredSize().getHeight());
        this.panel.add(panel, null);
        // refresh the panel
        this.panel.revalidate();
        this.panel.repaint();

    }

    // make the scroll pane to scroll by grab the mouse and move it
    public void setScrollByMouseGrab() {
        scrollPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                scrollPane.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                scrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        scrollPane.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JViewport viewport = scrollPane.getViewport();
                Point p = viewport.getViewPosition();
                int dx = e.getX() - p.x;
                int dy = e.getY() - p.y;
                Rectangle viewRect = viewport.getViewRect();
                p.translate(dx, dy);
                viewport.setViewPosition(p);
                scrollPane.repaint();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}