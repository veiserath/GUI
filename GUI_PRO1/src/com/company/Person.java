package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Osoba {
    private String imie;
    private String nazwisko;
    private String PESEL;
    private String adres;
    private String dataUrodzenia;

    volatile List<Pismo> pisma = new LinkedList<>();

    private List<Mieszkanie> mieszkania = new ArrayList<>();
    List<MiejsceParkingowe> miejscaParkingowe = new ArrayList<>();

    public Osoba(String imie, String nazwisko, String PESEL, String adres, String dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.PESEL = PESEL;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
    }

    public void zameldujLokatora(Osoba osoba, Mieszkanie mieszkanie) throws ProblematicTenantException {
        if ((howManyFiles(mieszkanie, osoba) > 2) && mieszkanie.getNajemca() == this) {
//          sprawdzic czy dziala, jak watki beda ok.
            throw new ProblematicTenantException("Osoba: " + osoba.imie + " " + osoba.nazwisko + " posiada juz Mieszkania: " + osoba.mieszkania + " oraz Miejsca Parkingowe: " + osoba.miejscaParkingowe);
        } else if (mieszkanie.getNajemca() == this && !mieszkanie.getMieszkancy().contains(osoba)) {
            mieszkanie.getMieszkancy().add(osoba);
            System.out.println("Lokator " + osoba.imie + " zameldowany w " + mieszkanie.getId() + " przez: " + mieszkanie.getNajemca());
        } else if (mieszkanie.getMieszkancy().contains(osoba)) {
            System.out.println(osoba.imie + " jest juz zameldowana w " + mieszkanie.getId());
        } else {
            System.out.println("Tylko najemca może wymeldowywać osoby z mieszkania!");
        }
    }

    public void wymeldujLokatora(Osoba osoba, Mieszkanie mieszkanie) {
        if (mieszkanie.getNajemca() == this && mieszkanie.getMieszkancy().contains(osoba)) {
            mieszkanie.getMieszkancy().remove(osoba);
            System.out.println("Lokator " + osoba.imie + " wymeldowany.");
        } else if (!mieszkanie.getMieszkancy().contains(osoba)) {
            System.out.println(osoba.imie + " nie jest zameldowany w " + mieszkanie.getId());
        } else {
            System.out.println("Tylko najemca może usuwać osoby z mieszkania!");
        }

    }

    public synchronized void wynajmijMieszkanie(Mieszkanie mieszkanie, String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) throws ProblematicTenantException, ParseException {
        if (howManyFiles(mieszkanie, this) > 2) {
            throw new ProblematicTenantException("Osoba " + this.imie + " " + this.nazwisko + " posiadała już najem pomieszczeń: " + this.miejscaParkingowe + " " + this.mieszkania);
        } else if ((mieszkania.size() + miejscaParkingowe.size()) < 5 && mieszkanie.getNajemca() == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            mieszkanie.setDataRozpoczeciaNajmu(simpleDateFormat.parse(dataRozpoczeciaNajmu));
            mieszkanie.setDataZakonczeniaNajmu(simpleDateFormat.parse(dataZakonczeniaNajmu));
            mieszkanie.setNajemca(this);
            System.out.println(this.imie + " Stales sie najemca " + mieszkanie.getId());
            mieszkanie.getMieszkancy().add(this);
            mieszkania.add(mieszkanie);
            System.out.println(this.imie + " Stales sie lokatorem " + mieszkanie.getId());
            mieszkanie.setWynajete(true);
        } else if (mieszkanie.getNajemca() != this && (mieszkania.size() + miejscaParkingowe.size()) < 5) {
            System.out.println(this.imie + " " + mieszkanie.getId() + " jest juz wynajete.");
        } else {
            System.out.println("Nie mozesz wynajmowac wiecej mieszkan. Nie udalo się wynajac: " + mieszkanie.getId());
        }

    }


    public void wynajmijMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe, String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) throws ParseException, ProblematicTenantException {

        if (howManyFiles(miejsceParkingowe, this) > 2) {
            throw new ProblematicTenantException("Osoba " + this.imie + " " + this.nazwisko + " posiadała już najem pomieszczeń: " + this.miejscaParkingowe + " " + this.mieszkania);
        } else if ((mieszkania.size() + miejscaParkingowe.size()) < 5 && miejsceParkingowe.getNajemca() == null && posiadaMieszkanieNaTymOsiedlu(miejsceParkingowe)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            miejsceParkingowe.setDataRozpoczeciaNajmu(simpleDateFormat.parse(dataRozpoczeciaNajmu));
            miejsceParkingowe.setDataZakonczeniaNajmu(simpleDateFormat.parse(dataZakonczeniaNajmu));
            miejsceParkingowe.setNajemca(this);
            miejscaParkingowe.add(miejsceParkingowe);
            System.out.println(this.imie + " Stales sie najemca " + miejsceParkingowe.getId());
            miejsceParkingowe.setWynajete(true);
        } else if (miejsceParkingowe.getNajemca() != this && (mieszkania.size() + miejscaParkingowe.size()) < 5) {
            System.out.println(this.imie + " " + miejsceParkingowe.getId() + " jest juz zajete ");
        }
        else {
            System.out.println("Nie mozesz wynajmowac wiecej miejsc parkingowych. Nie udalo sie wynajac: " + miejsceParkingowe.getId());
        }
    }

    public void wypowiedzMieszkanie(Mieszkanie mieszkanie) {
        if (mieszkanie.getNajemca() == this) {
            usunPismo(mieszkanie);
            mieszkanie.setNajemca(null);
            mieszkania.remove(mieszkanie);
            System.out.println("Mieszkanie wypowiedzone, lokatorzy " + mieszkanie.getMieszkancy() + " usunieci.");
            mieszkanie.getMieszkancy().clear();
            mieszkanie.setWynajete(false);

        } else {
            System.out.println("Nie mozesz wypowiedzic mieszkania w ktorym nie mieszkasz!");
        }

    }

    public void wypowiedzMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe) {
        if (miejsceParkingowe.getNajemca() == this) {
            usunPismo(miejsceParkingowe);
            miejsceParkingowe.setNajemca(null);
            miejscaParkingowe.remove(miejsceParkingowe);
            System.out.println("Wypowiedziales " + miejsceParkingowe.getId());
            miejsceParkingowe.setWynajete(false);
        } else {
            System.out.println("Nie mozesz wypowiedzic " + miejsceParkingowe.getId() + ", ktore nie jest Twoje!");
        }

    }

    public void wlozPrzedmiot(MiejsceParkingowe miejsceParkingowe, Przedmiot przedmiot) throws TooManyThingsException {
        if (miejsceParkingowe.getWolneMiejsce() - przedmiot.getObjetosc() < 0) {
            throw new TooManyThingsException();
        } else if (miejsceParkingowe.getNajemca() == this) {
            miejsceParkingowe.setWolneMiejsce(miejsceParkingowe.getWolneMiejsce() - przedmiot.getObjetosc());
            miejsceParkingowe.getPrzedmioty().add(przedmiot);
            System.out.println("Dodales " + przedmiot.getNazwa() + " na " + miejsceParkingowe.getId());
        } else {
            System.out.println(this.imie + ", nie jestes najemca " + miejsceParkingowe.getId());
        }
    }

    public void wyjmijPrzedmiot(MiejsceParkingowe miejsceParkingowe, Przedmiot przedmiot) {
        if (miejsceParkingowe.getPrzedmioty().contains(przedmiot) && miejsceParkingowe.getNajemca() == this) {
            miejsceParkingowe.setWolneMiejsce(miejsceParkingowe.getWolneMiejsce() + przedmiot.getObjetosc());
            miejsceParkingowe.getPrzedmioty().remove(przedmiot);
            System.out.println("Wyjales " + przedmiot.getNazwa() + " z " + miejsceParkingowe.getId());
        } else if (!miejsceParkingowe.getPrzedmioty().contains(przedmiot)) {
            System.out.println(miejsceParkingowe.getId() + " nie zawiera " + przedmiot.getNazwa());
        } else {
            System.out.println(this.imie + ", nie jestes najemca " + miejsceParkingowe.getId());
        }
    }

    public synchronized void odnowNajem(Mieszkanie mieszkanie, String doKiedy) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date nowaDataZakonczeniaNajmu = simpleDateFormat.parse(doKiedy);
        if (mieszkanie.getDataZakonczeniaNajmu().compareTo(nowaDataZakonczeniaNajmu) < 0) {
            usunPismo(mieszkanie);
            mieszkanie.setDataZakonczeniaNajmu(simpleDateFormat.parse(doKiedy));
            mieszkanie.setZadluzone(false);
            String newDate = simpleDateFormat.format(mieszkanie.getDataZakonczeniaNajmu());
            System.out.println("Nowa data zakonczenia najmu " + mieszkanie.getId() + " to: " + newDate);
        } else if (mieszkanie.getDataZakonczeniaNajmu().compareTo(nowaDataZakonczeniaNajmu) > 0) {
            System.out.println("Data zakonczenia najmu " + mieszkanie.getId() + " nastepuje pozniej niz proponowana data przedluzenia.");
        }
    }

    public void odnowNajem(MiejsceParkingowe miejsceParkingowe, String doKiedy) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date nowaDataZakonczeniaNajmu = simpleDateFormat.parse(doKiedy);
        if (miejsceParkingowe.getDataZakonczeniaNajmu().compareTo(nowaDataZakonczeniaNajmu) < 0) {
            usunPismo(miejsceParkingowe);
            miejsceParkingowe.setDataZakonczeniaNajmu(simpleDateFormat.parse(doKiedy));
            miejsceParkingowe.setZadluzone(false);
            String newDate = simpleDateFormat.format(miejsceParkingowe.getDataZakonczeniaNajmu());
            System.out.println("Nowa data zakonczenia najmu " + miejsceParkingowe.getId() + " to: " + newDate);
        } else if (miejsceParkingowe.getDataZakonczeniaNajmu().compareTo(nowaDataZakonczeniaNajmu) > 0) {
            System.out.println("Data zakonczenia najmu " + miejsceParkingowe.getId() + " nastepuje pozniej niz proponowana data przedluzenia.");
        }
    }

    public synchronized void usunPismo(Mieszkanie mieszkanie) {
        if (mieszkanie.getNajemca() == this) {
            for (Pismo pismo : pisma) {
                if (pismo.getDotyczyPomieszczenia().equals(mieszkanie.getId())) {
                    System.out.println("Usunieto pismo: \"" + pismo.getTrescPisma() + "\" dotyczace " + mieszkanie.getId());
                    pisma.remove(pismo);
                }
            }
        }

    }


    public synchronized void usunPismo(MiejsceParkingowe miejsceParkingowe) {
//        sprawdzic czy to dziala z equals czy == this
        if (miejsceParkingowe.getNajemca().equals(this)) {
            for (Pismo pismo : pisma) {
                if (pismo.equals(miejsceParkingowe.getId())) {
                    System.out.println("Usunieto pismo: \"" + pismo.getTrescPisma() + "\" dotyczace " + miejsceParkingowe.getId());
                    pisma.remove(pismo);
                }
            }
            miejsceParkingowe.setZadluzone(false);
        }
    }

    public synchronized int howManyFiles(Mieszkanie mieszkanie, Osoba osoba) {
        int iloscPismNaJednoOsiedle = 0;
        for (Pismo pismo : osoba.pisma) {
            if (mieszkanie.nazwaOsiedla.equals(pismo.getDotyczyOsiedla())) {
                iloscPismNaJednoOsiedle++;
            }
        }
        System.out.println("Ilosc pism na jedno osiedle: " + iloscPismNaJednoOsiedle);
        return iloscPismNaJednoOsiedle;
    }

    public synchronized int howManyFiles(MiejsceParkingowe miejsceParkingowe, Osoba osoba) {
        int iloscPismNaJednoOsiedle = 0;
        for (Pismo pismo : osoba.pisma) {
            if (miejsceParkingowe.nazwaOsiedla.equals(pismo.getDotyczyOsiedla())) {
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

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getAdres() {
        return adres;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public List<Pismo> getPisma() {
        return pisma;
    }

    public List<Mieszkanie> getMieszkania() {
        return mieszkania;
    }

    public List<MiejsceParkingowe> getMiejscaParkingowe() {
        return miejscaParkingowe;
    }

    @Override
    public String toString() {
        return "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", adres='" + adres + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\''
//                ", pisma=" + pisma +
//                ", mieszkania=" + mieszkania +
//                ", miejscaParkingowe=" + miejscaParkingowe +
//                '}'
                ;
    }
}
