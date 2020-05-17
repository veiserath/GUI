package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DifficultyLevels extends JFrame implements ActionListener {
    JPanel jPanel;
    JButton buttonBeginner;
    JButton buttonIntermediate;
    JButton buttonExpert;


    public DifficultyLevels() throws HeadlessException {
        this.jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));
        setSize(300, 300);
        this.buttonBeginner = new JButton("Beginner");
        buttonBeginner.addActionListener(this);
        this.buttonIntermediate = new JButton("Intermediate");
        buttonIntermediate.addActionListener(this);
        this.buttonExpert = new JButton("Expert");
        buttonExpert.addActionListener(this);


        jPanel.add(buttonBeginner);
        jPanel.add(buttonIntermediate);
        jPanel.add(buttonExpert);

        add(jPanel);
        setVisible(true);
        setTitle("Difficulty");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBeginner){
//            costam zeby to bylo beginner
        }
        else if (e.getSource() == buttonIntermediate){
//            costam zeby to bylo intermediate
        }
        else if (e.getSource() == buttonExpert){
//            costam zeby to bylo expert
        }
        try {
            GameWindowPanel gameWindowPanel = new GameWindowPanel();
            this.dispose();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
