package Interfaces;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import view.Dominos.DominoTuile;

public interface Draggable {
    public boolean isDraggable = true;

    public default void makeUnDraggable(JPanel panel) {
        if (panel.getMouseListeners().length > 0)
            panel.removeMouseListener(panel.getMouseListeners()[0]);
        if (panel.getMouseMotionListeners().length > 0)
            panel.removeMouseMotionListener(panel.getMouseMotionListeners()[0]);

    };

    default void makeDraggable(DominoTuile panel) {
        final Point initialClick = new Point();

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick.setLocation(e.getPoint());
                panel.getComponentAt(initialClick);
            }

            public void mouseReleased(MouseEvent e) {
                if (panel.getController().peutEtreDeposer(panel.getDominoTuileModel(),
                        (int) panel.getLocation().getX(), (int) panel.getLocation().getY())) {

                    panel.getController().deposer(panel,
                            panel.getController().currentJoueur(),
                            (int) panel.getLocation().getX(), (int) panel.getLocation().getY());
                    panel.getController().nextPlayer();
                }

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
