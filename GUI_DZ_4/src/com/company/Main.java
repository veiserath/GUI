package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Osoba kowalski = new Osoba("Jan", "Kowalski");
        Osoba nowak = new Osoba("Adam", "Nowak");
        Osoba krawczyk = new Osoba("Bartosz", "Krawczyk");
        Osoba heniek = new Osoba("Kierownik", "Heniek");

        Samochod skoda1 = new Samochod("WA00001", Samochod.Marka.Skoda);
        Samochod skoda2 = new Samochod("SC36010", Samochod.Marka.Skoda);
        Samochod mazda1 = new Samochod("WA01234", Samochod.Marka.Mazda);
        Samochod mazda2 = new Samochod("DW01ASD", Samochod.Marka.Mazda);
        Samochod bmw = new Samochod("WA12690", Samochod.Marka.BMW);
        Samochod volvo = new Samochod("KR60606", Samochod.Marka.Volvo);

        Map<Osoba, List<Samochod>> mapaSamochodow = new HashMap<>();
        mapaSamochodow.put(kowalski, new LinkedList<Samochod>(Arrays.asList(skoda1, bmw)));
        mapaSamochodow.put(nowak, new LinkedList<Samochod>(Arrays.asList(mazda2)));
        mapaSamochodow.put(krawczyk, new LinkedList<Samochod>(Arrays.asList(volvo, mazda1, skoda2)));
        mapaSamochodow.put(heniek, new LinkedList<Samochod>());


        for (Entry<Osoba, List<Samochod>> m : mapaSamochodow.entrySet()) {
            if (m.getValue().isEmpty()) {
                System.out.println(m.getKey() + "-> [Brak samochodów]");
            } else {
                System.out.println(m.getKey() + "->" + m.getValue());

            }

        }
        System.out.println("\nSamochody, ktorych numery rejestracyjne zaczynaja sie na WA: ");
        for (Entry<Osoba, List<Samochod>> m : mapaSamochodow.entrySet()) {
            for (int j = 0; j < m.getValue().size(); j++) {
                if (m.getValue().get(j).rejestracja.charAt(0) == 'W' && m.getValue().get(j).rejestracja.charAt(1) == 'A') {
                    System.out.println(m.getValue().get(j).marka + " " + m.getValue().get(j).rejestracja);
                }
            }

        }
        System.out.println();
        for (Entry<Osoba, List<Samochod>> m : mapaSamochodow.entrySet()) {
            System.out.println(m.getKey() + " posiada " + m.getValue().size() + " pojazdy");


        }
        System.out.println("\n" + mapaSamochodow.get(nowak).get(0));


        System.out.println("\nZadanie 2: ");
        String[] arr
                = {
                "office A", "John", "Doe", "office B", "John", "Brown", "office C", "Mary", "Jones", "office B", "Adam", "Rust", "office C", "Cindy", "Frost", "office A", "Kate", "Coe", "office A", "Bill", "Brown"
        };
        Map<String, List<Person>> mapaFirmy = new HashMap<>();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i += 3) {
            String firma = arr[i];
            String imie = arr[i + 1];
            String nazwisko = arr[i + 2];
            mapaFirmy.putIfAbsent(firma, new LinkedList<Person>());
            mapaFirmy.get(arr[i]).add(new Person(imie, nazwisko));

        }
        System.out.println(mapaFirmy);
        String key = "";
        int max = 0;
        for (Entry<String, List<Person>> m : mapaFirmy.entrySet()) {
            int currentValue = m.getValue().size();
            if (max < currentValue) {
                key = m.getKey();
                max = currentValue;
            }


        }
        System.out.println(key + ": " + max + " users\n");




    }
}
