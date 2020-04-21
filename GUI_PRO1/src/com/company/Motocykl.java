package com.company;

public class Motocykl extends Pojazd {

    Silnik silnik;

    public Motocykl(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, typPojazdu, typSilnika);
        this.silnik = silnik;
    }

    public Motocykl(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, typPojazdu, typSilnika);
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

    }

    @Override
    public void cofaj(int predkosc) {

    }
    public void zalozKask(){

    }
}
