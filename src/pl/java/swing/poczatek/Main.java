package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // watek dystrybucji zdarzen -> na razie zagadka (Rozdzial 14)
        EventQueue.invokeLater(() -> {
            SimpleFrame frame = new SimpleFrame(); // Klasa dziedziczaca po JFrame rozni sie tylko wymiarami okna
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zakoczenenie programu na zamkniecie ramki
            frame.setVisible(true); // Ustawiamy widocznosc okna
        });
    }

}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); // Ustawienie rozmiaru okna
    }
}
