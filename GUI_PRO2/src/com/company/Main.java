package com.company;

import com.company.elements.Country;
import com.company.elements.Transportation;
import com.company.elements.Upgrade;
import com.company.view.MainMenuFrame;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Upgrade buildHospital = new Upgrade("Build hospital", 2, 3000);
        Upgrade buyHandSanitizers = new Upgrade("Buy hand sanitizers", 10, 20000);
        Upgrade buyTests = new Upgrade("Buy tests", 200, 30000);
        Upgrade closeSchools = new Upgrade("Close schools", 4000, 40000);
        Upgrade findCure = new Upgrade("Find cure", 999999, 5000000);
        Upgrade increaseMedSal = new Upgrade("Increase medical staff salary", 5000, 50000);
        Upgrade isolatePeople = new Upgrade("Isolate People", 1000, 30000);
        Upgrade raiseAwareness = new Upgrade("Raise awareness", 10000, 1000000);
        Upgrade introduceTrackingApp = new Upgrade("Introduce Tracking App", 6000, 60000);

        Upgrade[] upgrades = {buildHospital, buyHandSanitizers, buyTests, closeSchools, findCure, increaseMedSal, isolatePeople, raiseAwareness, introduceTrackingApp};

        Transportation aerialAustralia = new Transportation("Aerial", 1000, 200);
        Transportation maritimeAustralia = new Transportation("Maritime", 10000, 2000);

        Transportation[] transportationAustralia = {aerialAustralia, maritimeAustralia};

        Transportation aerialCanada = new Transportation("Aerial", 2000, 200);
        Transportation maritimeCanada = new Transportation("Maritime", 1000, 2000);
        Transportation trainCanada = new Transportation("Train", 500, 100);
        Transportation carCanada = new Transportation("Car", 5000, 4000);

        Transportation[] transportationCanada = {aerialCanada, maritimeCanada, trainCanada, carCanada};

        Transportation aerialEastAfrica = new Transportation("Aerial", 1000, 2000);
        Transportation maritimeEastAfrica = new Transportation("Maritime", 5000, 2500);
        Transportation carEastAfrica = new Transportation("Car", 500000, 40000);

        Transportation[] transportationEastAfrica = {aerialEastAfrica, maritimeEastAfrica, carEastAfrica};

        Transportation aerialEastEurope = new Transportation("Aerial", 100, 3000);
        Transportation trainEastEurope = new Transportation("Train", 500, 4000);
        Transportation carEastEurope = new Transportation("Car", 5000000, 40000);

        Transportation[] transportationEastEurope = {aerialEastEurope, trainEastEurope, carEastEurope};

        Transportation aerialGreenland = new Transportation("Aerial", 100, 3000);
        Transportation maritimeGreenland = new Transportation("Maritime", 500, 4000);

        Transportation[] transportationGreenland = {aerialGreenland, maritimeGreenland};

        Transportation aerialMidAmerica = new Transportation("Aerial", 100, 3000);
        Transportation maritimeMidAmerica = new Transportation("Maritime", 500, 4000);
        Transportation trainMidAmerica = new Transportation("Train", 100, 3000);
        Transportation carMidAmerica = new Transportation("Car", 500, 4000);
        Transportation coachMidAmerica = new Transportation("Coach", 5000, 40000);

        Transportation[] transportationMidAmerica = {aerialMidAmerica, maritimeMidAmerica, trainMidAmerica, carMidAmerica, coachMidAmerica};

        Transportation aerialMiddleEast = new Transportation("Aerial", 900, 3000);
        Transportation maritimeMiddleEast = new Transportation("Maritime", 700, 4000);
        Transportation trainMiddleEast = new Transportation("Train", 800, 3000);
        Transportation carMiddleEast = new Transportation("Car", 550, 4000);
        Transportation coachMiddleEast = new Transportation("Coach", 4990, 40000);

        Transportation[] transportationMiddleEast = {aerialMiddleEast, maritimeMiddleEast, trainMiddleEast, carMiddleEast, coachMiddleEast};

        Transportation aerialNorthAfrica = new Transportation("Aerial", 100, 3000);
        Transportation maritimeNorthAfrica = new Transportation("Maritime", 500, 4005);
        Transportation trainNorthAfrica = new Transportation("Train", 100, 3006);
        Transportation carNorthAfrica = new Transportation("Car", 500, 4050);
        Transportation coachNorthAfrica = new Transportation("Coach", 5000, 4000);

        Transportation[] transportationNorthAfrica = {aerialNorthAfrica, maritimeNorthAfrica, trainNorthAfrica, carNorthAfrica, coachNorthAfrica};

        Transportation aerialNorthEurope = new Transportation("Aerial", 100, 3000);
        Transportation maritimeNorthEurope = new Transportation("Maritime", 500, 4005);
        Transportation carNorthEurope = new Transportation("Car", 500, 4050);

        Transportation[] transportationNorthEurope = {aerialNorthEurope, maritimeNorthEurope, carNorthEurope};

        Transportation aerialRussia = new Transportation("Aerial", 100, 3000);
        Transportation maritimeRussia = new Transportation("Maritime", 500, 4005);
        Transportation carRussia = new Transportation("Car", 500, 4050);

        Transportation[] transportationRussia = {aerialRussia, maritimeRussia, carRussia};

        Transportation aerialSouthAfrica = new Transportation("Aerial", 100, 3000);
        Transportation maritimeSouthAfrica = new Transportation("Maritime", 500, 4005);
        Transportation carSouthAfrica = new Transportation("Car", 500, 4050);

        Transportation[] transportationSouthAfrica = {aerialSouthAfrica, maritimeSouthAfrica, carSouthAfrica};

        Transportation aerialSouthAmerica = new Transportation("Aerial", 100, 3000);
        Transportation maritimeSouthAmerica = new Transportation("Maritime", 500, 4005);
        Transportation trainSouthAmerica = new Transportation("Train", 500, 4050);

        Transportation[] transportationSouthAmerica = {aerialSouthAmerica, maritimeSouthAmerica, trainSouthAmerica};

        Transportation aerialSouthAsia = new Transportation("Aerial", 100, 3000);
        Transportation carSouthAsia = new Transportation("Car", 500, 4000);
        Transportation coachSouthAsia = new Transportation("Coach", 5000, 40000);

        Transportation[] transportationSouthAsia = {aerialSouthAsia, carSouthAsia, coachSouthAsia};

        Transportation trainSouthEurope = new Transportation("Train", 100, 3000);
        Transportation carSouthEurope = new Transportation("Car", 500, 4000);
        Transportation coachSouthEurope = new Transportation("Coach", 5000, 40000);

        Transportation[] transportationSouthEurope = {trainSouthEurope, carSouthEurope, coachSouthEurope};

        Transportation aerialUSA = new Transportation("Aerial", 100, 3000);
        Transportation maritimeUSA = new Transportation("Maritime", 500, 4005);
        Transportation carUSA = new Transportation("Car", 500, 4050);

        Transportation[] transportationUSA = {aerialUSA, maritimeUSA, carUSA};

        Transportation aerialWestAfrica = new Transportation("Aerial", 100, 3000);
        Transportation maritimeWestAfrica = new Transportation("Maritime", 500, 4005);
        Transportation carWestAfrica = new Transportation("Car", 500, 4050);

        Transportation[] transportationWestAfrica = {aerialWestAfrica, maritimeWestAfrica, carWestAfrica};

        Transportation aerialWestEurope = new Transportation("Aerial", 100, 3000);
        Transportation maritimeWestEurope = new Transportation("Maritime", 500, 4005);
        Transportation trainWestEurope = new Transportation("Train", 100, 3006);
        Transportation carWestEurope = new Transportation("Car", 500, 4050);
        Transportation coachWestEurope = new Transportation("Coach", 5000, 4000);

        Transportation[] transportationWestEurope = {aerialWestEurope, maritimeWestEurope, trainWestEurope, carWestEurope, coachWestEurope};

        Country australia = new Country("Australia", upgrades, transportationAustralia, 50000000);
        Country canada = new Country("Canada", upgrades, transportationCanada, 40000000);
        Country eastAfrica = new Country("East Africa", upgrades, transportationEastAfrica, 100000000);
        Country eastEurope = new Country("EastEurope", upgrades, transportationEastEurope, 150000000);
        Country greenland = new Country("Greenland", upgrades, transportationGreenland, 100000);
        Country midAmerica = new Country("Mid America", upgrades, transportationMidAmerica, 20000000);
        Country middleEast = new Country("Middle East", upgrades, transportationMiddleEast, 150000000);
        Country northAfrica = new Country("North Africa", upgrades, transportationNorthAfrica, 200000000);
        Country northEurope = new Country("North Europe", upgrades, transportationNorthEurope, 30000000);
        Country russia = new Country("Russia", upgrades, transportationRussia, 130000000);
        Country southAfrica = new Country("South Africa", upgrades, transportationSouthAfrica, 300000000);
        Country southAmerica = new Country("South America", upgrades, transportationSouthAmerica, 500000000);
        Country southAsia = new Country("South Asia", upgrades, transportationSouthAsia, 800000000);
        Country southEurope = new Country("South Europe", upgrades, transportationSouthEurope, 130000000);
        Country usa = new Country("USA", upgrades, transportationUSA, 330000000);
        Country westAfrica = new Country("West Africa", upgrades, transportationWestAfrica, 400000000);
        Country westEurope = new Country("West Europe", upgrades, transportationWestEurope, 150000000);


        List<Country> countries = new LinkedList<>(Arrays.asList(southAsia, westEurope, middleEast, usa, eastEurope, southEurope, northEurope, midAmerica, canada, northAfrica, australia, russia, southAfrica, southAmerica, westAfrica, greenland, eastAfrica));

        SwingUtilities.invokeLater(() -> {
            MainMenuFrame mainMenuFrame = new MainMenuFrame(countries);
        });


    }
}
