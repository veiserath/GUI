package com.company.elements;

public class Transportation {
    private final String name;
    private long closingCondition;
    private long effect;
    boolean isOpen;


    public Transportation(String name, long closingCondition, long effect) {
        this.isOpen = true;
        this.name = name;
        this.closingCondition = closingCondition;
        this.effect = effect;

    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getName() {
        return name;
    }

    public long getClosingCondition() {
        return closingCondition;
    }


    public void setOpen(boolean open) {
        isOpen = open;
    }
}
