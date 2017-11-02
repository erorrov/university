package ru.erorrov;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


class Editor extends JFrame implements ActionListener, DocumentListener {

    private JMenuBar menuBar = new JMenuBar();
    private JTextArea textArea = new JTextArea();
    private File file;
    public boolean changed = false;

    public Editor() {
        super("Text Editor");
        this.setBounds(350, 200, 700, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        setPreferredSize(new Dimension(450, 110));
        add(scrollPane, BorderLayout.CENTER);

        buildMenuBar();

        textArea.getDocument().addDocumentListener(this);
    }

    private void buildMenuBar() {
        setJMenuBar(menuBar);

        JMenu mFile = new JMenu("File");
        menuBar.add(mFile);
        JMenuItem fNew = new JMenuItem("New");
        mFile.add(fNew);
        fNew.addActionListener(this);
        JMenuItem fOpen = new JMenuItem("Open");
        mFile.add(fOpen);
        fOpen.addActionListener(this);
        JMenuItem fSave = new JMenuItem("Save");
        mFile.add(fSave);
        fSave.addActionListener(this);

        JMenu mEdit = new JMenu("Edit");
        menuBar.add(mEdit);
        JMenuItem eCopy = new JMenuItem("Copy");
        mEdit.add(eCopy);
        JMenuItem eCut = new JMenuItem("Cut");
        mEdit.add(eCut);
        JMenuItem ePaste = new JMenuItem("Paste");
        mEdit.add(ePaste);
        JMenuItem eSelectAll = new JMenuItem("Select All");
        mEdit.add(eSelectAll);
        eSelectAll.addActionListener(this);

        /*
        JMenu mFind = new JMenu("Find");
        menuBar.add(mFind);
        JMenuItem fFind = new JMenuItem("Find...");
        mFind.add(fFind);
        */

        JMenu mHelp = new JMenu("Help");
        menuBar.add(mHelp);
        JMenuItem hAuthor = new JMenuItem("Author");
        mHelp.add(hAuthor);
        hAuthor.addActionListener(this);
        JMenuItem hSource = new JMenuItem("Source code");
        mHelp.add(hSource);
        hSource.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        //System.out.println("New action: "+ e.toString());
        if (action.equals("Quit")) {
            System.exit(0);
        } else if (action.equals("New")) {
            newFile();
        } else if (action.equals("Open")) {
            loadFile();
        } else if (action.equals("Save")) {
            saveFile();
        } else if (action.equals("Author")) {
            //
        } else if (action.equals("Source code")) {
            //
        } else if (action.equals("Copy")) {
            textArea.copy();
        } else if (action.equals("Cut")) {
            textArea.cut();
        } else if (action.equals("Paste")) {
            textArea.paste();
        } else if (action.equals("Select All")) {
            textArea.selectAll();
        }
    }

    public void newFile() {
        if (changed) {
            int question = JOptionPane.showConfirmDialog(null,
                    "Do you want to save it?", "Save file",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (question == JOptionPane.YES_OPTION) {
                saveFile();
            }
        }

        file = null;
        textArea.setText("");
        setTitle("Text Editor");
    }

    private void loadFile() {
        JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
        dialog.setMultiSelectionEnabled(false);
        try {
            if (dialog.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                file = dialog.getSelectedFile();
                textArea.setText(readFile(file));
                setTitle(file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readFile(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line + "\n");
        }

        return result.toString();
    }

    private void saveFile() {
        if (file == null) {
            //save new file
            JFileChooser dialog = new JFileChooser(System.getProperty("user.home"));
            dialog.setDialogTitle("Save new file as...");
            dialog.showSaveDialog(this);
            file = dialog.getSelectedFile();
        } else {
            //save old file
            setTitle(file.getName() + " (saved)");
        }

        try {
            PrintWriter writer = new PrintWriter(file);
            writer.write(textArea.getText());
            writer.close();
            changed = false;
            setTitle(file.getName() + " (saved)");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void insertUpdate(DocumentEvent e) {
        changed = true;
        if (file != null) {
            setTitle(file.getName() + " (changed)");
        }
    }

    public void removeUpdate(DocumentEvent e) {
        changed = true;
        if (file != null) {
            setTitle(file.getName() + " (changed)");
        }
    }

    public void changedUpdate(DocumentEvent e) {
        changed = true;
        if (file != null) {
            setTitle("Editor - " + file.getName() + " (changed)");
        }
    }
}
