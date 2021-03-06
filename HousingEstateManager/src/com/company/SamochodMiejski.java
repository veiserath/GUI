package com.company;

public class SamochodMiejski extends Pojazd {

    Silnik silnik;

    public SamochodMiejski(String nazwa, double objetosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, "SamochodMiejski", typSilnika);
        this.silnik = silnik;
    }

    public SamochodMiejski(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, "SamochodMiejski", typSilnika);
        this.silnik = silnik;
    }

    @Override
    public void wsiadz(Person person) {
        System.out.println("ale wygodnie!");
    }

    @Override
    public void wysiadz(Person person) {
        System.out.println("Wysiadam z auta miejskiego");
    }

    public void automatyczneParkowanie(){
        System.out.println("samochod zostal automatycznie zaparkowany.");
    }
}
