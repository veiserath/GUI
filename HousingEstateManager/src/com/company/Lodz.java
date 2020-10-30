package com.company;

public class Lodz extends Pojazd implements Plywajacy{

    Silnik silnik;


    public Lodz(String nazwa, double objetosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, "Lodz", typSilnika);
        this.silnik = silnik;
    }

    public Lodz(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, "Lodz", typSilnika);
        this.silnik = silnik;
    }

    @Override
    public void jazda(int predkosc) {
        System.out.println("jade z predkoscia: " + predkosc);
    }

    @Override
    public void stop() {
        System.out.println("Zatrzymuje sie.");
    }


    @Override
    public void wysiadz(Person person) {
        System.out.println("Plyne wplaw");
    }

    @Override
    public void cofaj(int predkosc) {
        System.out.println("Plyne do tylu");
    }

    public void cumuj() {
        System.out.println("Cumuje");
    }

    @Override
    public void plywaj() {
        System.out.println("Plywam");
    }
}
