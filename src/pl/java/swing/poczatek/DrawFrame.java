package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DrawFrame extends JFrame {
    public DrawFrame() {
        add(new DrawComponent());
        pack();
        setLocationRelativeTo(null);
    }

    private static class DrawComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 600;
        private static final int DEFAULT_HEIGHT = 400;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            // Rysowanie prostokata
            double leftX = 100;
            double topY = 100;
            double width = 200;
            double height = 150;

            Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
            g2.draw(rect);

            // Rysowanie elipsy
            Ellipse2D ellipse = new Ellipse2D.Double();
            ellipse.setFrame(rect);
            g2.draw(ellipse);

            // Rysowanie przekatnej
            g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

            // Rysowanie kola
            Ellipse2D circle = new Ellipse2D.Double();
            double centerX = rect.getCenterX();
            double centerY = rect.getCenterY();
            double radius = 150;

            circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
            g2.draw(circle);


            // Rysowanie linii z kropek
/*            for (int i = 0; i < DEFAULT_WIDTH; i++) {
                if (i % 2 == 0) {
                    g2.drawLine(i, i, i, i);
                }
            }*/

            // Rysowanie kropek co 5 pikseli
            for (int i = 0; i < DEFAULT_WIDTH; i++) {
                for (int j = 0; j < DEFAULT_HEIGHT; j++) {
                    if (i % 5 == 0)
                        if (j % 5 == 0)
                            g2.drawLine(i, j, i, j);
                }
            }

        }


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
