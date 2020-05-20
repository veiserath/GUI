package com.company.view;

import com.company.countries.Country;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainMenuFrame extends JFrame implements ActionListener {
    List<Country> countries;
    JPanel jPanel;
    JButton buttonNewGame;
    JButton buttonHighScores;
    JButton buttonExit;

    public MainMenuFrame(List<Country> countries) throws HeadlessException {
        this.countries = countries;
        this.jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));

        setSize(300, 300);
        this.buttonNewGame = new JButton("New Game");
        buttonNewGame.addActionListener(this);
        this.buttonHighScores = new JButton("High Scores");
        buttonHighScores.addActionListener(this);
        this.buttonExit = new JButton("Exit");
        buttonExit.addActionListener(this);

        jPanel.add(buttonNewGame);
        jPanel.add(buttonHighScores);
        jPanel.add(buttonExit);

        add(jPanel);
        setTitle("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNewGame){
            SwingUtilities.invokeLater(() -> {
                DifficultyLevelsFrame difficultyLevelsFrame = new DifficultyLevelsFrame(countries);
            });
            this.dispose();
        }
        else if (e.getSource() == buttonHighScores){
            SwingUtilities.invokeLater(() -> {
                HighScoresFrame highScoresFrame = new HighScoresFrame();
            });
            this.dispose();
        }
        else if (e.getSource() == buttonExit){
            System.exit(0);
        }
    }
}
