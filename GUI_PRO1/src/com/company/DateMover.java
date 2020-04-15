package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DateMover extends Thread {

    Date currentDate;
    private Calendar c;
    SimpleDateFormat sdf;
    Date dataRozpoczeciaNajmu;


    public DateMover(Mieszkanie mieszkanie) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.dataRozpoczeciaNajmu = mieszkanie.dataRozpoczeciaNajmu;
        c = Calendar.getInstance();
        c.setTime(this.dataRozpoczeciaNajmu);

        Thread thread1 = new RentalValidity(mieszkanie,c, sdf);
        thread1.start();
    }
    public DateMover(MiejsceParkingowe miejsceParkingowe) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.dataRozpoczeciaNajmu = miejsceParkingowe.dataRozpoczeciaNajmu;
        c = Calendar.getInstance();
        c.setTime(this.dataRozpoczeciaNajmu);

        Thread thread1 = new RentalValidity(miejsceParkingowe,c, sdf);
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

    public Calendar getC() {
        return c;
    }
}
