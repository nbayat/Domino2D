package Interfaces;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public interface Draggable {
    public boolean isDraggable = true;

    public default void makeUnDraggable(JPanel panel) {
        panel.removeMouseListener(panel.getMouseListeners()[0]);
        panel.removeMouseMotionListener(panel.getMouseMotionListeners()[0]);

    };

    default void makeDraggable(JPanel panel) {
        final Point initialClick = new Point();

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick.setLocation(e.getPoint());
                panel.getComponentAt(initialClick);
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // get location of Window
                int thisX = panel.getLocation().x;
                int thisY = panel.getLocation().y;

                // Determine how much the mouse moved since the initial click
                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                // Move window to this position
                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                panel.setLocation(X, Y);
            }
        });
    }
}
