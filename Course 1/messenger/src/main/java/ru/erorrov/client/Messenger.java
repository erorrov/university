package ru.erorrov.client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

public class Messenger extends JFrame {

    JPanel dialogsPanel = new JPanel();
    JPanel chatPanel = new JPanel();

    private final DefaultListModel listModel = new DefaultListModel();
    private final JList list = new JList(listModel);

    final private JMenuBar menuBar = new JMenuBar();

    Messenger() {
        super("Messenger");
        setLayout(new BorderLayout());
        this.setBounds(300, 100, 850, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setMinimumSize(new Dimension(700, 400));

        buildWindow();
        buildMenu();
        loadContacts();
    }

    private void buildWindow() {
        //Menu
        setJMenuBar(menuBar);

        //Dialogs
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(evt -> loadChat(evt));

        dialogsPanel.setLayout(new BorderLayout());
        Dimension d = list.getPreferredSize();
        d.width = 250;
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(d);
        dialogsPanel.add(scrollPane, BorderLayout.WEST);
        chatPanel.add(new JLabel("<html><center><br><br><br><b>Select a chat to start messaging</b><br>or you can search new contacts</center></html>"), BorderLayout.CENTER);
        //chatPanel.add(new JLabel("1"), BorderLayout.CENTER);
        //chatPanel.add(new JTextArea(), BorderLayout.CENTER);
        //dialogsPanel.add(new JTextArea(), BorderLayout.CENTER);
        //dialogsPanel.add(new JButton(), BorderLayout.CENTER);
        getContentPane().add(dialogsPanel);
        setLocationRelativeTo(null);
    }

    private void buildMenu() {
        final JMenu mMe = new JMenu("Me");
        menuBar.add(mMe);
        final JMenuItem mEditProfile = new JMenuItem("Edit Profile");
        mMe.add(mEditProfile);
        mEditProfile.addActionListener(evt -> menuListener(evt));
        final JMenuItem mLogout = new JMenuItem("Logout");
        mMe.add(mLogout);
        mLogout.addActionListener(evt -> menuListener(evt));

        final JMenu mContacts = new JMenu("Contacts");
        menuBar.add(mContacts);
        final JMenuItem cSearch = new JMenuItem("Search by username");
        mContacts.add(cSearch);
        cSearch.addActionListener(evt -> menuListener(evt));

        final JMenu mSettings = new JMenu("Settings");
        menuBar.add(mSettings);

        final JMenu mHelp = new JMenu("Help");
        menuBar.add(mHelp);
        final JMenuItem hAbout = new JMenuItem("About");
        mHelp.add(hAbout);
        hAbout.addActionListener(evt -> menuListener(evt));
    }

    private void menuListener(ActionEvent evt) {
        String action = evt.getActionCommand();
        System.out.println(action);
    }

    private void loadChat(ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) {
            JList list = (JList) evt.getSource();

            System.out.println("Selected: "+list.getSelectedIndices()[0]);
        }
    }

    private void closeChat() {

    }

    private void loadContacts() {
        String imageurl, username, message;
        String imgsize = "50";
        for (int i = 0; i < 15; i++) {
            imageurl = "https://static-cdn.jtvnw.net/user-default-pictures/0ecbb6c3-fecb-4016-8115-aa467b7c36ed-profile_image-70x70.jpg";
            username = "Oleg Olegov";
            message = "simple text simple text simple text simple text simple text simple text";

            if(message.length() > 30) {
                message = message.substring(0, 30);
                message += "...";
            }

            listModel.addElement("<html>\n" +
                    "<table style=\"width:100%\">\n" +
                    "    <td><img height=\"" + imgsize + "\" width=\"" + imgsize + "\" src=\"" + imageurl + "\"></td>" +
                    "    <td><b style=\"max-width:5;\">" + username + "</b><br>" + message + "</td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "</html>");
        }
    }

}
