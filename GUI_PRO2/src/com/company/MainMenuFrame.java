package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    JPanel jPanel;
    JButton buttonNewGame;
    JButton buttonHighScores;
    JButton buttonExit;

    public MainMenu() throws HeadlessException {
        this.jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(3, 1));

        setSize(300, 300);
        this.buttonNewGame = new JButton("New Game");
        buttonNewGame.addActionListener(this);
        this.buttonHighScores = new JButton("High Scores");
        buttonHighScores.addActionListener(this);
        this.buttonExit = new JButton("Exit");

        jPanel.add(buttonNewGame);
        jPanel.add(buttonHighScores);
        jPanel.add(buttonExit);

        add(jPanel);
        setVisible(true);
        setTitle("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNewGame){
            DifficultyLevelsFrame difficultyLevelsFrame = new DifficultyLevelsFrame();
            this.dispose();
        }
        else if (e.getSource() == buttonHighScores){
            HighScores highScores = new HighScores();
        }
        else if (e.getSource() == buttonExit){
            this.dispose();
        }



    }
}
