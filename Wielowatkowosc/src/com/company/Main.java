package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws ParseException {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dataRozpoczeciaNajmu = simpleDateFormat.parse("21-03-2019");
        Date dataZakonczeniaNajmu = simpleDateFormat.parse("20-05-2019");
        System.out.println("The date 1 is: " + simpleDateFormat.format(dataRozpoczeciaNajmu));
        System.out.println("The date 2 is: " + simpleDateFormat.format(dataZakonczeniaNajmu));
//        if (dataRozpoczeciaNajmu.compareTo(dataZakonczeniaNajmu) > 0){
//            System.out.println("Data rozpoczecia najmu nastepuje sie po dacie zakonczenia najmu");
//        }
//        if (dataRozpoczeciaNajmu.compareTo(dataZakonczeniaNajmu) < 0){
//            System.out.println("Data rozpoczecia najmu nastepuje przed data zakonczenia najmu");
//        }
//        if (dataRozpoczeciaNajmu.compareTo(dataZakonczeniaNajmu) == 0){
//            System.out.println("Daty sa identyczne");
//        }

        Thread thread = new DateMover(dataRozpoczeciaNajmu,simpleDateFormat);
        thread.start();

        Osoba osoba = new Osoba("Twoj stary",5);
        Mieszkanie mieszkanie = new Mieszkanie();
        mieszkanie.najemca = osoba;

        osoba.czyUdane(mieszkanie);


    }

}
