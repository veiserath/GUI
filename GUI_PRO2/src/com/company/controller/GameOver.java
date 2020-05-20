package com.company.controller;

import com.company.model.Ranking;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame {
    JPanel jPanel;
    JLabel outcome;
    JLabel labelTypeYourName;
    JTextField textFieldForName;
    JButton buttonSaveYourName;
    GameParameters gameParameters;
    public static String difficulty;


    public GameOver(String outcome, GameParameters gameParameters) {
        setTitle("Game over");

        this.gameParameters = gameParameters;
        Ranking ranking = new Ranking();
        ranking.readData();

        setLayout(new FlowLayout());
        this.jPanel = new JPanel();
        this.outcome = new JLabel(outcome);
        this.labelTypeYourName = new JLabel("Type in your name below: ");
        this.textFieldForName = new JTextField();
        this.buttonSaveYourName = new JButton("Save ranking.");
        buttonSaveYourName.addActionListener(e -> ranking.addRank(textFieldForName.getText(),gameParameters.totalRankingTime,gameParameters.infected,gameParameters.cured,gameParameters.died,difficulty));

        jPanel.add(this.outcome);
        jPanel.add(labelTypeYourName);
        jPanel.add(textFieldForName);
        jPanel.add(buttonSaveYourName);

        add(jPanel);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(300,300));
        setVisible(true);



    }
}
