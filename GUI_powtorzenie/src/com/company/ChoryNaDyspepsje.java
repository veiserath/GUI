package com.company;

public class ChoryNaDyspepsje extends Pacjent {

    String name;
    private String choroba;
    private String leczenie;

    ChoryNaDyspepsje(String name) {
        super(name);
        this.name = name;
        this.choroba = "dyspepsja";
        this.leczenie = "węgiel";

    }

    public String choroba() {
        return this.choroba;
    }

    public String leczenie() {
        return this.leczenie;
    }

}
