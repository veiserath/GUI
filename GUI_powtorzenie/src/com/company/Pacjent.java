package com.company;

public class Pacjent {

    String nazwisko;
    String choroba;
    String leczenie;


    Pacjent(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String nazwisko() {
        return this.nazwisko;
    }

    public String choroba() {
        return this.choroba;
    }

    public String leczenie() {
        return this.leczenie;
    }


}
