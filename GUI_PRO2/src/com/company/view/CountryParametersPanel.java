package com.company.view;

import com.company.elements.Country;

import javax.swing.*;
import java.awt.*;

public class CountryParametersPanel extends JPanel {
    Country country;
    JLabel labelInfected;
    JLabel labelCured;
    JLabel labelDead;
    JLabel labelPoints;


    public CountryParametersPanel(Country country) {

        this.country = country;

        this.labelInfected = new JLabel();
        this.labelCured = new JLabel();
        this.labelDead = new JLabel();
        this.labelPoints = new JLabel();

        this.setLayout(new FlowLayout());

        add(labelInfected);
        add(labelCured);
        add(labelDead);
        add(labelPoints);

        updateParameters();
        thread.start();

    }

    public void updateParameters() {
        this.labelInfected.setText("Infected: " + country.getInfected());
        this.labelCured.setText("Cured: " + country.getCured());
        this.labelDead.setText("Dead: " + country.getDied());
        this.labelPoints.setText("Points: " + country.getPoints());
    }

    Thread thread = new Thread(() -> {
        while (!Thread.interrupted()) {
            updateParameters();
        }
    });
}
