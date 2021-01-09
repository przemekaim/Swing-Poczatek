package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() throws HeadlessException {
        add(new NotHelloWorldComponent());
        pack();
        setLocationRelativeTo(null);
    }


    private static class NotHelloWorldComponent extends JComponent {
        private static final int DEFAULT_WIDTH = 600;
        private static final int DEFAULT_HEIGHT = 400;

        private static final int MESSAGE_X = 120;
        private static final int MESSAGE_Y = 80;

        @Override
        public void paintComponent(Graphics g) {
            String message = "Not Hello World Program.";
            g.drawString(message, MESSAGE_X, MESSAGE_Y);

        }


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
