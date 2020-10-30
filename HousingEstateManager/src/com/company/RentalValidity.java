package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RentalValidity extends Thread {

    Calendar calendar;
    List<Osiedle> osiedla;
    SimpleDateFormat sdf;

    public RentalValidity(DateMover dateMover) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.osiedla = dateMover.osiedla;
        this.calendar = dateMover.c;
        this.sdf = dateMover.sdf;
    }

    @Override
    public void run() {
        Calendar oneMonthFromLeaseEnd = Calendar.getInstance();
        try {
            while (true) {
                for (Osiedle osiedle : osiedla) {
                    for (Blok blok : osiedle.bloki) {
                        for (Mieszkanie mieszkanie : blok.mieszkania) {
                            if (mieszkanie.isWynajete()) {
                                oneMonthFromLeaseEnd.setTime(mieszkanie.getDataZakonczeniaNajmu());
                                oneMonthFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 30);
                                if (mieszkanie.getNajemca() != null && calendar.getTime().compareTo(mieszkanie.getDataZakonczeniaNajmu()) > 0 && !czyJestJuzPismo(mieszkanie)) {
                                    spoznionyCzynsz(mieszkanie);
                                    mieszkanie.setZadluzone(true);
                                }

                                if (mieszkanie.getNajemca() != null && calendar.getTime().compareTo(oneMonthFromLeaseEnd.getTime()) >= 0) {
                                    eksmisja(mieszkanie);
                                    mieszkanie.setZadluzone(false);
                                }
                            }

                        }
                    }
                    for (MiejsceParkingowe miejsceParkingowe : osiedle.miejscaParkingowe) {
                        if (miejsceParkingowe.isWynajete()) {
                            oneMonthFromLeaseEnd.setTime(miejsceParkingowe.getDataZakonczeniaNajmu());
                            oneMonthFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 30);
                            if (miejsceParkingowe.getNajemca() != null && calendar.getTime().compareTo(miejsceParkingowe.getDataZakonczeniaNajmu()) > 0 && !czyJestJuzPismo(miejsceParkingowe)) {
                                spoznionyCzynsz(miejsceParkingowe);
                                miejsceParkingowe.setZadluzone(true);
                            }
                            if (miejsceParkingowe.getNajemca() != null && calendar.getTime().compareTo(oneMonthFromLeaseEnd.getTime()) >= 0) {
                                eksmisja(miejsceParkingowe);
                                miejsceParkingowe.setZadluzone(false);
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
        System.out.println(mieszkanie.getNajemca().getImie() + ", zostales eksmitowany z " + mieszkanie.getId() + " i wszyscy mieszkancy " + mieszkanie.getMieszkancy() + " tez.");
        mieszkanie.getMieszkancy().clear();
        mieszkanie.setNajemca(null);
    }

    public synchronized void eksmisja(MiejsceParkingowe miejsceParkingowe) {
        boolean pojazdInList = false;
        for (Przedmiot przedmiot : miejsceParkingowe.getPrzedmioty()) {
            if (przedmiot instanceof Pojazd) {
                System.out.println(miejsceParkingowe.getNajemca().getImie() + ", zostales eksmitowany z " + miejsceParkingowe.getId() + " i twoje przedmioty:  " + przedmiot + " zostaly zlicytowane.");
                pojazdInList = true;
                miejsceParkingowe.getPrzedmioty().remove(przedmiot);
                Calendar twoMonthsFromLeaseEnd = Calendar.getInstance();
                twoMonthsFromLeaseEnd.setTime(miejsceParkingowe.getDataZakonczeniaNajmu());
                twoMonthsFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 60);
                miejsceParkingowe.setDataZakonczeniaNajmu(twoMonthsFromLeaseEnd.getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String newDate = sdf.format(miejsceParkingowe.getDataZakonczeniaNajmu());
                System.out.println("Nowa data zakonczenia najmu to: " + newDate);
            }
        }
        if (!pojazdInList) {
            System.out.println("usunieto przedmioty z " + miejsceParkingowe.getId());
            miejsceParkingowe.getPrzedmioty().clear();
        }
        miejsceParkingowe.setNajemca(null);
    }

    public synchronized void spoznionyCzynsz(Mieszkanie mieszkanie) {
        Pismo pismo = new Pismo(mieszkanie);
        mieszkanie.getNajemca().getPisma().add(pismo);
        System.out.println(pismo.getTrescPisma());

    }

    public synchronized void spoznionyCzynsz(MiejsceParkingowe miejsceParkingowe) {
        Pismo pismo = new Pismo(miejsceParkingowe);
        miejsceParkingowe.getNajemca().getPisma().add(pismo);
        System.out.println(pismo.getTrescPisma());
    }

    public synchronized boolean czyJestJuzPismo(Mieszkanie mieszkanie) {
        for (Pismo pismo : mieszkanie.getNajemca().pisma) {
            if (pismo.getDotyczyPomieszczenia().equals(mieszkanie.getId())) {
//                System.out.println("Juz jest pismo dla: " + mieszkanie.getId());
                return true;
            }
        }
        return false;
    }

    public synchronized boolean czyJestJuzPismo(MiejsceParkingowe miejsceParkingowe) {
        for (Pismo pismo : miejsceParkingowe.getNajemca().pisma) {
            if (pismo.getDotyczyPomieszczenia().equals(miejsceParkingowe.getId())) {
//                System.out.println("Juz jest pismo dla: " + miejsceParkingowe.getId());
                return true;
            }
        }
        return false;
    }
}
