package com.company;

public class SamochodMiejski extends Pojazd {

    Silnik silnik;

    public SamochodMiejski(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, typPojazdu, typSilnika);
        this.silnik = silnik;
    }

    public SamochodMiejski(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, typPojazdu, typSilnika);
        this.silnik = silnik;
    }

    @Override
    public void wsiadz(Osoba osoba) {
        System.out.println("ale wygodnie!");
    }

    @Override
    public void wysiadz(Osoba osoba) {
        System.out.println("Wysiadam z auta miejskiego");
    }

    public void automatyczneParkowanie(){
        System.out.println("samochod zostal automatycznie zaparkowany.");
    }
}
