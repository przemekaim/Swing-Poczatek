package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // Zdobywa informacje na temat dostepnym czcionek
        String[] fontNames = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();

        for (String fontName : fontNames) {
            System.out.println(fontName);
        }
        System.out.println("Dostepnych jest " + fontNames.length + " czcionek.");


        // -------------------
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            //frame.setUndecorated(true); // Musi byc przed wywolaniem ramki
            frame.setTitle("Ramka");
            frame.setVisible(true);
            //frame.setLocationRelativeTo(null); // Wycentrowanie okna
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        });

    }
}

