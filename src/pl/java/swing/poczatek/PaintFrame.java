package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class PaintFrame extends JFrame {
    public PaintFrame() {
        add(new PaintComponent());
        pack();
        setLocationRelativeTo(null);
    }


    private static class PaintComponent extends JComponent{
        private static final int DEFAULT_WIDTH = 600;
        private static final int DEFAULT_HEIGHT = 400;


        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.PINK);
            g.drawString("Kolorowy tekst", 100 ,100);

            Color color = new Color(125,125,125);
            g2.setColor(color);
            g.drawString("INNY KOLOR", 100, 125);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
