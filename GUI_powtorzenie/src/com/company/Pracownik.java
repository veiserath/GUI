package com.company;

public class Pracownik {
    String imie;
    String nazwisko;
    int rokUrodzenia;
    int pensja;
    static int ileStworzonych;

    Pracownik(String imie, String nazwisko, int rokUrodzenia, int pensja){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
        this.pensja = pensja;
        ++this.ileStworzonych;
    }
    public String toString(){
        return this.imie + " " + this.nazwisko + " , " + (2020 - this.rokUrodzenia) + " lat, pensja " + this.pensja;
    }


}
