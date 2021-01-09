package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    public SimpleFrame() {
        pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
