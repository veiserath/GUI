package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zadanie1 extends JFrame {

    public Zadanie1() {
        JPanel upper = new JPanel();
        JPanel jPanel = new JPanel();
        JPanel lower = new JPanel();


        Font f = new Font(Font.SERIF, Font.BOLD, 48);
        JLabel jLabel = new JLabel("Sumator");
        jLabel.setFont(f);
        JTextField jTextField = new JTextField("0");
        JTextField jTextField1 = new JTextField("0");


        JLabel a = new JLabel("a:");
        JLabel b = new JLabel("b:");

        jTextField.setPreferredSize(new Dimension(100, 20));
        jTextField1.setPreferredSize(new Dimension(100, 20));
        JButton jButton = new JButton("a+b");

        setVisible(true);
        jPanel.setLayout(new GridLayout(2, 1));
        upper.setLayout(new FlowLayout(FlowLayout.CENTER));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 300);
        add(jPanel);
        upper.add(jLabel);

        lower.setLayout(new FlowLayout());
        lower.add(a);
        lower.add(jTextField);
        lower.add(b);
        lower.add(jTextField1);
        lower.add(jButton);
//        Border blackline = BorderFactory.createLineBorder(Color.black);
//        upper.setBorder(blackline);
//        DropShadowBorder shadow = new DropShadowBorder();
        jPanel.add(upper);
        jPanel.add(lower);
        pack();

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstValueNumerical = Double.parseDouble(jTextField.getText());
                double secondValueNumerical = Double.parseDouble(jTextField1.getText());
                double result = firstValueNumerical + secondValueNumerical;
                jButton.setText(String.valueOf(result));


            }
        });


    }


}
