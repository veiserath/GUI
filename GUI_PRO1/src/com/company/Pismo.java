package com.company;

public class Pismo {
    String trescPisma;
    String dotyczyPomieszczenia;
    String dotyczyOsiedla;

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
}

