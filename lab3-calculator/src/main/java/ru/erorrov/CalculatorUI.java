package ru.erorrov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class CalculatorUI extends JFrame {
    private JPanel numPanel = new JPanel();
    private JPanel binPanel = new JPanel();
    private JPanel unarPanel = new JPanel();

    private JTextField display = new JTextField();

    private String queue = "0";

    private static Dimension WINDOW_SIZE = new Dimension(400, 200);
    private static String CLEAN_DISPLAY = "0";

    CalculatorUI() {
        setTitle("Calculator");
        setLayout(new BorderLayout());

        //init display
        display.setText(CLEAN_DISPLAY);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        //init num buttons
        numPanel.setLayout(new GridLayout(4, 3, 2, 2));

        JButton tmpButton;
        for (int i = 1; i <= 10; i++) {
            tmpButton = new JButton(i == 10 ? "0" : Integer.toString(i));
            tmpButton.addActionListener(evt -> addNum(evt.getActionCommand()));
            numPanel.add(tmpButton);
        }

        JButton btnDot  = new JButton(".");
        JButton btnCalc = new JButton("=");

        btnDot.addActionListener(evt -> makeFrac());
        btnCalc.addActionListener(evt -> calculate());

        numPanel.add(btnDot);
        numPanel.add(btnCalc);

        add(numPanel, BorderLayout.CENTER);

        //init bin buttons
        binPanel.setLayout(new GridLayout(4, 1, 2, 2));

        JButton btnDiv   = new JButton("÷");
        JButton btnMul   = new JButton("×");
        JButton btnMinus = new JButton("-");
        JButton btnPlus  = new JButton("+");

        btnDiv.addActionListener(this::simpleOperations);
        btnMul.addActionListener(this::simpleOperations);
        btnMinus.addActionListener(this::simpleOperations);
        btnPlus.addActionListener(this::simpleOperations);

        binPanel.add(btnDiv);
        binPanel.add(btnMul);
        binPanel.add(btnMinus);
        binPanel.add(btnPlus);

        add(binPanel, BorderLayout.EAST);

        //init unar buttons
        unarPanel.setLayout(new GridLayout(4, 2, 2, 2));

        JButton btnInv   = new JButton("+/-");
        JButton btnSin   = new JButton("sin()");
        JButton btnCos   = new JButton("cos()");
        JButton btnTg    = new JButton("tg()");
        JButton btnCtg   = new JButton("ctg()");
        JButton btnLn    = new JButton("ln()");
        JButton btnSqr   = new JButton("<html>x<sup>2</sup></html>");
        JButton btnClear = new JButton("CLEAR");

        btnInv.addActionListener(evt -> inversion());
        btnSin.addActionListener(this::calcFunc);
        btnCos.addActionListener(this::calcFunc);
        btnTg.addActionListener(this::calcFunc);
        btnCtg.addActionListener(this::calcFunc);
        btnLn.addActionListener(this::calcFunc);
        btnSqr.addActionListener(this::calcFunc);
        btnClear.addActionListener(evt -> clearDisplay());

        unarPanel.add(btnInv);
        unarPanel.add(btnSin);
        unarPanel.add(btnCos);
        unarPanel.add(btnTg);
        unarPanel.add(btnCtg);
        unarPanel.add(btnLn);
        unarPanel.add(btnSqr);
        unarPanel.add(btnClear);

        add(unarPanel, BorderLayout.WEST);

        //build window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(WINDOW_SIZE);
        setPreferredSize(WINDOW_SIZE);
        setResizable(false);
        pack();
    }

    private String[] getQueue() {
        return queue.split(" ");
    }

    private void addNum(String i) {
        if (queue.equals(CLEAN_DISPLAY) || getQueue().length == 2) {
            display.setText(i);
        } else {
            display.setText(display.getText() + i);
        }

        queue += i;
    }

    private void clearDisplay() {
        queue = CLEAN_DISPLAY;
        display.setText(CLEAN_DISPLAY);
    }

    private void simpleOperations(ActionEvent evt) {
        if (getQueue().length == 2) {
            queue = getQueue()[0];
        } else if (getQueue().length == 3) {
            calculate();
        }

        queue += " "+evt.getActionCommand()+" ";
    }

    private void makeFrac() { //todo check
        if (getQueue().length == 2) { addNum("0"); }

        queue += ".";
        display.setText(display.getText()+".");
    }

    private void inversion() {
        if (getQueue().length < 3) {
            if (queue.substring(0, 1).equals("-")) {
                queue = queue.substring(1, queue.length());
            } else {
                queue = "-"+queue;
            }
            display.setText(getQueue()[0]);
        } else {
            if (getQueue()[2].substring(0, 1).equals("-")) {
                queue = String.join(" ", getQueue());
            } else {
                queue = getQueue()[0]+" "+getQueue()[1]+" -"+getQueue()[2];
            }
            display.setText(getQueue()[2]);
        }
    }

    private void calculate() {
        if (getQueue().length != 3) { return; }

        Double a = Double.parseDouble(getQueue()[0]);
        String act = getQueue()[1];
        Double b = Double.parseDouble(getQueue()[2]);
        Double result;

        switch (act) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "×":
                result = a * b;
                break;
            case "÷":
                result = a / b;
                break;
            default:
                return;
        }

        setResult(result);
    }

    private void calcFunc(ActionEvent evt) {
        if (getQueue().length == 3) { calculate(); }
        if (getQueue().length != 1) { return; }

        Double a = Double.parseDouble(getQueue()[0]);
        String act = evt.getActionCommand();
        Double result;

        switch (act) {
            case "<html>x<sup>2</sup></html>":
                result = a * a;
                break;
            case "sin()":
                result = Math.sin(a);
                break;
            case "cos()":
                result = Math.cos(a);
                break;
            case "tg()":
                result = Math.tan(a);
                break;
            case "ctg()":
                result = 1.0 / Math.tan(a);
                break;
            case "ln()":
                result = Math.log(a);
                break;
            default:
                return;
        }

        setResult(result);
    }

    private void setResult(Double result) {
        String strResult = result.toString();

        if (result % 1 == 0){
            queue = strResult.substring(0, strResult.length()-2);
            display.setText(strResult.substring(0, strResult.length()-2));
        } else {
            queue = strResult;
            display.setText(strResult);
        }
    }
}