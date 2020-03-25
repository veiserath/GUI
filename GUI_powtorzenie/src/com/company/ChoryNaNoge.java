package com.company;

public class ChoryNaNoge extends Pacjent {
    String name;
    private String choroba;
    private String leczenie;


    ChoryNaNoge(String name) {
        super(name);
        this.name = name;
        this.choroba = "noga";
        this.leczenie = "gips";

    }

    public String choroba() {
        return choroba;
    }

    public String leczenie() {
        return leczenie;
    }
}
