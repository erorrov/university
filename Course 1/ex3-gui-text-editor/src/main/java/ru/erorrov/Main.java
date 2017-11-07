package ru.erorrov;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main implements SwingConstants {
    public static void main(final String[] args) throws IOException, URISyntaxException {
        final Editor mainWindow = new Editor();
        mainWindow.setVisible(true);
    }
}
