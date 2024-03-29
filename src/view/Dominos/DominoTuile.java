package view.Dominos;

import javax.swing.*;

import Interfaces.Draggable;
import controller.DominoController;

import java.awt.*;

import model.DominoTuileModel;

public class DominoTuile extends JPanel implements Draggable {
    private DominoTuileModel dominoTuileModel;
    private DominoController controller = null;

    public DominoTuile(DominoTuileModel model, DominoController controller) {
        // dominoTuileModel = new DominoTuileModel();
        this.controller = controller;
        dominoTuileModel = model;
        this.add(fillTuile());
        this.makeDraggable(this);
    }

    public DominoController getController() {
        return controller;
    }

    public DominoTuileModel getDominoTuileModel() {
        return dominoTuileModel;
    }

    public void rotate() {
        this.removeAll();
        this.add(fillTuile());
        this.revalidate();
        this.repaint();
    }

    private JPanel fillTuile() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        int index = 0;
        for (int i = 0; i < 5; i++) {
            JPanel tmp = new JPanel();
            tmp.setBackground(Color.white);
            for (int j = 0; j < 5; j++) {
                switch (j) {
                    case 0:
                        if (i == 0 || i == 4) {
                            JLabel label = new JLabel("#");
                            label.setForeground(new Color(0, 0, 0, 0));
                            tmp.add(label);
                            break;
                        } else {
                            tmp.add(new JLabel(String.valueOf(dominoTuileModel.getMasterTableu()[index])));
                            index++;
                            break;
                        }
                    case 1:
                        if (i == 1 || i == 2 || i == 3) {
                            JLabel label = new JLabel("#");
                            label.setForeground(new Color(0, 0, 0, 0));
                            tmp.add(label);
                            break;
                        } else {
                            tmp.add(new JLabel(String.valueOf(dominoTuileModel.getMasterTableu()[index])));
                            index++;
                            break;
                        }
                    case 2:
                        if (i == 1 || i == 2 || i == 3) {
                            JLabel label = new JLabel("#");
                            label.setForeground(new Color(0, 0, 0, 0));
                            tmp.add(label);
                            break;
                        } else {
                            tmp.add(new JLabel(String.valueOf(dominoTuileModel.getMasterTableu()[index])));
                            index++;
                            break;
                        }
                    case 3:
                        if (i == 1 || i == 2 || i == 3) {
                            JLabel label = new JLabel("#");
                            label.setForeground(new Color(0, 0, 0, 0));
                            tmp.add(label);
                            break;
                        } else {
                            tmp.add(new JLabel(String.valueOf(dominoTuileModel.getMasterTableu()[index])));
                            index++;
                            break;
                        }
                    case 4:
                        if (i == 0 || i == 4) {
                            JLabel label = new JLabel("#");
                            label.setForeground(new Color(0, 0, 0, 0));
                            tmp.add(label);
                            break;
                        } else {
                            tmp.add(new JLabel(String.valueOf(dominoTuileModel.getMasterTableu()[index])));
                            index++;
                            break;
                        }
                    default:
                        break;
                }
            }
            panel.add(tmp);
        }
        return panel;
    }

    public void error() {
        int j = 4;
        while (j > 0) {
            JPanel panel = (JPanel) this.getComponent(0);
            this.removeAll();
            JPanel tmp = new JPanel();
            tmp.setBackground(Color.red);
            tmp.setPreferredSize(panel.getPreferredSize());
            this.add(tmp);
            this.revalidate();
            this.repaint();
            // sleap 2 sec
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.removeAll();
            this.add(panel);
            this.revalidate();
            this.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            j--;
        }
        this.setBounds(this.getX() + 50, this.getY(), this.getWidth(), this.getHeight());
    }

    public void valid() {
        JPanel panel = (JPanel) this.getComponent(0);
        this.removeAll();
        JPanel tmp = new JPanel();
        tmp.setBackground(Color.green);
        tmp.setPreferredSize(panel.getPreferredSize());
        this.add(tmp);
        this.revalidate();
        this.repaint();
        // sleap 2 sec
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.removeAll();
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

}