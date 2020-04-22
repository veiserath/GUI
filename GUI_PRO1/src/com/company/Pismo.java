package com.company;

public class Pismo {
    private String trescPisma;
    private String dotyczyPomieszczenia;
    private String dotyczyOsiedla;

    public Pismo(Mieszkanie mieszkanie) {
        this.trescPisma = mieszkanie.getNajemca().getImie() + ", spozniasz sie z czynszem za: " + mieszkanie.getId() + " na: " + mieszkanie.nazwaOsiedla;
        this.dotyczyPomieszczenia = mieszkanie.getId();
        this.dotyczyOsiedla = mieszkanie.nazwaOsiedla;
    }

    public Pismo(MiejsceParkingowe miejsceParkingowe) {
        this.trescPisma = miejsceParkingowe.getNajemca().getImie() + ", spozniasz sie z czynszem za: " + miejsceParkingowe.getId() + " na: " + miejsceParkingowe.nazwaOsiedla;
        this.dotyczyPomieszczenia = miejsceParkingowe.getId();
        this.dotyczyOsiedla = miejsceParkingowe.nazwaOsiedla;
    }

    public String getTrescPisma() {
        return trescPisma;
    }

    public String getDotyczyPomieszczenia() {
        return dotyczyPomieszczenia;
    }

    public String getDotyczyOsiedla() {
        return dotyczyOsiedla;
    }
}


