package ru.erorrov;

import javax.swing.*;

public class Main {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            final CalculatorUI window = new CalculatorUI();
            window.setVisible(true);
        });
    }
}
