package com.company.view;

import com.company.controller.GameOver;
import com.company.countries.Country;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class DifficultyLevelsFrame extends JFrame implements ActionListener {
    List<Country> countries;
    JPanel jPanel;
    JButton buttonBeginner;
    JButton buttonIntermediate;
    JButton buttonExpert;


    public DifficultyLevelsFrame(List<Country> countries) throws HeadlessException {
        this.countries = countries;
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
        setTitle("Difficulty");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonBeginner) {
            GameOver.difficulty = "Beginner";
        } else if (e.getSource() == buttonIntermediate) {
            GameOver.difficulty = "Intermediate";
        } else if (e.getSource() == buttonExpert) {
            GameOver.difficulty = "Expert";
        }


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GameWindowFrame gameWindowFrame = new GameWindowFrame(countries);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });


        this.dispose();

    }
}
