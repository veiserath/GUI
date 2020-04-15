package com.company;

import java.util.ArrayList;
import java.util.List;

public class Najemca extends Osoba {


    public Najemca(String imie, String nazwisko, int PESEL, String adres, String dataUrodzenia) {
        super(imie, nazwisko, PESEL, adres, dataUrodzenia);
    }

    public void zamelduj(Osoba osoba, Mieszkanie mieszkanie) {
        mieszkanie.mieszkancy.add(osoba);

    }

    public void wymelduj(Osoba osoba, Mieszkanie mieszkanie) {
        mieszkanie.usunNajemce(osoba);

    }

    public void wynajmijMieszkanie(Mieszkanie mieszkanie) throws ProblematicTenantException {
        if (this.pisma.size() >= 3) {
            throw new ProblematicTenantException("Osoba " + this.imie + " " + this.nazwisko + " posiadała już najem pomieszczeń: " + this.miejscaParkingowe + " " + this.mieszkania);
        } else if (mieszkania.size() + miejscaParkingowe.size() < 6) {
            mieszkania.add(mieszkanie);
        } else {
            System.out.println("Nie mozesz wynajmowac wiecej mieszkan.");
        }
    }

    public void wynajmijMiejsceParkingowe(Mieszkanie mieszkanie, MiejsceParkingowe miejsceParkingowe) {
        if (mieszkania.size() + miejscaParkingowe.size() < 6) {
            mieszkanie.miejsceParkingowe = miejsceParkingowe;
        } else {
            System.out.println("Nie mozesz wynajmowac wiecej mieszkan.");
        }
    }

    public void wypowiedzMieszkanie(Mieszkanie mieszkanie) {
        mieszkania.remove(mieszkanie);
    }

    public void wypowiedzMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe) {
        miejscaParkingowe.remove(miejsceParkingowe);
    }

    public void wlozPrzedmiot(MiejsceParkingowe miejsceParkingowe, Przedmiot przedmiot) {
        miejsceParkingowe.przedmioty.add(przedmiot);

    }

    public void wyjmijPrzedmiot(MiejsceParkingowe miejsceParkingowe, Przedmiot przedmiot) {
        miejsceParkingowe.przedmioty.add(przedmiot);

    }
}
