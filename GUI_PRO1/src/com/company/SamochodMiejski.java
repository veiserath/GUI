package com.company;

public class SamochodMiejski extends Pojazd {
    public SamochodMiejski(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, objetosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }

    public SamochodMiejski(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }
}
