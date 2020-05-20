package com.company.controller;

import com.company.countries.Country;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameParameters extends Thread {

    long seconds;
    long minutes;
    long infected;
    long cured;
    long died;
    long points;
    long worldPopulation;
    long totalRankingTime;


    List<Country> countries;


    public GameParameters(List<Country> countries) {

        this.countries = countries;
        this.infected = 0L;
        this.cured = 0L;
        this.died = 0L;
        this.points = 0L;
        this.totalRankingTime = 0L;

        calculateTime();
        calculateAllCases();

    }


    public void calculateTime() {
        long startTime = System.nanoTime();
        while (true) {
            long elapsedTime = System.nanoTime() - startTime;
            this.seconds = TimeUnit.NANOSECONDS.toSeconds(elapsedTime) % 60;
            this.minutes = TimeUnit.NANOSECONDS.toMinutes(elapsedTime) % 60;
            this.totalRankingTime = TimeUnit.NANOSECONDS.toMinutes(elapsedTime);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void calculateAllCases() {
        boolean populationCounted = false;
        while (true) {
            for (Country country : countries) {
                this.infected += country.getInfected();
                this.cured += country.getCured();
                this.died += country.getDied();
                this.points += country.getPoints();
                if (!populationCounted) {
                    this.worldPopulation += country.getTotalPopulation();
                }
            }
            populationCounted = true;
            if (this.infected == this.worldPopulation) {
                GameOver gameOver = new GameOver("You lost", this);
            } else if (this.cured == worldPopulation) {
                GameOver gameOver = new GameOver("You won", this);
            } else if (this.died == worldPopulation) {
                GameOver gameOver = new GameOver("You lost", this);
            }
        }
    }
}
