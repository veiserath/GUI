package com.company;


import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException, ProblematicTenantException, InterruptedException {


//          ZAPIS DO PLIKU:
//          Stan osób zamieszkujących osiedle wraz ze wszelkimi danymi dot. osoby, wynajmowanych pomieszczeń, przedmiotów, itp. musi być zapisywane po wybraniu z menu odpowiedniej funkcjo- nalności.
//          Informacje zapisane w pliku powinny być zapisane przejrzyście i czytelnie dla człowieka z zachowaniem poniższych reguł:
//          Pomieszczenia powinny być posortowane rosnąco według rozmiaru pomieszczenia.
//          Zawartość pomieszczenia powinna być posortowana malejąco według rozmiaru przedmiotu jeśli jest taki sam to według nazwy.

//        MAIN:
//         W metodzie main należy utworzyć osiedle wraz z co najmniej dziesięcioma gotowymi po- mieszczeniami różnego typu i rozmiaru oraz kilka (minimum 5) gotowych osób.
//         Ze wstępnie przydzielonymi najmami oraz umiejscowionymi przedmiotami na miejscach parkingowych.

//        MENU:
//        • Po uruchomieniu programu, użytkownik powinien mieć możliwość za pośrednictwem kon- soli poleceń wywołania wszystkich wspomnianych funkcjonalności. Są to m.in:
//– zakończenia programu w dowolnym momencie
//– wybrania którą jest osobą (nie jest potrzebne żadne logowanie, wystarczy wskazanie
//        np. unikalnego numeru osoby)
//– wypisania swoich danych łącznie z wynajętymi pomieszczeniami
//– wyświetlenia wolnych pomieszczeń
//– wynajęcia nowego pomieszczenia, po uprzednim jego wybraniu
//– wybrania pomieszczenia które wynajmuje dana osoba oraz wyświetlenia zawartości pomieszczenia
//– włożenia nowych pojazdów/przedmiotów pamiętając, aby nie przepełnić pomieszcze- nia
//– wyjęcia przedmiotów lub pojazdów.
//– wykonania polecenia zapisującego aktualny stan osiedla do pliku

        List<Osoba> osoby = new LinkedList<>();
        List<Osiedle> osiedla = new LinkedList<>();
        Osiedle osiedleZielone = new Osiedle("Osiedle zielone");

        Osoba kacper = new Osoba("Kacper", "Mlodkowski", "95010107438", "Lema 7", "01.01.1995");
        osoby.add(kacper);

        Mieszkanie pierwszeMieszkanie = new Mieszkanie("Osiedle zielone", "Blok pierwszy", 300);
        Mieszkanie drugieMieszkanie = new Mieszkanie("Osiedle zielone", "Blok pierwszy", 4);
        Mieszkanie trzecieMieszkanie = new Mieszkanie("Osiedle zielone", "Blok pierwszy", 2);

        osiedleZielone.bloki.add(pierwszeMieszkanie);
        osiedleZielone.bloki.add(drugieMieszkanie);
        osiedleZielone.bloki.add(trzecieMieszkanie);

        kacper.wynajmijMieszkanie(pierwszeMieszkanie, "27-03-2020", "26-06-2020");
        kacper.wynajmijMieszkanie(drugieMieszkanie, "27-01-2020", "26-08-2020");
        kacper.wynajmijMieszkanie(trzecieMieszkanie, "27-04-2020", "26-09-2020");

        MiejsceParkingowe pierwszeMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 3);
        MiejsceParkingowe drugieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 5);
        MiejsceParkingowe trzecieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 300);

        kacper.wynajmijMiejsceParkingowe(pierwszeMiejsceParkingowe, "27-03-2020", "26-06-2020");
        kacper.wynajmijMiejsceParkingowe(pierwszeMiejsceParkingowe, "27-01-2020", "26-08-2020");
        kacper.wynajmijMiejsceParkingowe(pierwszeMiejsceParkingowe, "27-04-2020", "26-09-2020");


        saveToFile(osoby);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj numer PESEL osoby ktora chcesz byc lub wcisnij \"q\" aby zakonczyc program:");
        String input = scanner.nextLine();
        Osoba wybranaOsoba = determineOsoba(osoby, input);

        do {
            input = scanner.nextLine();
            System.out.println("(1)Wypisz dane osoby, lacznie z wynajetymi pomieszczeniami.");
            System.out.println("(2)Wyswietl wolne pomieszczenia.");
            System.out.println("(3)Wynajecie nowego pomieszczenia z listy wolnych.");
            System.out.println("(4)Wybranie pomieszczenia wynajmowanego i wyswietlenie jego zawartosci.");
            System.out.println("(5)Wlozenie nowych przedmiotow lub pojazdow.");
            System.out.println("(6)Wyjecie przedmiotow lub pojazdow");
            System.out.println("(7)Zapisz aktualny stan osiedla do pliku");
            System.out.println("Wcisnij \"q\" aby zakonczyc program:");

            switch (input) {
                case "1":
                    System.out.println(wybranaOsoba);
                    break;
                case "2":
//                    tu moze jakas hashmapa
                    Osiedle.wyswietlWolnePomieszczenia(osiedla);
                    break;
                case "3":
//                    zamknac to w funkcje
                    input = scanner.nextLine();
                    System.out.println("Podaj ID pomieszczenia do wynajecia");
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
                    break;
                case "4":
                    input = scanner.nextLine();
                    System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wyswietlic jego zawartosc: ");
                    if (input.charAt(3) == 'j') {
                        MiejsceParkingowe wybraneMiejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, input);
                        System.out.println(wybraneMiejsceParkingowe.przedmioty);
                    } else if (input.charAt(3) == 's') {
                        Mieszkanie wybraneMieszkanie = Osiedle.znajdzMieszkanie(osiedla, input);
                        System.out.println(wybraneMieszkanie.mieszkancy);
                    }
                    break;
                case "5":
                    input = scanner.nextLine();
                    System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wlozyc nowe przedmioty: ");
                    MiejsceParkingowe miejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla, input);
                    System.out.println("Co chcialbys tam wlozyc?");
                    System.out.println("(1) Motocykl");
                    System.out.println("(2) Samochod Terenowy");
                    System.out.println("(3) Samochod Miejski");
                    System.out.println("(4) Przedmiot");
                    System.out.println("(5) Lodz");
                    System.out.println("(6) Amfibia");
                    input = scanner.nextLine();
//                    rozcase'owac tworzenie i wkladanie nowego obiektu
                    break;
                case "6":
                    System.out.println("Jaki przedmiot z listy chcialbys wyjac: ");
//                    ogarnac to
                case "7":


            }
        } while (input != "q");
    }

    public static Osoba determineOsoba(List<Osoba> osoby, String input) {
        for (Osoba osoba : osoby) {
            if (input.equals(osoba.PESEL)) {
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
            System.out.println("Osoba: " + osoba.getImie() + " " + osoba.getNazwisko());
            System.out.println("Posiada mieszkania: " + osoba.getMieszkania());

        for (Osoba osoba1 : osoby){
            Collections.sort(osoba1.getMiejscaParkingowe());
            for (MiejsceParkingowe miejsceParkingowe : osoba1.getMiejscaParkingowe()){
                Collections.sort(miejsceParkingowe.getPrzedmioty(), Collections.reverseOrder());
                System.out.println("Posiada miejsca parkingowe: " + miejsceParkingowe.getPrzedmioty());
            }
        }
//            Collections.sort(osoba.getMiejscaParkingowe());
//            sb.append("Osoba: " + osoba + "posiada: \n");
//            sb.append("Mieszkania: " + osoba.getMieszkania())
//            for (MiejsceParkingowe miejsceParkingowe : osoba.getMiejscaParkingowe()) {
//                Collections.sort(miejsceParkingowe.getPrzedmioty(), Collections.reverseOrder());
//            }

        }

    }
}
