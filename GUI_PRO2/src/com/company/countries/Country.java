package com.company.countries;

import com.company.transportation.Transportation;
import com.company.upgrades.Upgrade;

import java.util.List;

public class Country {
    String name;
    Upgrade[] upgrades;
    Transportation[] meansOfTransport;
    long totalPopulation;
    long infected;
    long cured;
    long died;
    long points;

    public Country(String name, Upgrade[] upgrades, Transportation[] meansOfTransport, long totalPopulation) {
        this.name = name;
        this.upgrades = upgrades;
        this.meansOfTransport = meansOfTransport;
        this.totalPopulation = totalPopulation;
        this.infected = 1;
        this.cured = 0;
        this.died = 0;
        this.points = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Upgrade[] getUpgrades() {
        return upgrades;
    }

    public void setUpgrades(Upgrade[] upgrades) {
        this.upgrades = upgrades;
    }

    public Transportation[] getMeansOfTransport() {
        return meansOfTransport;
    }

    public void setMeansOfTransport(Transportation[] meansOfTransport) {
        this.meansOfTransport = meansOfTransport;
    }

    public long getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(long totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public long getInfected() {
        return infected;
    }

    public void setInfected(long infected) {
        this.infected = infected;
    }

    public long getCured() {
        return cured;
    }

    public void setCured(long cured) {
        this.cured = cured;
    }

    public long getDied() {
        return died;
    }

    public void setDied(long died) {
        this.died = died;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
