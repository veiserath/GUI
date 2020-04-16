package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class DateMover extends Thread {

    Date currentDate;
    private Calendar c;
    SimpleDateFormat sdf;
    List<Osiedle> osiedleList;


    public DateMover(List<Osiedle> osiedleList) {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.osiedleList = osiedleList;
        c = Calendar.getInstance();

        c.set(Calendar.YEAR, 2020);
        c.set(Calendar.DAY_OF_YEAR, 107);

    }

    @Override
    public void run() {

        try {
            while (true) {
                c.add(Calendar.DAY_OF_MONTH, 1);
                String newDate = sdf.format(c.getTime());
//                System.out.println("Tutaj zmieniamy: " + newDate);
                this.sleep(5000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
