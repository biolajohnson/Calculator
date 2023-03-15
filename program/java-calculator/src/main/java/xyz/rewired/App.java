package xyz.rewired;

import xyz.rewired.display.CalculatorBox;
import java.awt.*;
import java.net.URL;

public class App {
    public static void main(String[] args) {
        // loading an image from a file
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final URL imageResource = App.class.getClassLoader().getResource("xyz/rewired/resources/icon.png");
        final Image image = defaultToolkit.getImage(imageResource);

        // this is new since JDK 9
        final Taskbar taskbar = Taskbar.getTaskbar();

        try {
            // set icon for mac os (and other systems which do support this method)
            taskbar.setIconImage(image);
        } catch (final UnsupportedOperationException e) {
            System.out.println("The os does not support: 'taskbar.setIconImage'");
        } catch (final SecurityException e) {
            System.out.println("There was a security exception for: 'taskbar.setIconImage'");
        }
        new CalculatorBox();
    }
}
