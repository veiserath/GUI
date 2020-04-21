package com.company;


import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

public class DateMover extends Thread {

    Calendar c;
    SimpleDateFormat sdf;
    List<Osiedle> osiedla;

    public DateMover(List<Osiedle> osiedla) {


        this.sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.osiedla = osiedla;
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
//                String newDate = sdf.format(c.getTime());
//                System.out.println("Tutaj zmieniamy: " + newDate);
                Thread.sleep(5000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void addOneDay(){
        c.add(Calendar.DAY_OF_MONTH, 1);
    }


}
