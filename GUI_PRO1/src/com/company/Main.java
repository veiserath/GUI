package com.company;


import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, ProblematicTenantException, InterruptedException {


//        ZAPIS DO PLIKU:
//        Stan osób zamieszkujących osiedle wraz ze wszelkimi danymi dot. osoby, wynajmowanych pomieszczeń, przedmiotów, itp. musi być zapisywane po wybraniu z menu odpowiedniej funkcjo- nalności. Informacje zapisane w pliku powinny być zapisane przejrzyście i czytelnie dla człowieka z zachowaniem poniższych reguł:
//• Pomieszczenia powinny być posortowane rosnąco według rozmiaru pomieszczenia.
//• Zawartość pomieszczenia powinna być posortowana malejąco według rozmiaru przedmiotu jeśli jest taki sam to według nazwy.

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj numer PESEL osoby ktora chcesz byc lub wcisnij \"q\" aby zakonczyc program:");
        String input = scanner.nextLine();
        Osoba wybranaOsoba = determineOsoba(osoby,input);

        do{
            input = scanner.nextLine();
            System.out.println("(1)Wypisz dane osoby, lacznie z wynajetymi pomieszczeniami.");
            System.out.println("(2)Wyswietl wolne pomieszczenia.");
            System.out.println("(3)Wynajecie nowego pomieszczenia z listy wolnych.");
            System.out.println("(4)Wybranie pomieszczenia wynajmowanego i wyswietlenie jego zawartosci.");
            System.out.println("(5)Wlozenie nowych przedmiotow lub pojazdow.");
            System.out.println("(6)Wyjecie przedmiotow lub pojazdow");
            System.out.println("(7)Zapisz aktualny stan osiedla do pliku");
            System.out.println("Wcisnij \"q\" aby zakonczyc program:");

            switch(input){
                case "1":
                    System.out.println(wybranaOsoba);
                    break;
                case "2":
//                    tu moze jakas hashmapa
                    Osiedle.wyswietlWolnePomieszczenia(osiedla);
                case "3":
//                    zamknac to w funkcje
                    input = scanner.nextLine();
                    System.out.println("Podaj ID pomieszczenia do wynajecia");
                    if (input.charAt(3) == 'j'){
                        MiejsceParkingowe wybraneMiejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla,input);
                        System.out.println("Podaj date rozpoczecia najmu: ");
                        String dataRozpoczeciaNajmu = scanner.nextLine();
                        System.out.println("Podaj date zakonczenia najmu: ");
                        String dataZakonczeniaNajmu = scanner.nextLine();
                        wybranaOsoba.wynajmijMiejsceParkingowe(wybraneMiejsceParkingowe,dataRozpoczeciaNajmu,dataZakonczeniaNajmu);
                    }
                    else if (input.charAt(3) == 's'){
                        Mieszkanie wybraneMieszkanie = Osiedle.znajdzMieszkanie(osiedla,input);
                        System.out.println("Podaj date rozpoczecia najmu: ");
                        String dataRozpoczeciaNajmu = scanner.nextLine();
                        System.out.println("Podaj date zakonczenia najmu: ");
                        String dataZakonczeniaNajmu = scanner.nextLine();
                        wybranaOsoba.wynajmijMieszkanie(wybraneMieszkanie,dataRozpoczeciaNajmu,dataZakonczeniaNajmu);
                    }
                    else {
                        System.out.println("Niepoprawny numer ID");
                    }
                case "4":
                    input = scanner.nextLine();
                    System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wyswietlic jego zawartosc: ");
                    if (input.charAt(3) == 'j'){
                        MiejsceParkingowe wybraneMiejsceParkingowe = Osiedle.znajdzMiejsceParkingowe(osiedla,input);
                        System.out.println(wybraneMiejsceParkingowe.przedmioty);
                    }
                    else if (input.charAt(3) == 's'){
                        Mieszkanie wybraneMieszkanie = Osiedle.znajdzMieszkanie(osiedla,input);
                        System.out.println(wybraneMieszkanie.mieszkancy);
                    }
                case "5":
                    input = scanner.nextLine();
                    System.out.println("Wpisz ID wynajmowanego pomieszczenia aby wlozyc nowe przedmioty: ");



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
}
