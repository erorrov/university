package ru.erorrov;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(final String[] args) throws IOException, URISyntaxException {
        final Editor mainWindow = new Editor();
        mainWindow.setVisible(true);
    }
}
