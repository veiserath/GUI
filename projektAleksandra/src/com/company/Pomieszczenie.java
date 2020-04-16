package com.company;

import java.util.Date;

public class Pomieszczenie {
    private Osiedle osiedle;
    private int rozmiarPomieszczenia;
    private Osoba najemca;
    private int rozpoczecieNajmu;
    private int zakonczenieNajmu;

    public Pomieszczenie(int rozmiarPomieszczenia) {
        this.rozmiarPomieszczenia = rozmiarPomieszczenia;
    }

    public Pomieszczenie(int dlugosc, int szerokosc, int wysokosc) {
        this.rozmiarPomieszczenia = dlugosc*szerokosc*wysokosc;
    }

    public int getRozmiarPomieszczenia() {
        return rozmiarPomieszczenia;
    }

    public Osoba getNajemca() {
        return najemca;
    }

    public void setNajemca(Osoba najemca) {
        this.najemca = najemca;
    }

    public void setRozpoczecieNajmu(int rozpoczecieNajmu) {
        this.rozpoczecieNajmu = rozpoczecieNajmu;
    }

    public int getRozpoczecieNajmu() {
        return rozpoczecieNajmu;
    }

    @Override
    public String toString() {
        return  " o rozmiarze: " + rozmiarPomieszczenia+ " najemca :" + najemca;
    }

    public Osiedle getOsiedle() {
        return osiedle;
    }

    public void setOsiedle(Osiedle osiedle) {
        this.osiedle = osiedle;
    }
}

