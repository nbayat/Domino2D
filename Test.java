import javax.swing.*;

import model.DominoTuileModel;
import view.JeuComponet.DominoTuile;
import view.JeuComponet.TuileInterface;

import java.awt.*;

public class Test extends JPanel implements TuileInterface {

    private DominoTuileModel model;

    public Test() {
        JPanel centerPanel = new JPanel(new GridLayout(4, 5));
        centerPanel.setBackground(Color.red);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        for (int i = 0; i < 20; i++) {
            centerPanel.add(new JLabel("" + (1)));
        }
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Padded Panel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Test());
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void init() {
    }

    @Override
    public void rotate90() {
        // TODO Auto-generated method stub

    }

    @Override
    public void rotate180() {
        // TODO Auto-generated method stub

    }

    @Override
    public void rotate270() {
        // TODO Auto-generated method stub

    }
}
