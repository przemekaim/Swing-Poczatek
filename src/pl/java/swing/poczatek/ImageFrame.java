package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class ImageFrame extends JFrame {
    private Image icon;

    public ImageFrame() throws HeadlessException {
        add(new ImageComponent());
        pack();
        setLocationRelativeTo(null);
        icon = new ImageIcon("icon.gif").getImage();
        setIconImage(icon);

    }

    private static class ImageComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 600;
        private static final int DEFAULT_HEIGHT = 400;
        private final Image image;


        public ImageComponent() {
            image = new ImageIcon("blue-ball.gif").getImage();
        }

        @Override
        public void paintComponent(Graphics g) {
            // Jezeli nie ma obrazka
            if (image == null)
                return;

            int imageWidth = image.getWidth(this);
            int imageHeigth = image.getHeight(this);

            g.drawImage(image, 0, 0, null);


            // Wypelnianie okna

            for (int i = 0; i * imageWidth <= getWidth(); i++)
                for (int j = 0; j * imageHeigth <= getHeight(); j++)
                    if (i + j > 0)
                        g.copyArea(5, 5, imageWidth, imageHeigth, i * imageWidth, j * imageHeigth);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
