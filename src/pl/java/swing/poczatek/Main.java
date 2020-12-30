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

/*        EventQueue.invokeLater(() -> {
            JFrame frame = new SizedFrame();
            frame.setTitle("JAVA TEST");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        });*/

        // NOT HELLO WORLD PROGRAM

        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NOT HELLO WORLD");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        // Ustawienie ikony
        Image img = new ImageIcon("icon.gif").getImage();
        //Image img = new ImageIcon("kaguya.jpg").getImage();
        setIconImage(img);

    }
}

// Ramka zawierajaca okienko z komunikatem
class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        //setLocationByPlatform(true);
        pack(); // Chyba lepiej uzywac niz setSize() -> uzywa getPreferredSize chyba
        setLocationByPlatform(true);

        // Ustawiam ikone
        Image img = new ImageIcon("icon.gif").getImage();
        setIconImage(img);
    }
}

// Komponent wyswietaljacy komunikat.
class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    // Wymiary ramki, nie skorzystalem z nich jak w oryginalnym przykladzie
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    // Rysowanie Stringa
    public void paintComponent(Graphics g) {
        g.drawString("Not Hello WRyorld program.", MESSAGE_X, MESSAGE_Y);
    }

    // Wymiary ramki
    public Dimension getPreferredSize() {
        // Uzywam toolkita jak poprzednio do pobrania informacji o rozmioaru ekranu
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Zwracam rozmiary ramki dzielone na 2
        return new Dimension(screenWidth/2,screenHeight/2);
    }
}