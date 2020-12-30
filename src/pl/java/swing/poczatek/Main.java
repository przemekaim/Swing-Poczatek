package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // SimpleFrame
        // watek dystrybucji zdarzen -> na razie zagadka (Rozdzial 14)
        /*
        EventQueue.invokeLater(() -> {
            SimpleFrame frame = new SimpleFrame(); // Klasa dziedziczaca po JFrame rozni sie tylko wymiarami okna
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Zakoczenenie programu na zamkniecie ramki

            frame.setVisible(true); // Ustawiamy widocznosc okna
        });*/

        // SizedFrame

        EventQueue.invokeLater(() -> {
            JFrame frame = new SizedFrame();
            frame.setTitle("JAVA TEST");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

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


class SizedFrame extends JFrame {
    public SizedFrame() {
        // Sprawdzenie wymiarow ekranu

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // Ustawienie szerokosci i wysokosci ramki oraz polecenie systemowi by ustalil jej polozenie
        setSize(screenWidth/2, screenHeight/2);
        setLocationByPlatform(true);

        // Ustawienie ikony
        Image img = new ImageIcon("icon.gif").getImage();
        //Image img = new ImageIcon("kaguya.jpg").getImage();
        setIconImage(img);

    }
}
