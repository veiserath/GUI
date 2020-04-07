package com.company;

import java.util.ArrayList;
import java.util.List;

public class Osoba {
    String imie;
    String nazwisko;
    int PESEL;
    String adres;
    String dataUrodzenia;

    List<File> pisma = new ArrayList<>();

    List<Mieszkanie> mieszkania = new ArrayList<>();
    List<Przedmiot> miejscaParkingowe = new ArrayList<>();

    public Osoba(String imie, String nazwisko, int PESEL, String adres, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
    }

    public void wystosujPismo(File file) {
        pisma.add(file);
    }

}
