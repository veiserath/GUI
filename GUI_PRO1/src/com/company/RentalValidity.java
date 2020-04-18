package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RentalValidity extends Thread {

    Calendar calendar;
    List<Osiedle> listaWszystkichOsiedli;
    SimpleDateFormat sdf;

    public RentalValidity(DateMover dateMover) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.listaWszystkichOsiedli = dateMover.listaWszystkichOsiedli;
        this.calendar = dateMover.c;
        this.sdf = dateMover.sdf;
    }

    @Override
    public void run() {
        Calendar oneMonthFromLeaseEnd = Calendar.getInstance();
        try {
            while (true) {
                for (Osiedle osiedle : listaWszystkichOsiedli) {
                    for (Blok blok : osiedle.bloki) {
                        for (Mieszkanie mieszkanie : blok.mieszkania) {
                            if (mieszkanie.wynajete) {
                                oneMonthFromLeaseEnd.setTime(mieszkanie.dataZakonczeniaNajmu);
                                oneMonthFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 30);

                                if (mieszkanie.najemca != null && calendar.getTime().compareTo(mieszkanie.dataZakonczeniaNajmu) > 0 && !czyJestJuzPismo(mieszkanie)) {
                                    spoznionyCzynsz(mieszkanie);
                                    mieszkanie.zadluzone = true;
                                }

                                if (mieszkanie.najemca != null && calendar.getTime().compareTo(oneMonthFromLeaseEnd.getTime()) >= 0) {
                                    eksmisja(mieszkanie);
                                    mieszkanie.zadluzone = false;
                                }
                            }

                        }
                    }
                    for (MiejsceParkingowe miejsceParkingowe : osiedle.miejscaParkingowe) {
                        if (miejsceParkingowe.wynajete) {
                            oneMonthFromLeaseEnd.setTime(miejsceParkingowe.dataZakonczeniaNajmu);
                            oneMonthFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 30);
                            if (miejsceParkingowe.najemca != null && calendar.getTime().compareTo(miejsceParkingowe.dataZakonczeniaNajmu) > 0 && !czyJestJuzPismo(miejsceParkingowe)) {
                                spoznionyCzynsz(miejsceParkingowe);
                                miejsceParkingowe.zadluzone = true;
                            } else if (miejsceParkingowe.najemca != null && calendar.getTime().compareTo(oneMonthFromLeaseEnd.getTime()) >= 0) {
                                eksmisja(miejsceParkingowe);
                                miejsceParkingowe.zadluzone = false;
                            }
                        }

                    }
                }
                sleep(10000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void eksmisja(Mieszkanie mieszkanie) {
        mieszkanie.mieszkancy.clear();
        System.out.println(mieszkanie.najemca.imie + ", zostales eksmitowany i wszyscy mieszkancy " + mieszkanie.id + " tez.");
        mieszkanie.najemca = null;
    }

    public synchronized void eksmisja(MiejsceParkingowe miejsceParkingowe) {
        boolean pojazdInList = false;
        for (Przedmiot przedmiot : miejsceParkingowe.przedmioty) {
            if (przedmiot instanceof Pojazd) {
                pojazdInList = true;
                miejsceParkingowe.przedmioty.remove(przedmiot);
                Calendar twoMonthsFromLeaseEnd = Calendar.getInstance();
                twoMonthsFromLeaseEnd.setTime(miejsceParkingowe.dataZakonczeniaNajmu);
                twoMonthsFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 60);
                miejsceParkingowe.dataZakonczeniaNajmu = twoMonthsFromLeaseEnd.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String newDate = sdf.format(miejsceParkingowe.dataZakonczeniaNajmu);
                System.out.println(miejsceParkingowe.najemca.imie + ", zostales eksmitowany z " + miejsceParkingowe.id + "i twoj pojazd  " + przedmiot + " tez.");
                System.out.println("Nowa data zakonczenia najmu to: " + newDate);
            }
        }
        if (!pojazdInList) {
            miejsceParkingowe.przedmioty.clear();
            System.out.println("usunieto przedmioty z " + miejsceParkingowe.id);
        }
        miejsceParkingowe.najemca = null;
    }

    public synchronized void spoznionyCzynsz(Mieszkanie mieszkanie) {
        File pismo = new File(mieszkanie);
        mieszkanie.najemca.pisma.add(pismo);
        System.out.println(pismo.trescPisma);

    }

    public synchronized void spoznionyCzynsz(MiejsceParkingowe miejsceParkingowe) {
        File pismo = new File(miejsceParkingowe);
        miejsceParkingowe.najemca.pisma.add(pismo);
        System.out.println(pismo.trescPisma);
    }
    public synchronized boolean czyJestJuzPismo(Mieszkanie mieszkanie) {
        for (File pismo : mieszkanie.najemca.pisma) {
            if (pismo.dotyczyPomieszczenia.equals(mieszkanie.id)) {
                System.out.println("Juz jest pismo dla: " + mieszkanie.id);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean czyJestJuzPismo(MiejsceParkingowe miejsceParkingowe) {
        for (File pismo : miejsceParkingowe.najemca.pisma) {
            if (pismo.trescPisma.equals(miejsceParkingowe.id)) {
                System.out.println("Juz jest pismo dla: " + miejsceParkingowe.id);
                return true;
            }
        }
        return false;
    }
}
