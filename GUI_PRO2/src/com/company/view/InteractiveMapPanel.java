package com.company.view;

import com.company.countries.Country;
import com.company.view.CountryFrame;

import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InteractiveMapPanel extends JPanel {
    JLabel map;
    JButton buttonRussia, buttonAustralia, buttonCanada, buttonEastAfrica, buttonEastEurope,
            buttonGreenland, buttonMidAmerica, buttonMiddleEast, buttonNorthAfrica, buttonNorthEurope,
            buttonSouthAfrica, buttonSouthAsia, buttonSouthEurope, buttonUSA, buttonWestAfrica, buttonWestEurope, buttonSouthAmerica;
    List<Integer> keysDown;
    public InteractiveMapPanel(List<Country> countries) throws IOException {
        this.keysDown = new ArrayList<>();

        this.map = new JLabel(new ImageIcon("worldmap.png"));

        this.buttonRussia = new JButton("Russia");
        this.buttonAustralia = new JButton("Australia");
        this.buttonCanada = new JButton("Canada");
        this.buttonEastAfrica = new JButton("East Africa");
        this.buttonEastEurope = new JButton("East Europe");
        this.buttonGreenland = new JButton("Greenland");
        this.buttonMidAmerica = new JButton("Mid America");
        this.buttonMiddleEast = new JButton("Middle East");
        this.buttonNorthAfrica = new JButton("North Africa");
        this.buttonNorthEurope = new JButton("North Europe");
        this.buttonSouthAfrica = new JButton("South Africa");
        this.buttonSouthAsia = new JButton("South Asia");
        this.buttonSouthEurope = new JButton("South Europe");
        this.buttonUSA = new JButton("USA");
        this.buttonWestAfrica = new JButton("West Africa");
        this.buttonWestEurope = new JButton("West Europe");
        this.buttonSouthAmerica = new JButton("South America");


        buttonRussia.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonRussia.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);


                }
            }
        });
        buttonAustralia.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonAustralia.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });

        buttonCanada.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonCanada.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonEastAfrica.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonEastAfrica.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonEastEurope.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonEastEurope.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonGreenland.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonGreenland.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonMidAmerica.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonMidAmerica.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonMiddleEast.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonMiddleEast.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonNorthAfrica.addActionListener(e -> {
            for (Country country : countries) {
                if (country.getName().equals(buttonNorthAfrica.getText())) {
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonNorthEurope.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonNorthEurope.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonSouthAfrica.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonSouthAfrica.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonSouthAsia.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonSouthAsia.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonSouthEurope.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonSouthEurope.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonUSA.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonUSA.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonWestAfrica.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonWestAfrica.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonWestEurope.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonWestEurope.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });
        buttonSouthAmerica.addActionListener(e -> {
            for (Country country : countries){
                if (country.getName().equals(buttonSouthAmerica.getText())){
                    CountryFrame countryFrame = new CountryFrame(country);
                }
            }
        });


//        russia.setEnabled(false);
        buttonRussia.setBounds(700, 177, 90, 30);
        buttonAustralia.setBounds(815, 490, 90, 30);
        buttonCanada.setBounds(150, 202, 90, 30);
        buttonEastAfrica.setBounds(536, 403, 120, 30);
        buttonEastEurope.setBounds(500, 236, 120, 30);
        buttonGreenland.setBounds(310, 123, 90, 30);
        buttonMidAmerica.setBounds(170, 340, 110, 30);
        buttonMiddleEast.setBounds(570, 320, 120, 30);
        buttonNorthAfrica.setBounds(460, 300, 120, 30);
        buttonNorthEurope.setBounds(440, 188, 120, 30);
        buttonSouthAfrica.setBounds(500, 501, 120, 30);
        buttonSouthAsia.setBounds(700, 300, 120, 30);
        buttonSouthEurope.setBounds(480, 270, 120, 30);
        buttonUSA.setBounds(150, 280, 90, 30);
        buttonWestAfrica.setBounds(420, 357, 110, 30);
        buttonWestEurope.setBounds(380, 238, 120, 30);
        buttonSouthAmerica.setBounds(250, 481, 120, 30);


        map.add(buttonRussia);
        map.add(buttonAustralia);
        map.add(buttonCanada);
        map.add(buttonEastAfrica);
        map.add(buttonEastEurope);
        map.add(buttonGreenland);
        map.add(buttonMidAmerica);
        map.add(buttonMiddleEast);
        map.add(buttonNorthAfrica);
        map.add(buttonNorthEurope);
        map.add(buttonSouthAfrica);
        map.add(buttonSouthAsia);
        map.add(buttonSouthEurope);
        map.add(buttonUSA);
        map.add(buttonWestAfrica);
        map.add(buttonWestEurope);
        map.add(buttonSouthAmerica);


        add(map);


    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        if (bg != null) {
//            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
//        }
//
//    }
}
