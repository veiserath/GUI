package com.company.view;

import com.company.controller.CountryParameters;
import com.company.elements.Country;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameWindowFrame extends JFrame implements KeyListener {

    JPanel interactiveMapPanel;
    ArrayList<Integer> keysDown;
    List<Country> countries;
    GameParametersPanel gameParametersPanel;


    public GameWindowFrame(List<Country> countries) throws IOException {
        this.countries = countries;
        this.gameParametersPanel = new GameParametersPanel(countries);
        this.interactiveMapPanel = new InteractiveMapPanel(countries);
        setFocusable(true);

        Thread countryParameters = new CountryParameters(countries, gameParametersPanel.getGameTime());
        countryParameters.start();

        this.keysDown = new ArrayList<>();
        addKeyListener(this);

        setLayout(new BorderLayout());
        setTitle("Game Window");

        add(gameParametersPanel, BorderLayout.NORTH);
        add(interactiveMapPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);


    }

    public void gameOver(JPanel gameoverPanel) {
        this.remove(interactiveMapPanel);
        this.add(gameoverPanel, BorderLayout.CENTER);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keysDown.contains(new Integer(e.getKeyCode()))) {
            keysDown.add(e.getKeyCode());
        }
        if (keysDown.contains(new Integer(16)) && keysDown.contains(new Integer(17)) && keysDown.contains(new Integer(79))) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    MainMenuFrame mainMenuFrame = new MainMenuFrame(countries);
                }
            });
            this.dispose();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        keysDown.remove(new Integer((e.getKeyCode())));
    }


}