package com.company;

public class Przedmiot {
    String nazwa;
    double objetosc;

    public Przedmiot(String nazwa, double objetosc) {
        this.nazwa = nazwa;
        this.objetosc = objetosc;
    }

    public Przedmiot(String nazwa, double dlugosc, double szerokosc, double wysokosc) {
        this.nazwa = nazwa;
        this.objetosc = dlugosc * szerokosc * wysokosc;
    }

}
