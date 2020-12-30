package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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

/*
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NOT HELLO WORLD");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
*/

/*        EventQueue.invokeLater(() -> {
            JFrame frame = new DrawFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("JAVA FIGURY");
        });*/


        // Drukowanie wszystkich dostepnych czcionek w systenie
        String[] fontNames = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
        System.out.println("Dostepnych jest " + fontNames.length + " czcionek.");

        // Czcionka, wysrodkowanie tekstu
        EventQueue.invokeLater(() ->{
            JFrame frame = new FontFrame();
            frame.setTitle("Test czcionek");
            frame.setVisible(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        });
    }
}

// --------------------------------------------------------------------------------- //
class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); // Ustawienie rozmiaru okna
    }
}

// --------------------------------------------------------------------------------- //
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


// --------------------------------------------------------------------------------- //
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
        return new Dimension(screenWidth / 2, screenHeight / 2);
    }
}


// --------------------------------------------------------------------------------- //
// RYSOWANIE FIGUR

class DrawFrame extends JFrame {
    public DrawFrame() {
        add(new DrawComponent());
        setLocationByPlatform(true);
        pack();

        Image image = new ImageIcon("icon.gif").getImage();
        setIconImage(image);
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Rysowanie prostokata
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rectangle2D = new Rectangle2D.Double(leftX, topY, width, height);
        //g2.draw(rectangle2D);
        g2.setPaint(Color.RED);
        g2.fill(rectangle2D);

        // Rysowanie elipsy
        Ellipse2D ellipse2D = new Ellipse2D.Double();
        ellipse2D.setFrame(rectangle2D);
        //g2.draw(ellipse2D);
        g2.setPaint(Color.GREEN);
        g2.fill(ellipse2D);

        // Rysowanie przekatnej
        g2.setPaint(Color.YELLOW);
        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));

        // Rysowanie kola z takim samym srodkiem
        //Point2D point2D = new Point2D.Double(rectangle2D.getCenterX(), rectangle2D.getCenterY());
        g2.setPaint(Color.BLACK);
        double centerX = rectangle2D.getCenterX();
        double centerY = rectangle2D.getCenterY();
        double radius = 150;
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        //g2.setPaint(Color.BLUE);
        //g2.fill(circle);
        g2.draw(circle);


        // Rysowanie punktow co 2 za pomoca drawLine
        for (int i = 0; i < 400; i++) {
            if (i % 2 == 0) {
                g2.drawLine(i, i, i, i);
            }
        }

        g2.drawString("Tu jest srodek", DEFAULT_HEIGHT / 2, DEFAULT_WIDTH / 2);

        // Niestandardowy kolor
        g2.setPaint(new Color(0, 128, 128));
        g2.drawString("Niestandardowy kolor", 10, 10);


    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        pack();
        setLocationByPlatform(true);
    }
}

class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        String message = "Zegnaj swiecie";

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