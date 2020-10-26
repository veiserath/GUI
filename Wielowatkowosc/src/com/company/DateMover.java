package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class DateMover extends Thread {

    Date currentDate;
    private Calendar c;
    SimpleDateFormat sdf;

    public DateMover(Date dataRozpoczeciaNajmu, SimpleDateFormat sdf) {


        this.sdf = sdf;
        this.currentDate = dataRozpoczeciaNajmu;
        c = Calendar.getInstance();
        c.setTime(dataRozpoczeciaNajmu);
        Thread thread1 = new RentalValidity(c,sdf);
        thread1.start();


    }


    @Override
    public void run() {

        try {
            while(true){
                c.add(Calendar.DAY_OF_MONTH,1);
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
