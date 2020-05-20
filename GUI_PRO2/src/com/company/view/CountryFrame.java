package com.company.view;

import com.company.countries.Country;

import javax.swing.*;
import java.awt.*;

public class CountryFrame extends JFrame {
    JPanel countryParametersPanel;
    JPanel gameUpgradesPanel;

    public CountryFrame(Country country) {

        this.setLayout(new BorderLayout());
        this.countryParametersPanel = new CountryParametersPanel(country);
        this.gameUpgradesPanel = new GameUpgradesPanel(country);


        add(countryParametersPanel,BorderLayout.NORTH);
        add(gameUpgradesPanel,BorderLayout.SOUTH);

//        setPreferredSize(new Dimension(300, 300));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);



    }

}
