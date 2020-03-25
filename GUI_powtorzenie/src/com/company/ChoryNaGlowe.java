package com.company;

public class ChoryNaGlowe extends Pacjent {
    String name;
    private String choroba;
    private String leczenie;

    ChoryNaGlowe(String name) {
        super(name);
        this.name = name;
        this.choroba = "glowa";
        this.leczenie = "aspiryna";

    }

    public String choroba() {
        return this.choroba;
    }

    public String leczenie() {
        return this.leczenie;
    }

}
