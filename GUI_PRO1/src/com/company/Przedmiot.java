package com.company;

public class Przedmiot implements Comparable<Przedmiot> {
    String nazwa;
    double objetosc;

    public Przedmiot(String nazwa, double objetosc) {
        this.nazwa = nazwa;
        this.objetosc = objetosc;
    }

    public Przedmiot(String nazwa, double dlugosc, double szerokosc, double wysokosc) {
        this.nazwa = nazwa;
        this.objetosc = dlugosc * szerokosc * wysokosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getObjetosc() {
        return objetosc;
    }

    @Override
    public int compareTo(Przedmiot przedmiot) {
        return this.getNazwa().compareTo(przedmiot.getNazwa());
    }
}
