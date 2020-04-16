package com.company;

import java.util.ArrayList;
import java.util.List;

public class Osoba {
    private String imie,nazwisko,adres;
    private int pesel;
    private int dataUrodzenia;
    private List<Pomieszczenie> lista = new ArrayList<>(5);


    public Osoba(String imie, String nazwisko, String adres, int pesel, int dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
    }


    public void najmijMieszkanie(Mieszkanie mieszkanie){
        if (mieszkanie.getNajemca() == null){
            mieszkanie.setNajemca(this);
            mieszkanie.getOsiedle().getListaMieszkanwynajetych().add(mieszkanie);
            mieszkanie.getOsiedle().getListaMieszkanwolnych().remove(mieszkanie);
            lista.add(mieszkanie);
            System.out.println("wynajem zakończony sukcjesem");
        }
        else System.out.println("już wynajęte");
    }
    public void najmijMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe){
        if(miejsceParkingowe.getNajemca() == null){
            int f=0;
            for (Pomieszczenie pomieszczenie : lista){
                if (miejsceParkingowe.getOsiedle().equals(pomieszczenie.getOsiedle()))
                    f++;
            }
            if (f>0){
                miejsceParkingowe.setNajemca(this);
                miejsceParkingowe.getOsiedle().getListaMPwolnych().remove(miejsceParkingowe);
                miejsceParkingowe.getOsiedle().getListaMPzajetych().add(miejsceParkingowe);
                lista.add(miejsceParkingowe);

            }
            System.out.println("wynajem zakończony sukcjesem");
        }
    }

    public void zamelduj(Mieszkanie mieszkanie,Osoba osoba){
        if(this.lista.contains(mieszkanie))
            mieszkanie.getListalokatorow().add(osoba);
        }




    //gettery====================================================================================================

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public int getPesel() {
        return pesel;
    }

    public int getDataUrodzenia() {
        return dataUrodzenia;
    }

    public List<Pomieszczenie> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "imie = '" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\''
                ;
    }

}
