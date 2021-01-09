package pl.java.swing.poczatek;

import javax.swing.*;
import java.awt.*;

public class SizedFrame extends JFrame {
    public SizedFrame() throws HeadlessException {

        // Sprawdzenie wymiarow okna
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);

        // Ustawienie ikony
        Image image = new ImageIcon("icon.gif").getImage();
        setIconImage(image);
    }
}
