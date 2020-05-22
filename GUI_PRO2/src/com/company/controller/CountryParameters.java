package com.company.controller;

import com.company.elements.Country;
import com.company.elements.Transportation;

import java.util.List;


public class CountryParameters extends Thread {
    private List<Country> countries;
    private int difficulty;
    private GameTime gameTime;


    public CountryParameters(List<Country> countries, GameTime gameTime) {
        this.gameTime = gameTime;

        switch (GameOver.difficulty) {
            case "Beginner":
                difficulty = 2;
                break;
            case "Intermediate":
                difficulty = 3;
                break;
            case "Expert":
                difficulty = 4;
                break;
        }
        this.countries = countries;
    }

    @Override
    public void run() {

        while (Country.getCountriesDead() < countries.size()) {
            for (Country country : countries) {
                infect(country);
                closeTransportation(country);
                country.transportationIsClosedGenerateMessage();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        gameOverAction();
        gameTime.interrupt();
    }

    public void infect(Country country) {

        long infected = country.getInfected() + (difficulty * country.getInfected() * (country.transportationsOpen() + 1));
        long cured = (long) (difficulty * infected * 0.05);
        long died = (long) (difficulty * infected * 0.01);
        long points = (long) (difficulty * infected * 0.01);

        if ((infected + cured + died) < country.getTotalPopulation()) {
            country.setInfected(country.getInfected() + infected);
            Country.setInfectedOfAllCountries(Country.getInfectedOfAllCountries() + infected);
            country.setCured(country.getCured() + cured);
            Country.setCuredOfAllCountries(Country.getCuredOfAllCountries() + cured);
            country.setDied(died);
            Country.setDiedOfAllCountries(Country.getDiedOfAllCountries() + died);
            country.setPoints(country.getPoints() + points);
            Country.setPointsOfAllCountries(Country.getPointsOfAllCountries() + points);
        } else {
            Country.setCountriesDead(Country.getCountriesDead() + 1);
        }
    }


    public void closeTransportation(Country country) {

        for (Transportation transportation : country.getMeansOfTransport()) {
            if (transportation.getClosingCondition() < country.getInfected()) {
                transportation.setOpen(false);
            }
        }
    }

    public void gameOverAction() {
        if (Country.getCuredOfAllCountries() >= Country.getTotalPopulationOfAllCountries()) {
            GameOver gameOver = new GameOver("You won!", gameTime);
        } else {
            GameOver gameOver = new GameOver("You lost!", gameTime);
        }
    }
}