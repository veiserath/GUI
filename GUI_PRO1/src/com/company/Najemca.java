package com.company;

import java.util.ArrayList;
import java.util.List;

public class Najemca extends Osoba{


    public Najemca(String imie, String nazwisko, int PESEL, String adres, String dataUrodzenia) {
        super(imie, nazwisko, PESEL, adres, dataUrodzenia);
    }

    public void zamelduj(Osoba osoba, Mieszkanie mieszkanie){
        mieszkanie.mieszkancy.add(osoba);

    }
    public void wymelduj(Osoba osoba, Mieszkanie mieszkanie){
        mieszkanie.usunNajemce(osoba);

    }
    public void wynajmijMieszkanie(Mieszkanie mieszkanie){
        if (mieszkania.size() + miejscaParkingowe.size() < 6){
            mieszkania.add(mieszkanie);
        }
        else{
            System.out.println("Nie mozesz wynajmowac wiecej mieszkan. Zastanow sie nad inwestowaniem w kryptowaluty ;)");
        }
    }
    public void wypowiedzMieszkanie(Mieszkanie mieszkanie){
        mieszkania.remove(mieszkanie);
    }
    public void wlozPrzedmiot(Przedmiot przedmiot){
        miejscaParkingowe.add(przedmiot);

    }
    public void wyjmijPrzedmiot(Przedmiot przedmiot){
        miejscaParkingowe.remove(przedmiot);

    }
}
