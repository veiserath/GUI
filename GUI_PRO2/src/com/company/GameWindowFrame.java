package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindowPanel extends JFrame {
    JPanel gameParametersPanel;
    JPanel interactiveMapPanel;
    JPanel gameUpgradesPanel;

    public GameWindowPanel() throws IOException {
        setTitle("Game Window");

        this.setLayout(new GridLayout(3,0));

        this.gameParametersPanel = new GameParametersPanel();
        this.interactiveMapPanel = new InteractiveMapPanel();
        this.gameUpgradesPanel = new GameUpgradesPanel();

        add(gameParametersPanel);
        add(interactiveMapPanel);
        add(gameUpgradesPanel);


//        setSize(993, 693);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
//        buttonRussia.setLocation(816,183);