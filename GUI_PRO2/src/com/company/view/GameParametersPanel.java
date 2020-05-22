package com.company.view;

import com.company.controller.GameTime;
import com.company.elements.Country;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.List;

public class GameParametersPanel extends JPanel {
    JLabel labelPoints;
    JLabel labelVirusAdvancement;
    JLabel labelTime;
    GameTime gameTime;

    public GameParametersPanel(List<Country> countries) {

        this.gameTime = new GameTime();
        gameTime.start();

        this.setLayout(new GridLayout(1, 3));
        this.setLayout(new FlowLayout());

        this.labelPoints = new JLabel();
        this.labelVirusAdvancement = new JLabel();
        this.labelTime = new JLabel();

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

        labelPoints.setBorder(border);
        labelVirusAdvancement.setBorder(border);
        labelTime.setBorder(border);

        add(labelPoints, FlowLayout.LEFT);
        add(labelVirusAdvancement, FlowLayout.CENTER);
        add(labelTime, FlowLayout.RIGHT);

        worldPopulation(countries);

        thread.start();


    }

    public void updateParameters() {

        this.labelPoints.setText("Points available: " + Country.getPointsOfAllCountries());
        this.labelVirusAdvancement.setText("Infected: " + Country.getInfectedOfAllCountries() + " cured: " + Country.getCuredOfAllCountries() + " died: " + Country.getDiedOfAllCountries());
        this.labelTime.setText("Time elapsed: " + gameTime.getMinutes() + " : " + gameTime.getSeconds());
    }

    public void worldPopulation(List<Country> countries) {

        for (Country country : countries) {
            Country.setTotalPopulationOfAllCountries(Country.getTotalPopulationOfAllCountries() + country.getTotalPopulation());
        }
    }


    Thread thread = new Thread(() -> {
        while (!Thread.interrupted()) {
            updateParameters();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    });

    public GameTime getGameTime() {
        return gameTime;
    }
}
