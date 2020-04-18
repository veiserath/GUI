package com.company;


import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class DateMover extends Thread {

    Date currentDate;
    Calendar c;
    SimpleDateFormat sdf;
    List<Osiedle> listaWszystkichOsiedli;

    DateTimeFormatter formatter;
    public DateMover(List<Osiedle> listaWszystkichOsiedli) {

//        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        ZonedDateTime now = ZonedDateTime.now();
//        String formattedNow = now.format(formatter);
//        System.out.println("Dzieki nowym API data to: " + formattedNow);

        this.sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.listaWszystkichOsiedli = listaWszystkichOsiedli;
        this.c = Calendar.getInstance();
        this.c.set(Calendar.YEAR, 2020);
        this.c.set(Calendar.DAY_OF_YEAR, 107);
        Thread thread1 = new RentalValidity(this);
        thread1.start();

    }

    @Override
    public void run() {

        try {
            while (true) {
                c.add(Calendar.DAY_OF_MONTH, 1);
                String newDate = sdf.format(c.getTime());
                System.out.println("Tutaj zmieniamy: " + newDate);
                this.sleep(5000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
