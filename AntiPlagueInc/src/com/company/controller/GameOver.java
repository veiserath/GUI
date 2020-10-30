package com.company.controller;

import com.company.elements.Country;
import com.company.model.Ranking;
import com.company.view.HighScoresFrame;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame {
    private JPanel jPanel;
    private JLabel labelOutcome;
    private JLabel labelTypeYourName;
    private JTextField textFieldForName;
    private JButton buttonSaveYourName;
    private GameTime gameTime;
    public static String difficulty = "Beginner";


    public GameOver(String outcome, GameTime gameTime) {
        setTitle("Game over");

        this.gameTime = gameTime;
        Ranking ranking = new Ranking();
        ranking.readData();

        setLayout(new GridLayout(4, 1));
        this.jPanel = new JPanel();
        this.labelOutcome = new JLabel(outcome);
        this.labelTypeYourName = new JLabel("Type in your name below: ");
        this.textFieldForName = new JTextField(10);

        this.buttonSaveYourName = new JButton("Save ranking.");

        jPanel.add(labelOutcome);
        jPanel.add(labelTypeYourName);
        jPanel.add(textFieldForName);
        jPanel.add(buttonSaveYourName);

        buttonSaveYourName.addActionListener(e -> {
            ranking.addRank(textFieldForName.getText(), gameTime.getTotalRankingTime(), Country.getInfectedOfAllCountries(), Country.getCuredOfAllCountries(), Country.getDiedOfAllCountries(), GameOver.difficulty);
            HighScoresFrame highScoresFrame = new HighScoresFrame();
        });

        add(jPanel);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(300, 300));
        pack();
        setVisible(true);
    }
}
