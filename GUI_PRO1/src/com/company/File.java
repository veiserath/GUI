package com.company;

public class File {
    String trescPisma;
    String dotyczyPomieszczenia;
    String dotyczyOsiedla;

    public File(Mieszkanie mieszkanie) {
        this.trescPisma = mieszkanie.najemca.imie + ", spozniasz sie z czynszem za: " + mieszkanie.id + " na: " + mieszkanie.nazwaOsiedla;
        this.dotyczyPomieszczenia = mieszkanie.id;
        this.dotyczyOsiedla = mieszkanie.nazwaOsiedla;
    }
    public File(MiejsceParkingowe miejsceParkingowe) {
        this.trescPisma = miejsceParkingowe.najemca.imie + ", spozniasz sie z czynszem za: " + miejsceParkingowe.id + " na: " + miejsceParkingowe.nazwaOsiedla;
        this.dotyczyPomieszczenia = miejsceParkingowe.id;
        this.dotyczyOsiedla = miejsceParkingowe.nazwaOsiedla;
    }
}

