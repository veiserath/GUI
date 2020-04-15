package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RentalValidity extends Thread {

    Calendar c;
    SimpleDateFormat sdf;
    Mieszkanie mieszkanie;
    Date dataZakonczeniaNajmu;
    boolean pismoWyslane;
    MiejsceParkingowe miejsceParkingowe;
    boolean czyMieszkanie;

    public RentalValidity(Mieszkanie mieszkanie, Calendar c, SimpleDateFormat sdf) {
        this.mieszkanie = mieszkanie;
        this.dataZakonczeniaNajmu = mieszkanie.dataZakonczeniaNajmu;
        this.c = c;
        this.sdf = sdf;
        this.pismoWyslane = false;
        this.czyMieszkanie = true;
    }

    public RentalValidity(MiejsceParkingowe miejsceParkingowe, Calendar c, SimpleDateFormat sdf) {
        this.miejsceParkingowe = miejsceParkingowe;
        this.dataZakonczeniaNajmu = miejsceParkingowe.dataZakonczeniaNajmu;
        this.c = c;
        this.sdf = sdf;
        this.pismoWyslane = false;
        this.czyMieszkanie = false;
    }

    @Override
    public void run() {

        try {
            while (true) {
                String newDate = sdf.format(c.getTime());
                System.out.println("A tu cyk wjezdza weryfikacja: " + newDate);
                if (c.getTime().compareTo(dataZakonczeniaNajmu) > 0 && !pismoWyslane && czyMieszkanie) {
                    File pismo = new File();
                    mieszkanie.najemca.wystosujPismo(pismo);
                    pismoWyslane = true;
                    System.out.println("pismo do zioma poszlo + Mieszkanie");
                } else if (c.getTime().compareTo(dataZakonczeniaNajmu) > 0 && !pismoWyslane && !czyMieszkanie) {
                    File pismo = new File();
                    miejsceParkingowe.najemca.wystosujPismo(pismo);
                    pismoWyslane = true;
                    System.out.println("pismo do zioma poszlo + MiejsceParkingowe");
                }
                if (czyMieszkanie && mieszkanie.najemca == null) {
//                    30 dni na odnowienie, a potem jesli nie odnowi to czyscimy pomieszczenie i pismo zostaje w aktach
//                    jesli wynajem odnowiony lub anulowany to pismo usuniete z akt osoby
//                    eksmisja wszystkich osob
                }
                if (!czyMieszkanie && miejsceParkingowe.najemca == null) {
//                    30 dni na odnowienie, a potem jesli nie odnowi to czyscimy pomieszczenie, czyli sprawdzamy czy jest pojazd.
//                    Jeśli tak, to w związku z przyśpieszoną decyzją komorniczą zostaje on sprzedany (z punktu widzenia programu usuwamy obiekt z pomieszczenia), koszt sprzedazy pokrywa najem na 2 miesiace
//                    jesli nie ma auta to utylizujemy przedmioty
//                    pismo zostaje w aktach
//
//                    jesli wynajem odnowiony lub anulowany to pismo usuniete z akt osoby
                }
                sleep(10000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
