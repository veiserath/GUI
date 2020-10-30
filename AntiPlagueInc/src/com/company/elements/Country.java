package com.company.elements;

import com.company.view.UserMessage;

public class Country {
    private final String name;
    private final Upgrade[] upgrades;
    private final Transportation[] meansOfTransport;
    private final long totalPopulation;
    private long infected;
    private long cured;
    private long died;
    private long points;

    private static long totalPopulationOfAllCountries;
    private static long infectedOfAllCountries;
    private static long curedOfAllCountries;
    private static long diedOfAllCountries;
    private static long pointsOfAllCountries;
    private static int countriesDead = 0;

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

    public synchronized Upgrade[] getUpgrades() {
        return upgrades;
    }

    public synchronized Transportation[] getMeansOfTransport() {
        return meansOfTransport;
    }

    public synchronized long getTotalPopulation() {
        return totalPopulation;
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

    public int transportationsOpen() {
        int howManyOpen = 0;
        for (Transportation transportation : meansOfTransport) {
            if (transportation.isOpen()) {
                howManyOpen++;
            }
        }
        return howManyOpen;
    }

    public void transportationIsClosedGenerateMessage() {
        for (Transportation transportation : meansOfTransport) {
            if (!transportation.isOpen()) {
                UserMessage userMessage = new UserMessage(this.name + " closed its " + transportation.getName() + " transport.");
            }
        }
    }

    public synchronized static void setTotalPopulationOfAllCountries(long totalPopulationOfAllCountries) {
        Country.totalPopulationOfAllCountries = totalPopulationOfAllCountries;
    }

    public synchronized static void setInfectedOfAllCountries(long infectedOfAllCountries) {
        Country.infectedOfAllCountries = infectedOfAllCountries;
    }

    public synchronized static void setCuredOfAllCountries(long curedOfAllCountries) {
        Country.curedOfAllCountries = curedOfAllCountries;
    }

    public synchronized static void setDiedOfAllCountries(long diedOfAllCountries) {
        Country.diedOfAllCountries = diedOfAllCountries;
    }

    public synchronized static void setPointsOfAllCountries(long pointsOfAllCountries) {
        Country.pointsOfAllCountries = pointsOfAllCountries;
    }

    public synchronized static long getTotalPopulationOfAllCountries() {
        return totalPopulationOfAllCountries;
    }

    public synchronized static long getInfectedOfAllCountries() {
        return infectedOfAllCountries;
    }

    public synchronized static long getCuredOfAllCountries() {
        return curedOfAllCountries;
    }

    public synchronized static long getDiedOfAllCountries() {
        return diedOfAllCountries;
    }

    public synchronized static long getPointsOfAllCountries() {
        return pointsOfAllCountries;
    }


    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }

    public static int getCountriesDead() {
        return countriesDead;
    }

    public static void setCountriesDead(int countriesDead) {
        Country.countriesDead = countriesDead;
    }
}
