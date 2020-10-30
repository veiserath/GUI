package com.company;

public class Amfibia extends Pojazd implements Plywajacy {
    Silnik silnik;

    public Amfibia(String nazwa, double objetosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, objetosc, pojemnoscSilnika, "Amfibia", typSilnika);
        this.silnik = silnik;
    }

    public Amfibia(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typSilnika, Silnik silnik) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, "Amfibia", typSilnika);
        this.silnik = silnik;
    }

    @Override
    public void wysiadz(Person person) {
        System.out.println("Pamietaj zeby byc na ladzie zanim wysiadziesz!");
    }


    public void wjedzDoRzeki() {
        System.out.println("Moge prosto z drogi wjechac do rzeki.");
    }

    @Override
    public void plywaj() {
        System.out.println("Plyne!");
    }
}
