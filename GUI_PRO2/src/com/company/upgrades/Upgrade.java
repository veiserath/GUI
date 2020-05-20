package com.company.upgrades;

public class Upgrade {
    String name;
    long costInPoints;
    long effects;

    public Upgrade(String name, long costInPoints, long effects) {
        this.name = name;
        this.costInPoints = costInPoints;
        this.effects = effects;
    }

    public String getName() {
        return name;
    }

    public long getCostInPoints() {
        return costInPoints;
    }

    public long getEffects() {
        return effects;
    }
}
