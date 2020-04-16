package com.company;

public class SamochodMiejski extends Pojazd implements IntefejsPojazd{
    public SamochodMiejski(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, objetosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }

    public SamochodMiejski(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }

    @Override
    public void jazda(int predkosc) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void wsiadz(Osoba osoba) {

    }

    @Override
    public void wysiadz(Osoba osoba) {

    }

    @Override
    public void cofaj(int predkosc) {

    }
    public void automatyczneParkowanie(){

    }
}
