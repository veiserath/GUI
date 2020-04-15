package com.company;

public class Pojazd extends Przedmiot{
    int pojemnoscSilnika;
    String typPojazdu;
    String typSilnika;

    public Pojazd(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, objetosc);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.typPojazdu = typPojazdu;
        this.typSilnika = typSilnika;
    }

    public Pojazd(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.typPojazdu = typPojazdu;
        this.typSilnika = typSilnika;
    }
}
