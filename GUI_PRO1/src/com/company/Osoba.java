package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Osoba {
    String imie;
    String nazwisko;
    String PESEL;
    String adres;
    String dataUrodzenia;

    volatile List<File> pisma = new LinkedList<>();

    List<Mieszkanie> mieszkania = new ArrayList<>();
    List<MiejsceParkingowe> miejscaParkingowe = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String PESEL, String adres, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
    }

    public void zameldujLokatora(Osoba osoba, Mieszkanie mieszkanie) throws ProblematicTenantException {
        if ((howManyFiles(mieszkanie, osoba) > 2) && mieszkanie.najemca == this) {
//          sprawdzic czy dziala, jak watki beda ok.
            throw new ProblematicTenantException("Osoba: " + osoba.imie + " " + osoba.nazwisko + " posiada juz Mieszkania: " + osoba.mieszkania + " oraz Miejsca Parkingowe: " + osoba.miejscaParkingowe);
        } else if (mieszkanie.najemca == this && !mieszkanie.mieszkancy.contains(osoba)) {
            mieszkanie.mieszkancy.add(osoba);
            System.out.println("Lokator " + osoba.imie + " zameldowany w " + mieszkanie.id);
        } else if (mieszkanie.mieszkancy.contains(osoba)) {
            System.out.println(osoba.imie + " jest juz zameldowana w " + mieszkanie.id);
        } else {
            System.out.println("Tylko najemca może wymeldowywać osoby z mieszkania!");
        }
    }

    public void wymeldujLokatora(Osoba osoba, Mieszkanie mieszkanie) {
        if (mieszkanie.najemca == this && mieszkanie.mieszkancy.contains(osoba)) {
            mieszkanie.mieszkancy.remove(osoba);
            System.out.println("Lokator " + osoba.imie + " wymeldowany.");
        } else if (!mieszkanie.mieszkancy.contains(osoba)) {
            System.out.println(osoba.imie + " nie jest zameldowany w " + mieszkanie.id);
        } else {
            System.out.println("Tylko najemca może usuwać osoby z mieszkania!");
        }

    }

    public synchronized void wynajmijMieszkanie(Mieszkanie mieszkanie, String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) throws ProblematicTenantException, ParseException {
        if (howManyFiles(mieszkanie, this) > 2) {
            throw new ProblematicTenantException("Osoba " + this.imie + " " + this.nazwisko + " posiadała już najem pomieszczeń: " + this.miejscaParkingowe + " " + this.mieszkania);
        } else if ((mieszkania.size() + miejscaParkingowe.size()) < 5 && mieszkanie.najemca == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            mieszkanie.dataRozpoczeciaNajmu = simpleDateFormat.parse(dataRozpoczeciaNajmu);
            mieszkanie.dataZakonczeniaNajmu = simpleDateFormat.parse(dataZakonczeniaNajmu);
            mieszkanie.najemca = this;
            System.out.println(this.imie + " Stales sie najemca " + mieszkanie.id);
            mieszkanie.mieszkancy.add(this);
            mieszkania.add(mieszkanie);
            System.out.println(this.imie + " Stales sie lokatorem " + mieszkanie.id);
            mieszkanie.wynajete = true;
        } else if (mieszkanie.najemca != this && (mieszkania.size() + miejscaParkingowe.size()) < 5) {
            System.out.println(mieszkanie.id + " jest juz wynajete.");
        } else {
            System.out.println("Nie mozesz wynajmowac wiecej mieszkan! " + mieszkanie.id);
        }

    }


    public void wynajmijMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe, String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) throws ParseException, ProblematicTenantException {

        if (howManyFiles(miejsceParkingowe, this) > 2) {
            throw new ProblematicTenantException("Osoba " + this.imie + " " + this.nazwisko + " posiadała już najem pomieszczeń: " + this.miejscaParkingowe + " " + this.mieszkania);
        } else if ((mieszkania.size() + miejscaParkingowe.size()) < 5 && miejsceParkingowe.najemca == null && posiadaMieszkanieNaTymOsiedlu(miejsceParkingowe)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            miejsceParkingowe.dataRozpoczeciaNajmu = simpleDateFormat.parse(dataRozpoczeciaNajmu);
            miejsceParkingowe.dataZakonczeniaNajmu = simpleDateFormat.parse(dataZakonczeniaNajmu);
            miejsceParkingowe.najemca = this;
            miejscaParkingowe.add(miejsceParkingowe);
            System.out.println(this.imie + " Stales sie najemca " + miejsceParkingowe.id);
            miejsceParkingowe.wynajete = true;
        } else if (miejsceParkingowe.najemca != this && (mieszkania.size() + miejscaParkingowe.size()) < 5) {
            System.out.println(miejsceParkingowe.id + " jest juz zajete ");
        } else {
            System.out.println("Nie mozesz wynajmowac wiecej miejsc parkingowych. Nie udalo sie wynajac " + miejsceParkingowe.id);
        }
    }

    public void wypowiedzMieszkanie(Mieszkanie mieszkanie) {
        if (mieszkanie.najemca == this) {
            mieszkanie.najemca = null;
            mieszkania.remove(mieszkanie);
            System.out.println("Mieszkanie wypowiedzone, lokatorzy " + mieszkanie.mieszkancy + " usunieci.");
            mieszkanie.mieszkancy.clear();
            mieszkanie.wynajete = false;
            usunPismo(mieszkanie);
        } else {
            System.out.println("Nie mozesz wypowiedzic mieszkania w ktorym nie mieszkasz!");
        }

    }

    public void wypowiedzMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe) {
        if (miejsceParkingowe.najemca == this) {
            miejsceParkingowe.najemca = null;
            miejscaParkingowe.remove(miejsceParkingowe);
            System.out.println("Wypowiedziales " + miejsceParkingowe.id);
            miejsceParkingowe.wynajete = false;
            usunPismo(miejsceParkingowe);
        } else {
            System.out.println("Nie mozesz wypowiedzic " + miejsceParkingowe.id + ", ktore nie jest Twoje!");
        }

    }

    public void wlozPrzedmiot(MiejsceParkingowe miejsceParkingowe, Przedmiot przedmiot) throws TooManyThingsException {
        if (miejsceParkingowe.objetosc - przedmiot.objetosc < 0) {
            throw new TooManyThingsException();
        } else if (miejsceParkingowe.najemca == this) {
            miejsceParkingowe.objetosc -= przedmiot.objetosc;
            miejsceParkingowe.przedmioty.add(przedmiot);
            System.out.println("Dodales " + przedmiot.nazwa + " na " + miejsceParkingowe.id);
        } else {
            System.out.println(this.imie + ", nie jestes najemca " + miejsceParkingowe.id);
        }
    }

    public void wyjmijPrzedmiot(MiejsceParkingowe miejsceParkingowe, Przedmiot przedmiot) {
        if (miejsceParkingowe.przedmioty.contains(przedmiot) && miejsceParkingowe.najemca == this) {
            miejsceParkingowe.objetosc += przedmiot.objetosc;
            miejsceParkingowe.przedmioty.remove(przedmiot);
            System.out.println("Wyjales " + przedmiot.nazwa + " z " + miejsceParkingowe.id);
        } else if (!miejsceParkingowe.przedmioty.contains(przedmiot)) {
            System.out.println(miejsceParkingowe.id + " nie zawiera " + przedmiot.nazwa);
        } else {
            System.out.println(this.imie + ", nie jestes najemca " + miejsceParkingowe.id);
        }
    }

    public synchronized void odnowNajem(Mieszkanie mieszkanie, String doKiedy) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date nowaDataZakonczeniaNajmu = simpleDateFormat.parse(doKiedy);
        if (mieszkanie.dataZakonczeniaNajmu.compareTo(nowaDataZakonczeniaNajmu) < 0) {
            usunPismo(mieszkanie);
            mieszkanie.dataZakonczeniaNajmu = simpleDateFormat.parse(doKiedy);
            mieszkanie.zadluzone = false;
            String newDate = simpleDateFormat.format(mieszkanie.dataZakonczeniaNajmu);
            System.out.println("Nowa data zakonczenia najmu " + mieszkanie.id + " to: " + newDate);
        } else if (mieszkanie.dataZakonczeniaNajmu.compareTo(nowaDataZakonczeniaNajmu) > 0) {
            System.out.println("Data zakonczenia najmu " + mieszkanie.id + " nastepuje pozniej niz proponowana data przedluzenia.");
        }
    }

    public void odnowNajem(MiejsceParkingowe miejsceParkingowe, String doKiedy) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date nowaDataZakonczeniaNajmu = simpleDateFormat.parse(doKiedy);
        if (miejsceParkingowe.dataZakonczeniaNajmu.compareTo(nowaDataZakonczeniaNajmu) < 0) {
            usunPismo(miejsceParkingowe);
            miejsceParkingowe.dataZakonczeniaNajmu = simpleDateFormat.parse(doKiedy);
            miejsceParkingowe.zadluzone = false;
            String newDate = simpleDateFormat.format(miejsceParkingowe.dataZakonczeniaNajmu);
            System.out.println("Nowa data zakonczenia najmu " + miejsceParkingowe.id + " to: " + newDate);
        } else if (miejsceParkingowe.dataZakonczeniaNajmu.compareTo(nowaDataZakonczeniaNajmu) > 0) {
            System.out.println("Data zakonczenia najmu " + miejsceParkingowe.id + " nastepuje pozniej niz proponowana data przedluzenia.");
        }
    }

    public synchronized void usunPismo(Mieszkanie mieszkanie) {
        if (mieszkanie.najemca == this) {
            for (File pismo : pisma) {
                if (pismo.dotyczyPomieszczenia.equals(mieszkanie.id)) {
                    System.out.println("Usunieto pismo: \"" + pismo.trescPisma + "\" dotyczace " + mieszkanie.id);
                    pisma.remove(pismo);
                }
            }
        }

    }


    public synchronized void usunPismo(MiejsceParkingowe miejsceParkingowe) {
        if (miejsceParkingowe.najemca == this) {
            for (File pismo : pisma) {
                if (pismo.equals(miejsceParkingowe.id)) {
                    System.out.println("Usunieto pismo: \"" + pismo.trescPisma + "\" dotyczace " + miejsceParkingowe.id);
                    pisma.remove(pismo);
                }
            }
            miejsceParkingowe.zadluzone = false;
        }
    }

    public synchronized int howManyFiles(Mieszkanie mieszkanie, Osoba osoba) {
        int iloscPismNaJednoOsiedle = 0;
        for (File pismo : osoba.pisma) {
            if (mieszkanie.nazwaOsiedla.equals(pismo.dotyczyOsiedla)) {
                iloscPismNaJednoOsiedle++;
            }
        }
        System.out.println("Ilosc pism na jedno osiedle: " + iloscPismNaJednoOsiedle);
        return iloscPismNaJednoOsiedle;
    }

    public synchronized int howManyFiles(MiejsceParkingowe miejsceParkingowe, Osoba osoba) {
        int iloscPismNaJednoOsiedle = 0;
        for (File pismo : osoba.pisma) {
            if (miejsceParkingowe.nazwaOsiedla.equals(pismo.dotyczyOsiedla)) {
                iloscPismNaJednoOsiedle++;
            }
        }
        return iloscPismNaJednoOsiedle;
    }

    public synchronized boolean posiadaMieszkanieNaTymOsiedlu(MiejsceParkingowe miejsceParkingowe) {
        for (Mieszkanie mieszkanie : mieszkania) {
            if (mieszkanie.nazwaOsiedla.equals(miejsceParkingowe.nazwaOsiedla)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", adres='" + adres + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", pisma=" + pisma +
                ", mieszkania=" + mieszkania +
                ", miejscaParkingowe=" + miejscaParkingowe +
                '}';
    }

}
