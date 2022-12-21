package view.JeuComponet;

import javax.swing.*;
import java.awt.*;

import model.DominoTuileModel;
import view.Interfaces.Draggable;

public class DominoTuile extends JPanel implements Draggable {
    private DominoTuileModel dominoTuileModel;

    public DominoTuile() {
        dominoTuileModel = new DominoTuileModel();
        this.add(fillTuile());
        this.makeDraggable(this);
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

    // test this class
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new DominoTuile());

        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}