package com.company;

public class Przedmiot implements Comparable<Przedmiot> {
    private String nazwa;
    private double objetosc;

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
        if (this.getObjetosc() < przedmiot.getObjetosc()) {
            return -1;
        }
        if (this.getObjetosc() > przedmiot.getObjetosc()) {
            return 1;
        }
        if (this.getObjetosc() == przedmiot.getObjetosc()){
            return -this.getNazwa().compareTo(przedmiot.getNazwa());
        }
        return 0;
    }

    @Override
    public String toString() {
        return  "nazwa='" + nazwa + '\'' +
                ", objetosc=" + objetosc;
    }
}
