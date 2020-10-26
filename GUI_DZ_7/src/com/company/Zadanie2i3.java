package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Zadanie2i3 extends JFrame {
    JTextField jTextField;
    List<Operation> operations;
    double result;


    public Zadanie2i3() throws HeadlessException {
        this.result = 0;
        this.operations = new ArrayList<>();
        JPanel mainPanel = new JPanel();
        JPanel inputArea = new JPanel();
        JPanel selectionArea = new JPanel();
        JPanel gridButtonArea = new JPanel();

        mainPanel.setLayout(new BorderLayout());


        inputArea.setLayout(new BorderLayout());
        selectionArea.setLayout(new FlowLayout());
        gridButtonArea.setLayout(new GridLayout(5, 4));

        this.jTextField = new JTextField("");
        jTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputArea.add(jTextField, BorderLayout.PAGE_START);

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton hexadecimalButton = new JRadioButton("szesnastkowy");
        JRadioButton decimalButton = new JRadioButton("dziesiętny");
        JRadioButton binaryButton = new JRadioButton("binarny");

        buttonGroup.add(hexadecimalButton);
        buttonGroup.add(decimalButton);
        buttonGroup.add(binaryButton);


        selectionArea.add(hexadecimalButton);
        selectionArea.add(decimalButton);
        selectionArea.add(binaryButton);

        inputArea.add(selectionArea, BorderLayout.SOUTH);

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(e -> jTextField.setText(jTextField.getText() + zeroButton.getText()));
        JButton oneButton = new JButton("1");
        oneButton.addActionListener(e -> jTextField.setText(jTextField.getText() + oneButton.getText()));
        JButton twoButton = new JButton("2");
        twoButton.addActionListener(e -> jTextField.setText(jTextField.getText() + twoButton.getText()));
        JButton threeButton = new JButton("3");
        threeButton.addActionListener(e -> jTextField.setText(jTextField.getText() + threeButton.getText()));
        JButton fourButton = new JButton("4");
        fourButton.addActionListener(e -> jTextField.setText(jTextField.getText() + fourButton.getText()));
        JButton fiveButton = new JButton("5");
        fiveButton.addActionListener(e -> jTextField.setText(jTextField.getText() + fiveButton.getText()));
        JButton sixButton = new JButton("6");
        sixButton.addActionListener(e -> jTextField.setText(jTextField.getText() + sixButton.getText()));
        JButton sevenButton = new JButton("7");
        sevenButton.addActionListener(e -> jTextField.setText(jTextField.getText() + sevenButton.getText()));
        JButton eightButton = new JButton("8");
        eightButton.addActionListener(e -> jTextField.setText(jTextField.getText() + eightButton.getText()));
        JButton nineButton = new JButton("9");
        nineButton.addActionListener(e -> jTextField.setText(jTextField.getText() + nineButton.getText()));
        JButton AButton = new JButton("A");
        AButton.addActionListener(e -> jTextField.setText(jTextField.getText() + AButton.getText()));
        JButton BButton = new JButton("B");
        BButton.addActionListener(e -> jTextField.setText(jTextField.getText() + BButton.getText()));
        JButton CButton = new JButton("C");
        CButton.addActionListener(e -> jTextField.setText(jTextField.getText() + CButton.getText()));
        JButton DButton = new JButton("D");
        DButton.addActionListener(e -> jTextField.setText(jTextField.getText() + DButton.getText()));
        JButton EButton = new JButton("E");
        EButton.addActionListener(e -> jTextField.setText(jTextField.getText() + EButton.getText()));
        JButton FButton = new JButton("F");
        FButton.addActionListener(e -> jTextField.setText(jTextField.getText() + FButton.getText()));
        JButton CEButton = new JButton("CE");

        CEButton.addActionListener(e -> {
            jTextField.setText("");
            operations.clear();
        });
        JButton MinusButton = new JButton("-");
        MinusButton.addActionListener(e -> {
            String currentText = jTextField.getText();
            if (currentText.charAt(0) == '-') {
                StringBuilder sb = new StringBuilder();
                sb.append(currentText);
                sb.deleteCharAt(0);
                Operation operation = new Operation(sb.toString(), MinusButton.getText());
                operations.add(operation);
            } else if (currentText.charAt(0) != '-') {
                Operation operation = new Operation(jTextField.getText(), "+");
                operations.add(operation);
            }
            jTextField.setText("");
        });
        JButton PlusButton = new JButton("+");
        PlusButton.addActionListener(e -> {
            Operation operation = new Operation(jTextField.getText(), PlusButton.getText());
            operations.add(operation);
            jTextField.setText("");
        });
        JButton EqualsButton = new JButton("=");
        EqualsButton.addActionListener(e -> {
            Operation lastOperation = new Operation(jTextField.getText(), PlusButton.getText());
            operations.add(lastOperation);
            double result = 0;
            for (Operation operation : operations) {
                String valueString = operation.operation+operation.number;
                double valueNumerical = Double.parseDouble(valueString);
                result += valueNumerical;
            }
            jTextField.setText(Double.toString(result));
            operations.clear();

        });

        gridButtonArea.add(zeroButton);
        gridButtonArea.add(oneButton);
        gridButtonArea.add(twoButton);
        gridButtonArea.add(threeButton);
        gridButtonArea.add(fourButton);
        gridButtonArea.add(fiveButton);
        gridButtonArea.add(sixButton);
        gridButtonArea.add(sevenButton);
        gridButtonArea.add(eightButton);
        gridButtonArea.add(nineButton);
        gridButtonArea.add(AButton);
        gridButtonArea.add(BButton);
        gridButtonArea.add(CButton);
        gridButtonArea.add(DButton);
        gridButtonArea.add(EButton);
        gridButtonArea.add(FButton);
        gridButtonArea.add(CEButton);
        gridButtonArea.add(MinusButton);
        gridButtonArea.add(PlusButton);
        gridButtonArea.add(EqualsButton);


        mainPanel.add(inputArea, BorderLayout.PAGE_START);
        mainPanel.add(gridButtonArea, BorderLayout.CENTER);
        pack();


//      managing window size in swing
        add(mainPanel);
        setVisible(true);
        setSize(500, 500);


    }

    public static void init() {

    }

    public double dodaj(double a, double b) {
        int result = 0;
        return result;
    }

    public double pomnoz(double a, double b) {
        int result = 0;
        return result;
    }

    public double podziel(double a, double b) {
        int result = 0;
        return result;
    }

    public double odejmij(double a, double b) {
        int result = 0;
        return result;
    }


}
