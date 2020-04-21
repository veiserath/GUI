package com.company;

public class Amfibia extends Pojazd implements Plywajacy {

    public Amfibia(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, objetosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }

    public Amfibia(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc, pojemnoscSilnika, typPojazdu, typSilnika);
    }

    @Override
    public void wysiadz(Osoba osoba) {
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
