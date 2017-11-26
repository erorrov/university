package ru.erorrov.client;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Messenger().setVisible(true);
        });
    }
}
