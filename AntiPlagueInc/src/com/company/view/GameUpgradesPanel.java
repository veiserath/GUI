package com.company.view;

import com.company.elements.Country;
import com.company.elements.Upgrade;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GameUpgradesPanel extends JPanel {

    JButton BuildHospital;
    JButton BuyHandSanitizers;
    JButton BuyTests;
    JButton CloseSchools;
    JButton FindCure;
    JButton IncreaseMedSal;
    JButton IsolatePeople;
    JButton RaiseAwareness;
    JButton TrackingApp;

    ArrayList<JButton> jButtons;
    Country country;

    public GameUpgradesPanel(Country country) {

        this.country = country;

        this.jButtons = new ArrayList<>();


        this.setLayout(new GridLayout(3, 4));
        this.BuildHospital = new JButton("Build hospital");
        this.BuyHandSanitizers = new JButton("Buy hand sanitizers");
        this.BuyTests = new JButton("Buy tests");
        this.CloseSchools = new JButton("Close schools");
        this.FindCure = new JButton("Find cure");
        this.IncreaseMedSal = new JButton("Increase medical staff salary");
        this.IsolatePeople = new JButton("Isolate People");
        this.RaiseAwareness = new JButton("Raise awareness");
        this.TrackingApp = new JButton("Introduce Tracking App");

        add(BuyHandSanitizers);
        BuyHandSanitizers.addActionListener(e -> triggerUpgrade(BuyHandSanitizers));
        jButtons.add(BuyHandSanitizers);
        add(BuyTests);
        BuyTests.addActionListener(e -> triggerUpgrade(BuyTests));
        jButtons.add(BuyTests);
        add(CloseSchools);
        CloseSchools.addActionListener(e -> triggerUpgrade(CloseSchools));
        jButtons.add(CloseSchools);
        add(FindCure);
        FindCure.addActionListener(e -> triggerUpgrade(FindCure));
        jButtons.add(FindCure);
        add(IncreaseMedSal);
        IncreaseMedSal.addActionListener(e -> triggerUpgrade(IncreaseMedSal));
        jButtons.add(IncreaseMedSal);
        add(IsolatePeople);
        IsolatePeople.addActionListener(e -> triggerUpgrade(IsolatePeople));
        jButtons.add(IsolatePeople);
        add(RaiseAwareness);
        RaiseAwareness.addActionListener(e -> triggerUpgrade(RaiseAwareness));
        jButtons.add(RaiseAwareness);
        add(TrackingApp);
        TrackingApp.addActionListener(e -> triggerUpgrade(TrackingApp));
        jButtons.add(TrackingApp);
        add(BuildHospital);
        BuildHospital.addActionListener(e -> triggerUpgrade(BuildHospital));
        jButtons.add(BuildHospital);

        thread.start();

    }


    public void updateButtons() {
        for (JButton jButton : jButtons) {
            for (Upgrade upgrade : country.getUpgrades()) {
                if (jButton.getText().equals(upgrade.getName()) && (country.getPoints() < upgrade.getCostInPoints())) {
                    jButton.setEnabled(false);
                } else if (jButton.getText().equals(upgrade.getName()) && (country.getPoints() > upgrade.getCostInPoints())) {
                    jButton.setEnabled(true);
                }
            }
        }
    }

    Thread thread = new Thread(() -> {

        while (!Thread.interrupted()) {
            updateButtons();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                UserMessage userMessage = new UserMessage("Interrupted Thread Exception! ");
            }
        }
    });

    public void triggerUpgrade(JButton jButton) {
        String upgradeText = jButton.getText();
        for (Upgrade upgrade : country.getUpgrades()) {
            if (upgrade.getName().equals(upgradeText)) {
                country.setCured(country.getCured() + upgrade.getEffects());
                if (country.getPoints() > upgrade.getCostInPoints()) {
                    country.setPoints(country.getPoints() - upgrade.getCostInPoints());
                } else if (country.getPoints() < upgrade.getCostInPoints()) {
                    UserMessage userMessage = new UserMessage("You can't afford this upgrade!");
                }

            }
        }
    }


}
