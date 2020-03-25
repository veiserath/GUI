package com.company;

public abstract class Urzadzenie {

    String nazwaProducenta;
    double cena;

    Urzadzenie(String nazwaProducenta, double cena){
        this.nazwaProducenta = nazwaProducenta;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return
                "nazwaProducenta='" + nazwaProducenta + '\'' +
                ", cena=" + cena;
    }
}
