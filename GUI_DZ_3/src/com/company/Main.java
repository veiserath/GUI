package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<Square> kwadraty = new ArrayList<>();
//        try{
//            Square kwadrat1 = new Square(20);
//            Square kwadrat2 = new Square(30);
//            Square kwadrat3 = new Square(3);
//            Square kwadrat4 = new Square(15);
//            Square kwadrat5 = new Square(5);
//
//            kwadraty.add(kwadrat1);
//            kwadraty.add(kwadrat2);
//            kwadraty.add(kwadrat3);
//            kwadraty.add(kwadrat4);
//            kwadraty.add(kwadrat5);
//        }catch(TooBigSquareException e){
//            System.err.println("Maximum length is " + Figure.max);
//        }


//        System.out.println(kwadrat1);
//        System.out.println(kwadrat2);
//        System.out.println(kwadrat3);
//        System.out.println(kwadrat4);
//        System.out.println(kwadrat5);
//        System.out.println(kwadraty);
//        Collections.sort(kwadraty);
//        System.out.println(kwadraty);




        TelefonStacjonarny telefonStacjonarny = new TelefonStacjonarny("Siemens", 268.30);
        TelefonKomorkowy telefonKomorkowy = new TelefonKomorkowy("Sony Ericsson",599.60,false);
        KonsolaDoGier PS4 = new KonsolaDoGier("Sony", 1690,true);
        KonsolaDoGier Xbox = new KonsolaDoGier("Microsoft", 1499,false);
        Smartfon smartfon = new Smartfon("Apple",4990.60,false,true);

        telefonStacjonarny.callMe();

        try{
            telefonKomorkowy.callMe();
        } catch (NoSimcardException e){
            e.printStackTrace();
        }

        try{
            Xbox.surfTheNet();
        } catch (NoInternetException e){
            e.printStackTrace();
        }

        Urzadzenie urzadzenia[] = new Urzadzenie[5];
        urzadzenia[0] = telefonStacjonarny;
        urzadzenia[1] = telefonKomorkowy;
        urzadzenia[2] = PS4;
        urzadzenia[3] = Xbox;
        urzadzenia[4] = smartfon;

        Comparator<Urzadzenie> comparator = new Comparator<Urzadzenie>() {
            @Override
            public int compare(Urzadzenie urzadzenie, Urzadzenie other) {
                return Double.compare(urzadzenie.cena,other.cena);
            }
        };
        Arrays.sort(urzadzenia, comparator);
        for (int i = 0; i < urzadzenia.length; i++){
            System.out.println(urzadzenia[i]);
        }




    }
}
