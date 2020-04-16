package com.company;

import java.util.ArrayList;
import java.util.List;

public class MiejsceParkingowe extends Pomieszczenie{

    private static int nr = 0;
    private final String id;
    private List<Przedmiot> przedmiotylista = new ArrayList<>();
    private List<Pojazd> pojazdylista = new ArrayList<>();

    public MiejsceParkingowe(int rozmiarPomieszczenia){
        super(rozmiarPomieszczenia);
        id="P" +" "+ ++nr;
    }
    public MiejsceParkingowe(int dlugosc,int szerokosc,int wysokosc){
        super(dlugosc, szerokosc, wysokosc);
        id="P" +" "+ ++nr;
    }

    @Override
    public String toString() {
        return "MiejsceParkingowe{" +
                "id='" + id + '\'' +
                ", przedmiotylista=" + przedmiotylista +
                ", pojazdylista=" + pojazdylista +
                '}'+super.toString();
    }
}
