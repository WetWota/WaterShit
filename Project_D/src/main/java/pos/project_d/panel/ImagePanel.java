package pos.project_d.panel;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel() {
        // ✅ Load the image safely inside paintComponent
        try {
            image = new ImageIcon(getClass().getResource("/Logo.png")).getImage();
        } catch (Exception e) {
            System.err.println("❌ Image not found: /Logo.png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.RED);
            g.drawString("Image Not Found!", 10, 20); // Show text instead
        }
    }
}
