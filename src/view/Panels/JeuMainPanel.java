package view.Panels;

import java.awt.*;

import javax.swing.*;

import view.Dominos.DominoTuile;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JeuMainPanel extends JPanel {

    private JPanel panel;
    JScrollPane scrollPane;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public JeuMainPanel() {

        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.white);
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
        JViewport viewport = scrollPane.getViewport();
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        int x = (viewSize.width - viewRect.width) / 2;
        int y = (viewSize.height - viewRect.height) / 2;
        viewport.setViewPosition(new Point(x / 2, y / 2));
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
    public void addTuile(DominoTuile tuile, int x, int y) {
        Insets insets = this.panel.getInsets();
        tuile.setBackground(null);
        tuile.getDominoTuileModel().setPosX(x);
        tuile.getDominoTuileModel().setPosY(y);
        tuile.setBounds(x + insets.left, y + insets.top, (int) tuile.getPreferredSize().getWidth(),
                (int) tuile.getPreferredSize().getHeight());
        this.panel.add(tuile, null);
        // refresh the panel
        this.panel.revalidate();
        this.panel.repaint();

    }

    public DominoTuile getLastTuile() {
        return (DominoTuile) this.panel.getComponent(this.panel.getComponentCount() - 1);
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
                // Rectangle viewRect = viewport.getViewRect();
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