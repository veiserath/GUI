package com.company;

public abstract class Pojazd extends Przedmiot {
    int pojemnoscSilnika;
    String typPojazdu;
    String typSilnika;

    public Pojazd(String nazwa, double objetosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, objetosc);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.typPojazdu = typPojazdu;
        this.typSilnika = typSilnika;
    }

    public Pojazd(String nazwa, double dlugosc, double szerokosc, double wysokosc, int pojemnoscSilnika, String typPojazdu, String typSilnika) {
        super(nazwa, dlugosc, szerokosc, wysokosc);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.typPojazdu = typPojazdu;
        this.typSilnika = typSilnika;
    }

    public void jazda(int predkosc){
        System.out.println("jade z predkoscia: " + predkosc);
    }

    public void stop(){
        System.out.println("Stop!");
    }

    public void wsiadz(Osoba osoba){
        System.out.println("Wsiadam!");
    }

    public abstract void wysiadz(Osoba osoba);

    public void cofaj(int predkosc){
        System.out.println("Cofam!");
    }
}
