package com.company.controller;

import com.company.countries.Country;

import java.util.List;


public class CountryParameters extends Thread {
    List<Country> countries;
//    zalezy od poziomu trudnosci ktory moglby byc enums
    int difficulty;
    public CountryParameters(List<Country> countries) {
        if (GameOver.difficulty.equals("Beginner")){
            difficulty = 2;
        }
        else if (GameOver.difficulty.equals("Intermediate")){
            difficulty = 3;
        }
        else if (GameOver.difficulty.equals("Expert")){
            difficulty = 4;
        }
        this.countries = countries;
    }

    @Override
    public void run() {
        while (true) {
            for (Country country : countries) {
                System.out.println("Tryb trudnosci to: " + difficulty);
                long infected = country.getInfected() + (difficulty * country.getInfected() * country.getMeansOfTransport().length);
                country.setInfected(infected);
                long cured = (long) (difficulty * infected * 0.05);
                country.setCured(cured);
                long died = (long) (difficulty * infected * 0.01);
                country.setDied(died);
                country.setPoints(cured);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
