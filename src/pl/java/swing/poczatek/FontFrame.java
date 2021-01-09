package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FontFrame extends JFrame {
    public FontFrame() {
        //add(new FontComponent());
        add(new FontComponentCenter());
        pack();
        setLocationRelativeTo(null);
    }

    private static class FontComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 600;
        private static final int DEFAULT_HEIGHT = 400;


        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            String message = "Hello World";

            Font font = new Font("Yu Mincho", Font.ITALIC, 15);
            g2.setFont(font);
            g2.drawString(message, 100, 100);

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

    private static class FontComponentCenter extends JComponent {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;

        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            String message = "Witaj swiecie";

            // Ustawienie czcionki
            Font font = new Font("Serif", Font.BOLD+Font.ITALIC, 36);
            g2.setFont(font);

            // Sprawdzenie rozmiaru tekstu
            FontRenderContext context = g2.getFontRenderContext();
            Rectangle2D bounds = font.getStringBounds(message, context);

            // set(x, y) = lewy gorny rog
            double x = (getWidth() - bounds.getWidth()) / 2;
            double y = (getHeight() - bounds.getHeight()) / 2;

            // Dodanie wydluzenia gornego do y w celu siegniecia do linii bazowej

            double ascent = -bounds.getY();
            double baseY = y + ascent;

            // Rysowanie komunikatu
            g2.setPaint(Color.PINK);
            g2.drawString(message, (int) x, (int) baseY);

            g2.setPaint(Color.LIGHT_GRAY);

            // Rysowanie linii bazowej

            g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

            // Rysowanie otaczajacego teskt prostokat
            Rectangle2D rectangle2D = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
            g2.draw(rectangle2D);

        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
