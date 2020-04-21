package com.company;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        Mieszkanie piateMieszkanie = new Mieszkanie("Osiedle czerwone", "Blok pierwszy", 3, 5, 1);

        MiejsceParkingowe pierwszeMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 1);
        MiejsceParkingowe drugieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 2);
        MiejsceParkingowe trzecieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 3);
        MiejsceParkingowe czwarteMiejsceParkingowe = new MiejsceParkingowe("Osiedle czerwone", 4);
        MiejsceParkingowe piateMiejsceParkingowe = new MiejsceParkingowe("Osiedle czerwone", 5);

        kacper.wynajmijMieszkanie(pierwszeMieszkanie, "27-03-2020", "26-06-2020");
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

        SamochodMiejski samochodMiejski = new SamochodMiejski("Mercedes", 0.5, 100, "miejski", "benzyna",
                () -> {
                    System.out.println("brum brum - jestem eko!");
                });
        SamochodTerenowy samochodTerenowy = new SamochodTerenowy("Jeep", 0.5, 100, "terenowy", "diesel",
                () -> {
                    System.out.println("pyr pyr pyr - leci sadza!");
                });

        kacper.wlozPrzedmiot(pierwszeMiejsceParkingowe, samochodMiejski);
        kacper.wlozPrzedmiot(pierwszeMiejsceParkingowe, samochodTerenowy);

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
        przedmioty.add(samochodTerenowy);

        Thread thread = new DateMover(osiedla);
        thread.start();
        Lodz lodz = new Lodz("lodz", 3, 300, "Lodz", "benzyna",
                () -> {
                    System.out.println("plum plum!");
                });
        lodz.silnik.sprawdzSilnik();
        przedmioty.add(lodz);
        samochodMiejski.wsiadz(kacper);
        samochodMiejski.silnik.sprawdzSilnik();
        samochodTerenowy.silnik.sprawdzSilnik();


        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        MenuSecondLevel(osoby, osiedla, przedmioty, MenuFirstLevel());


    }

    public static String MenuFirstLevel() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("Podaj numer PESEL osoby ktora chcesz byc lub wcisnij \"q\" aby zakonczyc program.");
            System.out.println("Wprowadziles: ");
            input = scanner.nextLine();
            return input;
        } while (input != "q");
    }


    public static void MenuSecondLevel(List<Osoba> osoby, List<Osiedle> osiedla, List<Przedmiot> przedmioty, String firstLevelInput) throws ParseException, ProblematicTenantException, TooManyThingsException {
        Osoba wybranaOsoba = determineOsoba(osoby, firstLevelInput);
        String secondLevelInput;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Jestes osoba: " + wybranaOsoba.getImie() + " " + wybranaOsoba.getNazwisko());
            System.out.println("(1) Wypisz dane osoby, lacznie z wynajetymi pomieszczeniami.");
            System.out.println("(2) Wyswietl wolne pomieszczenia.");
            System.out.println("(3) Wynajecie nowego pomieszczenia z listy wolnych.");
            System.out.println("(4) Wybranie pomieszczenia wynajmowanego i wyswietlenie jego zawartosci.");
            System.out.println("(5) Wlozenie nowych przedmiotow lub pojazdow.");
            System.out.println("(6) Wyjecie przedmiotow lub pojazdow");
            System.out.println("(7) Zapisz aktualny stan osiedla do pliku");
            System.out.println("(8) Zamelduj lokatora");
            System.out.println("(9) Wymelduj lokatora");
            System.out.println("(10) Anuluj najem mieszkania:");
            System.out.println("(11) Odnow najem mieszkania:");
            System.out.println("(12) Anuluj najem miejsca parkingowego:");
            System.out.println("(13) Odnow najem miejsca parkingowego:");
            System.out.println("Wcisnij \"q\" aby zakonczyc program:");
            System.out.println();
            System.out.println("Wprowadziles: ");
            secondLevelInput = scanner.nextLine();

            switch (secondLevelInput) {
                case "1":
                    daneOsoby(wybranaOsoba);
                    System.out.println();
                    break;
                case "2":
//                    tu moze hashmapa
                    Osiedle.wyswietlWolnePomieszczenia(osiedla);
                    System.out.println();
                    break;
                case "3":
                    Osiedle.wyswietlWolnePomieszczenia(osiedla);
                    wynajmijPomieszczenie(osiedla, wybranaOsoba);
                    System.out.println();
                    break;
                case "4":
                    daneOsoby(wybranaOsoba);
                    wyswietlZawartoscPomieszczenia(osiedla);
                    System.out.println();
                    break;
                case "5":
                    daneOsoby(wybranaOsoba);
                    wlozNowyPrzedmiot(osiedla, przedmioty, wybranaOsoba);
                    System.out.println();
                    break;
                case "6":
                    daneOsoby(wybranaOsoba);
                    wyjmijPrzedmiot(osiedla, przedmioty, wybranaOsoba);
                    System.out.println();
                    break;
                case "7":
                    saveToFile(osoby);
                    System.out.println();
                    break;
                case "8":
                    daneOsoby(wybranaOsoba);
                    System.out.println("Podaj PESEL lokatora do zameldowania:");
                    String PESEL = scanner.nextLine();
                    Osoba osoba = determineOsoba(osoby, PESEL);
                    System.out.println("Podaj id Mieszkania gdzie go zameldowac:");
                    String idMieszkania = scanner.nextLine();
                    Mieszkanie mieszkanie = Osiedle.znajdzMieszkanie(osiedla, idMieszkania);
                    wybranaOsoba.zameldujLokatora(osoba, mieszkanie);
                    break;
                case "9":
                    daneOsoby(wybranaOsoba);
                    System.out.println("Podaj PESEL lokatora do wymeldowania:");
                    PESEL = scanner.nextLine();
                    osoba = determineOsoba(osoby, PESEL);
                    System.out.println("Podaj id Mieszkania skad go wymeldowac:");
                    idMieszkania = scanner.nextLine();
                    mieszkanie = Osiedle.znajdzMieszkanie(osiedla, idMieszkania);
                    wybranaOsoba.wymeldujLokatora(osoba, mieszkanie);
                    break;
                case "10":
                    daneOsoby(wybranaOsoba);
                    System.out.println("Podaj ID mieszkania do anulowania najmu:");
                    idMieszkania = scanner.nextLine();
                    mieszkanie = Osiedle.znajdzMieszkanie(osiedla, idMieszkania);
                    wybranaOsoba.wypowiedzMieszkanie(mieszkanie);
                    break;
                case "11":
                    daneOsoby(wybranaOsoba);
                    System.out.println("Podaj ID mieszkania do przedluzenia najmu:");
                    idMieszkania = scanner.nextLine();
                    System.out.println("Do kiedy chcesz je przedluzyc: ");
                    String doKiedy = scanner.nextLine();
                    mieszkanie = Osiedle.znajdzMieszkanie(osiedla, idMieszkania);
                    wybranaOsoba.odnowNajem(mieszkanie, doKiedy);
                    break;
                case "12":
                    daneOsoby(wybranaOsoba);
                    System.out.println("Podaj ID Miejsca Parkingowego do anulowania najmu:");
                    String idMiejscaParkingowego = scanner.nextLine();
                    MiejsceParkingowe miejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, idMiejscaParkingowego);
                    wybranaOsoba.wypowiedzMiejsceParkingowe(miejsceParkingowe);
                    break;
                case "13":
                    daneOsoby(wybranaOsoba);
                    System.out.println("Podaj ID Miejsca Parkingowego do przedluzenia najmu:");
                    idMiejscaParkingowego = scanner.nextLine();
                    System.out.println("Do kiedy chcesz je przedluzyc: ");
                    doKiedy = scanner.nextLine();
                    miejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, idMiejscaParkingowego);
                    wybranaOsoba.odnowNajem(miejsceParkingowe, doKiedy);
                    break;
//                case "14":
//                    System.out.println("Podaj ID Miejsca Parkingowe do wyswietlenia zawartosci: ");

                case "q":
                    System.out.println("Do widzenia!");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.");
            }
        } while (secondLevelInput != "q");
        System.out.println("Do widzenia!");

    }

    public static Osoba determineOsoba(List<Osoba> osoby, String input) {
        for (Osoba osoba : osoby) {
            if (input.equals(osoba.getPESEL())) {
                return osoba;
            }
        }
        System.out.println("Nie ma osoby o podanym PESEL-u.");
        return null;

    }

    public static void saveToFile(List<Osoba> osoby) {
        StringBuilder sb = new StringBuilder();

        sb.append("Osoby: \n");


        for (Osoba osoba : osoby) {

            Collections.sort(osoba.getMieszkania());
            sb.append("\nOsoba: " + osoba.getImie() + " " + osoba.getNazwisko() + "\n");
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
        input = scanner.nextLine();
        Przedmiot przedmiotDoWlozenia = null;
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
