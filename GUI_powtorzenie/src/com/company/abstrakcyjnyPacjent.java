package com.company;

public abstract class abstrakcyjnyPacjent {
    String nazwisko;
    String choroba;
    String leczenie;


    abstrakcyjnyPacjent(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String nazwisko() {
        return this.nazwisko;
    }

    public abstract String choroba();

    public abstract String leczenie();

}
