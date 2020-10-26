package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RentalValidity extends Thread {

    Calendar c;
    SimpleDateFormat sdf;
    public RentalValidity(Calendar c, SimpleDateFormat sdf) {
        this.c = c;
        this.sdf = sdf;
    }

    @Override
    public void run() {

        try {
            while (true){
                String newDate = sdf.format(c.getTime());
                System.out.println("A tu cyk wjezdza weryfikacja: " + newDate);
                sleep(10000);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
