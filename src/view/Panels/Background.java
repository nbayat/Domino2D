package view.Panels;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;

public class Background extends JPanel {

    private Image backgroundImage;
    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public Background() throws IOException {
        this.backgroundImage = ImageIO.read(new File("assets/1.png"));
        // resize the background image
        backgroundImage = backgroundImage.getScaledInstance(screenSize.width, screenSize.height,
                Image.SCALE_SMOOTH);
        Dimension size = new Dimension(screenSize);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(new BorderLayout());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}