package com.company;

public class Motocykl extends Pojazd {

    Silnik silnik;

    public Motocykl(String nazwa, double objetosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, "Motocykl", typSilnika);
        this.silnik = silnik;
    }

    public Motocykl(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, "Motocykl", typSilnika);
        this.silnik = silnik;
    }

    @Override
    public void jazda(int predkosc) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void wsiadz(Person person) {

    }

    @Override
    public void wysiadz(Person person) {

    }

    @Override
    public void cofaj(int predkosc) {

    }

    public void zalozKask() {

    }
}
