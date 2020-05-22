package com.company.elements;

public class Upgrade {
    private String name;
    private long costInPoints;
    private long effects;


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
