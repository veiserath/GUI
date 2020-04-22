package com.company;

public class SamochodTerenowy extends Pojazd {

    Silnik silnik;


    public SamochodTerenowy(String nazwa, double objetosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, "SamochodTerenowy", typSilnika);
        this.silnik = silnik;
    }

    public SamochodTerenowy(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, "SamochodTerenowy", typSilnika);
        this.silnik = silnik;
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
        System.out.println("Wysiadam z auta terenowego.");
    }



    public void trybTerenowy() {
        System.out.println("Jade terenowo!");
    }
}
