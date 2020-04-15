package com.company;


import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, ProblematicTenantException {


        //lista osiedli

        //mechanizm uplywu czasu

//        metoda sprawdzajaca czas, ktory uplynal

        Najemca najemca = new Najemca("Kacper", "Mlodkowski", 950704438, "Lema 7", "01.01.1995");

        System.out.println(najemca.imie);
        System.out.println(najemca.nazwisko);

        Mieszkanie mieszkanie = new Mieszkanie(300);
        mieszkanie.wynajmij(najemca, "27-03-2020", "04-04-2020");

        MiejsceParkingowe miejsceParkingowe = new MiejsceParkingowe(200);
        miejsceParkingowe.wynajmij(najemca, "24-02-2020", "27-02-2020");

        Thread thread = new DateMover(mieszkanie);
        thread.start();

        Thread thread1 = new DateMover(miejsceParkingowe);
        thread1.start();
    }
}
