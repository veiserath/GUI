package com.company.view;

import com.company.countries.Country;
import com.company.upgrades.Upgrade;

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
        jButtons.add(BuyHandSanitizers);
        add(BuyTests);
        jButtons.add(BuyTests);
        add(CloseSchools);
        jButtons.add(CloseSchools);
        add(FindCure);
        jButtons.add(FindCure);
        add(IncreaseMedSal);
        jButtons.add(IncreaseMedSal);
        add(IsolatePeople);
        jButtons.add(IsolatePeople);
        add(RaiseAwareness);
        jButtons.add(RaiseAwareness);
        add(TrackingApp);
        jButtons.add(TrackingApp);
        add(BuildHospital);
        jButtons.add(BuildHospital);

        thread.start();

    }


    public void updateButtons(){
        for (JButton jButton : jButtons){
            for (Upgrade upgrade : country.getUpgrades()){
                if (jButton.getText().equals(upgrade.getName()) && (country.getPoints()<upgrade.getCostInPoints())){
                    jButton.setEnabled(false);
                }
                else if (jButton.getText().equals(upgrade.getName()) && (country.getPoints()>upgrade.getCostInPoints())){
                    jButton.setEnabled(true);
                }
            }
        }
    }
    Thread thread = new Thread(() -> {

        while (!Thread.interrupted()){
            updateButtons();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });



}
