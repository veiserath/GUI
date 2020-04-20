package com.company;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException, ProblematicTenantException, InterruptedException, TooManyThingsException {


//        MAIN:
//         W metodzie main należy utworzyć osiedle wraz z co najmniej dziesięcioma gotowymi po- mieszczeniami różnego typu i rozmiaru oraz kilka (minimum 5) gotowych osób.
//         Ze wstępnie przydzielonymi najmami oraz umiejscowionymi przedmiotami na miejscach parkingowych.


//        Poprawic menu, przetestowac caly program i ulepszyc opcje programistyczne.


        List<Osoba> osoby = new LinkedList<>();
        List<Osiedle> osiedla = new LinkedList<>();
        List<Przedmiot> przedmioty = new ArrayList<>();


        Osiedle osiedleZielone = new Osiedle("Osiedle zielone");
        Osiedle osiedleCzerwone = new Osiedle("Osiedle czerwone");

        Blok blokPierwszyZielone = new Blok("Osiedle zielone", "Blok Pierwszy");
        Blok blokDrugiZielone = new Blok("Osiedle zielone", "Blok Drugi");
        Blok blokPierwszyCzerwone = new Blok("Osiedle czerwone", "Blok Pierwszy");

        Osoba kacper = new Osoba("Kacper", "Mlodkowski", "95010107444", "Lema 7", "01.01.1995");
        Osoba michal = new Osoba("Michal", "Kowalski", "73735391970", "Krzywoustego 6", "02.04.1995");
        Osoba stefan = new Osoba("Stefan", "Cytrynowski", "99875525661", "Michala Aniola 3", "02.03.2000");
        Osoba marcin = new Osoba("Marcin", "Nowak", "39775509351", "Ikara 3", "01.06.1999");
        Osoba kamil = new Osoba("Kamil", "Winiarski", "73725942019", "Dedala 35", "09.03.1997");


        Mieszkanie pierwszeMieszkanie = new Mieszkanie("Osiedle zielone", "Blok pierwszy", 11);
        Mieszkanie drugieMieszkanie = new Mieszkanie("Osiedle zielone", "Blok pierwszy", 12);
        Mieszkanie trzecieMieszkanie = new Mieszkanie("Osiedle zielone", "Blok drugi", 13);
        Mieszkanie czwarteMieszkanie = new Mieszkanie("Osiedle czerwone", "Blok pierwszy", 14);
        Mieszkanie piateMieszkanie = new Mieszkanie("Osiedle czerwone", "Blok pierwszy", 15);

        MiejsceParkingowe pierwszeMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 1);
        MiejsceParkingowe drugieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 2);
        MiejsceParkingowe trzecieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 3);
        MiejsceParkingowe czwarteMiejsceParkingowe = new MiejsceParkingowe("Osiedle czerwone", 4);
        MiejsceParkingowe piateMiejsceParkingowe = new MiejsceParkingowe("Osiedle czerwone", 5);

        kacper.wynajmijMieszkanie(pierwszeMieszkanie, "27-03-2020", "26-04-2020");
        kacper.wynajmijMieszkanie(drugieMieszkanie, "27-01-2020", "26-08-2020");
        kacper.wynajmijMieszkanie(trzecieMieszkanie, "27-04-2020", "26-09-2020");
        kacper.zameldujLokatora(michal, pierwszeMieszkanie);
        kacper.zameldujLokatora(marcin, pierwszeMieszkanie);
        stefan.wynajmijMieszkanie(trzecieMieszkanie, "27-01-2019", "26-05-2020");
        kamil.wynajmijMieszkanie(czwarteMieszkanie, "27-02-2020", "30-10-2020");

        kacper.wynajmijMiejsceParkingowe(pierwszeMiejsceParkingowe, "27-03-2020", "26-06-2020");
        kacper.wynajmijMiejsceParkingowe(drugieMiejsceParkingowe, "27-01-2020", "26-08-2020");
        kacper.wynajmijMiejsceParkingowe(trzecieMiejsceParkingowe, "27-04-2020", "26-09-2020");
        marcin.wynajmijMiejsceParkingowe(czwarteMiejsceParkingowe, "27-12-2019", "11-11-2020");
        stefan.wynajmijMiejsceParkingowe(piateMiejsceParkingowe, "27-03-2018", "30-12-2020");

        SamochodMiejski samochodMiejski = new SamochodMiejski("Mercedes G", 0.5, 100, "miejski", "diesel");
        SamochodMiejski samochodMiejski2 = new SamochodMiejski("Aercedes G", 0.5, 100, "miejski", "diesel");
        kacper.wlozPrzedmiot(pierwszeMiejsceParkingowe, samochodMiejski);
        kacper.wlozPrzedmiot(pierwszeMiejsceParkingowe, samochodMiejski2);

        osiedleZielone.getBloki().add(blokPierwszyZielone);
        osiedleZielone.getBloki().add(blokDrugiZielone);
        osiedleCzerwone.getBloki().add(blokPierwszyCzerwone);

        blokPierwszyZielone.getMieszkania().add(pierwszeMieszkanie);
        blokPierwszyZielone.getMieszkania().add(drugieMieszkanie);
        blokDrugiZielone.getMieszkania().add(trzecieMieszkanie);
        blokPierwszyCzerwone.getMieszkania().add(czwarteMieszkanie);
        blokPierwszyCzerwone.getMieszkania().add(piateMieszkanie);

        osoby.add(kacper);
        osoby.add(michal);
        osoby.add(marcin);
        osoby.add(stefan);
        osoby.add(kamil);


        osiedla.add(osiedleZielone);
        osiedla.add(osiedleCzerwone);

        przedmioty.add(samochodMiejski);
        przedmioty.add(samochodMiejski2);

        Thread thread = new DateMover(osiedla);
        thread.start();

        userSelected(osoby, osiedla, przedmioty);
    }

    public static String MenuFirstLevel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer PESEL osoby ktora chcesz byc lub wcisnij \"q\" aby zakonczyc program.");
        System.out.println("Wprowadziles: ");
        String input = scanner.nextLine();
        return input;
    }

    public static Osoba whatPerson(List<Osoba> osoby, String input) {
        if (input.length() != 11) {
            System.out.println("Niepoprawny format PESEL");
            MenuFirstLevel();
        } else if (input.equals("q")) {
            System.out.println("Do widzenia!");
        } else {
            Osoba wybranaOsoba = determineOsoba(osoby, input);
            return wybranaOsoba;
        }
        return null;
    }

    public static String MenuSecondLevel(Osoba osoba) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jestes osoba: " + osoba.getImie() + " " + osoba.getNazwisko());
        System.out.println("(1) Wypisz dane osoby, lacznie z wynajetymi pomieszczeniami.");
        System.out.println("(2) Wyswietl wolne pomieszczenia.");
        System.out.println("(3) Wynajecie nowego pomieszczenia z listy wolnych.");
        System.out.println("(4) Wybranie pomieszczenia wynajmowanego i wyswietlenie jego zawartosci.");
        System.out.println("(5) Wlozenie nowych przedmiotow lub pojazdow.");
        System.out.println("(6) Wyjecie przedmiotow lub pojazdow");
        System.out.println("(7) Zapisz aktualny stan osiedla do pliku");
        System.out.println("Wcisnij \"q\" aby zakonczyc program:");
        System.out.println();
        System.out.println("Wprowadziles: ");
        String input = scanner.nextLine();
        return input;
    }

    public static void userSelected(List<Osoba> osoby, List<Osiedle> osiedla, List<Przedmiot> przedmioty) throws ParseException, ProblematicTenantException, TooManyThingsException {
        String firstLevelInput = MenuFirstLevel();
        Osoba wybranaOsoba = whatPerson(osoby, firstLevelInput);
        String secondLevelInput;
        secondLevelInput = MenuSecondLevel(wybranaOsoba);


        do {
            secondLevelInput = MenuSecondLevel(whatPerson(osoby, MenuFirstLevel()));
            switch (secondLevelInput) {
                case "1":
                    daneOsoby(wybranaOsoba);
                    break;
                case "2":
//                    tu moze hashmapa
                    Osiedle.wyswietlWolnePomieszczenia(osiedla);
                    break;
                case "3":
                    Osiedle.wyswietlWolnePomieszczenia(osiedla);
                    wynajmijPomieszczenie(osiedla, wybranaOsoba);
                    break;
                case "4":
                    daneOsoby(wybranaOsoba);
                    wyswietlZawartoscPomieszczenia(osiedla);
                    break;
                case "5":
                    wlozNowyPrzedmiot(osiedla, przedmioty, wybranaOsoba);
                    break;
                case "6":
                    wyjmijPrzedmiot(osiedla, przedmioty, wybranaOsoba);
                    break;
                case "7":
                    saveToFile(osoby);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        } while (!secondLevelInput.equals("q"));
        System.out.println("Do widzenia!");
    }

    public static Osoba determineOsoba(List<Osoba> osoby, String input) {
        for (Osoba osoba : osoby) {
            if (input.equals(osoba.getPESEL())) {
                return osoba;
            } else {
                System.out.println("Nie ma osoby o podanym PESEL-u.");
            }
        }
        return null;
    }

    public static void saveToFile(List<Osoba> osoby) {
        StringBuilder sb = new StringBuilder();

        sb.append("Osoby: \n");


        for (Osoba osoba : osoby) {

            Collections.sort(osoba.getMieszkania());
            sb.append("Osoba: " + osoba.getImie() + " " + osoba.getNazwisko() + "\n");
            sb.append("Posiada mieszkania: \n");
            sb.append(osoba.getMieszkania() + "\n");
            for (MiejsceParkingowe miejsceParkingowe : osoba.miejscaParkingowe) {
                miejsceParkingowe.sortPrzedmioty();
            }
            sb.append("Posiada miejsca parkingowe: \n");
            sb.append(osoba.getMiejscaParkingowe());
        }
        System.out.println(sb.toString());
        File file = new File("StanOsiedla.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void daneOsoby(Osoba osoba) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(osoba.getMieszkania());
        sb.append("Osoba: " + osoba.getImie() + " " + osoba.getNazwisko() + "\n");
        sb.append("Posiada mieszkania: \n");
        sb.append(osoba.getMieszkania() + "\n");
        for (MiejsceParkingowe miejsceParkingowe : osoba.miejscaParkingowe) {
            miejsceParkingowe.sortPrzedmioty();
        }
        sb.append("Posiada miejsca parkingowe: \n");
        sb.append(osoba.getMiejscaParkingowe());
        System.out.println(sb.toString());
    }

    public static void wynajmijPomieszczenie(List<Osiedle> osiedla, Osoba wybranaOsoba) throws ParseException, ProblematicTenantException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID pomieszczenia do wynajecia");
        String input = scanner.nextLine();
//        sprytniejszy sposob na ogarnianie tego
        if (input.charAt(3) == 'j') {
            MiejsceParkingowe wybraneMiejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, input);
            System.out.println("Podaj date rozpoczecia najmu: ");
            String dataRozpoczeciaNajmu = scanner.nextLine();
            System.out.println("Podaj date zakonczenia najmu: ");
            String dataZakonczeniaNajmu = scanner.nextLine();
            wybranaOsoba.wynajmijMiejsceParkingowe(wybraneMiejsceParkingowe, dataRozpoczeciaNajmu, dataZakonczeniaNajmu);
        } else if (input.charAt(3) == 's') {
            Mieszkanie wybraneMieszkanie = Osiedle.znajdzMieszkanie(osiedla, input);
            System.out.println("Podaj date rozpoczecia najmu: ");
            String dataRozpoczeciaNajmu = scanner.nextLine();
            System.out.println("Podaj date zakonczenia najmu: ");
            String dataZakonczeniaNajmu = scanner.nextLine();
            wybranaOsoba.wynajmijMieszkanie(wybraneMieszkanie, dataRozpoczeciaNajmu, dataZakonczeniaNajmu);
        } else {
            System.out.println("Niepoprawny numer ID");
        }
    }

    public static void wyswietlZawartoscPomieszczenia(List<Osiedle> osiedla) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wyswietlic jego zawartosc: ");
        String input = scanner.nextLine();
        if (input.charAt(3) == 'j') {
            MiejsceParkingowe wybraneMiejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, input);
            System.out.println(wybraneMiejsceParkingowe.getPrzedmioty());
        } else if (input.charAt(3) == 's') {
            Mieszkanie wybraneMieszkanie = Osiedle.znajdzMieszkanie(osiedla, input);
            System.out.println(wybraneMieszkanie.getMieszkancy());
        }
    }

    public static void wlozNowyPrzedmiot(List<Osiedle> osiedla, List<Przedmiot> przedmioty, Osoba wybranaOsoba) throws TooManyThingsException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wlozyc nowy przedmiot: ");
        String input = scanner.nextLine();
        MiejsceParkingowe miejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, input);
        System.out.println("Co chcialbys tam wlozyc? Podaj nazwe przedmiotu do wlozenia: ");
        Przedmiot przedmiotDoWlozenia = null;
        input = scanner.nextLine();
        for (Przedmiot przedmiot : przedmioty) {
            if (przedmiot.getNazwa().equals(input)) {
                przedmiotDoWlozenia = przedmiot;
            }
        }
        wybranaOsoba.wlozPrzedmiot(miejsceParkingowe, przedmiotDoWlozenia);
    }

    public static void wyjmijPrzedmiot(List<Osiedle> osiedla, List<Przedmiot> przedmioty, Osoba wybranaOsoba) throws TooManyThingsException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wyjac przedmiot: ");
        String input = scanner.nextLine();
        MiejsceParkingowe miejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, input);
        System.out.println("Obecnie znajduja sie tu nastepujace przedmioty: ");
        System.out.println(miejsceParkingowe.getPrzedmioty());
        System.out.println();
        System.out.println("Co chcialbys wyjac? Podaj nazwe przedmiotu do wyjecia: ");
        input = scanner.nextLine();
        for (Przedmiot przedmiot : miejsceParkingowe.getPrzedmioty()) {
            if (przedmiot.getNazwa().equals(input)) {
                wybranaOsoba.wyjmijPrzedmiot(miejsceParkingowe, przedmiot);
            }
        }
    }
}
