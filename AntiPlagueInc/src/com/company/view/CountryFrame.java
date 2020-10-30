package com.company.view;

import com.company.elements.Country;

import javax.swing.*;
import java.awt.*;

public class CountryFrame extends JFrame {
    private JPanel countryParametersPanel;
    private JPanel gameUpgradesPanel;

    public CountryFrame(Country country) {

        this.setLayout(new BorderLayout());
        this.countryParametersPanel = new CountryParametersPanel(country);
        this.gameUpgradesPanel = new GameUpgradesPanel(country);


        add(countryParametersPanel, BorderLayout.NORTH);
        add(gameUpgradesPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);


    }

}
