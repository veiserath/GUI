package com.company;

public class Motocykl extends Pojazd {

    public Motocykl(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, objetosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }

    public Motocykl(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }
}
