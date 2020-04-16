package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class RentalValidity extends Thread {

    Calendar calendar;
    List<Osiedle> osiedleList;
    SimpleDateFormat sdf;

    public RentalValidity(List<Osiedle> osiedleList) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.osiedleList = osiedleList;
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.DAY_OF_YEAR, 107);
        this.osiedleList = osiedleList;


    }

    @Override
    public void run() {
        Calendar oneMonthFromLeaseEnd = Calendar.getInstance();
        try {
            while (true) {
                for (Osiedle osiedle : osiedleList) {
                    for (Blok blok : osiedle.bloki) {
                        for (Mieszkanie mieszkanie : blok.mieszkania) {
                            oneMonthFromLeaseEnd.setTime(mieszkanie.dataZakonczeniaNajmu);
                            oneMonthFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 30);
                            if (mieszkanie.najemca != null && calendar.getTime().compareTo(mieszkanie.dataZakonczeniaNajmu) > 0 && !czyJestJuzPismo(mieszkanie)) {
                                spoznionyCzynsz(mieszkanie);
                                mieszkanie.zadluzone = true;
                                System.out.println("Spozniasz sie z czynszem!");
                            } else if (mieszkanie.najemca != null && calendar.getTime().compareTo(oneMonthFromLeaseEnd.getTime()) >= 0) {
                                eksmisja(mieszkanie);
                                mieszkanie.zadluzone = false;
                            }
                        }
                    }
                    for (MiejsceParkingowe miejsceParkingowe : osiedle.miejscaParkingowe) {
                        oneMonthFromLeaseEnd.setTime(miejsceParkingowe.dataZakonczeniaNajmu);
                        oneMonthFromLeaseEnd.add(Calendar.DAY_OF_MONTH, 30);
                        if (miejsceParkingowe.najemca != null && calendar.getTime().compareTo(miejsceParkingowe.dataZakonczeniaNajmu) > 0 && !czyJestJuzPismo(miejsceParkingowe)) {
                            spoznionyCzynsz(miejsceParkingowe);
                            miejsceParkingowe.zadluzone = true;
                            System.out.println("Spozniasz sie z czynszem!");
                        } else if (miejsceParkingowe.najemca != null && calendar.getTime().compareTo(oneMonthFromLeaseEnd.getTime()) >= 0) {
                            eksmisja(miejsceParkingowe);
                            miejsceParkingowe.zadluzone = false;
                        }
                    }
                }
                sleep(10000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eksmisja(Mieszkanie mieszkanie) {
        mieszkanie.mieszkancy.clear();
        mieszkanie.najemca = null;
        System.out.println("Zostales eksmitowany i wszyscy mieszkancy " + mieszkanie.id + " tez.");
    }

    public void eksmisja(MiejsceParkingowe miejsceParkingowe) {
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
                System.out.println("Zostales eksmitowany z miejsca garazowego i twoj pojazd  " + przedmiot + " tez.");
                System.out.println("Nowa data zakonczenia najmu to: " + newDate);
            }
        }
        if (!pojazdInList) {
            miejsceParkingowe.przedmioty.clear();
            System.out.println("usunieto przedmioty z " + miejsceParkingowe.id);
        }
        miejsceParkingowe.najemca = null;
    }

    public void spoznionyCzynsz(Mieszkanie mieszkanie) {
        File pismo = new File("Spozniasz sie z czynszem za mieszkanie: " + mieszkanie.id, mieszkanie.nazwaOsiedla);
        mieszkanie.najemca.pisma.add(pismo);
        System.out.println(pismo.trescPisma);

    }

    public void spoznionyCzynsz(MiejsceParkingowe miejsceParkingowe) {
        File pismo = new File("Spozniasz sie z czynszem za miejsce parkingowe: " + miejsceParkingowe.id, miejsceParkingowe.nazwaOsiedla);
        miejsceParkingowe.najemca.pisma.add(pismo);
        System.out.println(pismo.trescPisma);

    }

    public boolean czyJestJuzPismo(Mieszkanie mieszkanie) {
        for (File pismo : mieszkanie.najemca.pisma) {
            if (pismo.trescPisma.equals("Spozniasz sie z czynszem za mieszkanie: " + mieszkanie.id)) {
                System.out.println("Juz jest pismo " + mieszkanie.id);
                return true;
            }
        }
        return false;
    }

    public boolean czyJestJuzPismo(MiejsceParkingowe miejsceParkingowe) {
        for (File pismo : miejsceParkingowe.najemca.pisma) {
            if (pismo.trescPisma.equals("Spozniasz sie z czynszem za mieszkanie: " + miejsceParkingowe.id)) {
                System.out.println("Juz jest pismo dla: " + miejsceParkingowe.id);
                return true;
            }
        }
        return false;
    }

}
