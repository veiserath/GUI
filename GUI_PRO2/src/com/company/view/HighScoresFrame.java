package com.company.view;

import com.company.model.Ranking;

import javax.swing.*;
import java.awt.*;

public class HighScoresFrame extends JFrame {
    JList<String> highScoresList;
    DefaultListModel<String> highScoresData;
    JPanel jPanel;
    JScrollPane jScrollPane;

    public HighScoresFrame() {

        Ranking ranking = new Ranking();
        ranking.readData();

        this.jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        this.highScoresData = ranking.highScoresData;
        this.highScoresList = new JList<>(highScoresData);

        this.jScrollPane = new JScrollPane(highScoresList);

        setPreferredSize(new Dimension(450, 110));
        jPanel.add(jScrollPane, BorderLayout.CENTER);


        add(jPanel);
        setTitle("High Scores - higher ranking is better");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(300, 300));
        pack();
        setVisible(true);
    }

}
