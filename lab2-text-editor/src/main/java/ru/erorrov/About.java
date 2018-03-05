package ru.erorrov;

import javax.swing.*;
import java.awt.*;

public class About extends JDialog{

    public About (JFrame parent) {
        super(parent, "About");
        setSize(200, 130);

        this.setLocation(450, 300);
        this.setResizable(false);

        JPanel messagePane = new JPanel();
        messagePane.add(new JLabel("<html><center>" +
                "<h3>Text editor<br><small>v1.0</small></h3>" +
                "erorrov.ru" +
                "<center></html>"));
        getContentPane().add(messagePane);

        JPanel buttonPane = new JPanel();
        JButton button = new JButton("OK");
        buttonPane.add(button);
        button.addActionListener(evt -> setVisible(false));

        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

}
