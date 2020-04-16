package com.company;


import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException, ProblematicTenantException {


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

        List<Osiedle> osiedleZielone = new LinkedList<>();
        List<Osiedle> osiedleCzerwone = new LinkedList<>();

        Mieszkanie pierwszeMieszkanie = new Mieszkanie("Osiedle zielone", "blok pierwszy", 10);
        Mieszkanie drugieMieszkanie = new Mieszkanie("Osiedle zielone", "blok drugi", 11);
        Mieszkanie trzecieMieszkanie = new Mieszkanie("Osiedle czerwone", "blok trzeci", 12);
        Mieszkanie czwarteMieszkanie = new Mieszkanie("Osiedle zielone", "blok drugi", 13);
        Mieszkanie piateMieszkanie = new Mieszkanie("Osiedle czerwone", "blok drugi", 14);
        Mieszkanie szosteMieszkanie = new Mieszkanie("Osiedle zielone", "blok drugi", 13);

        MiejsceParkingowe pierwszeMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 1);
        MiejsceParkingowe drugieMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 2);
        MiejsceParkingowe trzecieMiejsceParkingowe = new MiejsceParkingowe("Osiedle czerwone", 3);
        MiejsceParkingowe czwarteMiejsceParkingowe = new MiejsceParkingowe("Osiedle zielone", 4);
        MiejsceParkingowe piateMiejsceParkingowe = new MiejsceParkingowe("Osiedle czerwone", 5);

        Blok pierwszyBlok = new Blok("Osiedle zielone", "Blok pierwszy");
        pierwszyBlok.mieszkania.add(pierwszeMieszkanie);
        osiedleZielone.add(pierwszyBlok);

        osiedleZielone.add(pierwszeMieszkanie);
        osiedleZielone.add(drugieMieszkanie);
        osiedleZielone.add(czwarteMieszkanie);
        osiedleZielone.add(pierwszeMiejsceParkingowe);
        osiedleZielone.add(drugieMiejsceParkingowe);
        osiedleZielone.add(czwarteMiejsceParkingowe);

        osiedleCzerwone.add(trzecieMieszkanie);
        osiedleCzerwone.add(trzecieMiejsceParkingowe);
        osiedleCzerwone.add(piateMieszkanie);
        osiedleCzerwone.add(piateMiejsceParkingowe);

        SamochodMiejski samochodMiejski = new SamochodMiejski("Ford", 1, 300, "miejski", "diesel");
        SamochodMiejski samochodMiejski2 = new SamochodMiejski("Ford", 0.5, 300, "miejski", "diesel");


        Osoba kacper = new Osoba("Kacper", "Mlodkowski", "9504045674", "Kazimierza Gorskiego 4", "01.01.1995");
        Osoba michal = new Osoba("Michal", "Podgorski", "04040404040", "Kazimierza Wysokiego 5", "01.01.1965");
        Osoba stefan = new Osoba("Stefan", "Klodzki", "12345", "Kazimierza Gorskiego 345345", "01.01.1937");
        Osoba kamil = new Osoba("Kamil", "Winiarski", "444", "Zeromskiego 10", "01.01.1934");
        Osoba marek = new Osoba("Marek", "Goczal", "3333", "Michala Aniola 7", "01.01.1925");


        kacper.wynajmijMieszkanie("20-02-2020", "20-04-2020", pierwszeMieszkanie);
        kacper.wynajmijMieszkanie("20-02-2020", "20-04-2020", drugieMieszkanie);
        kacper.wynajmijMieszkanie("20-02-2020", "20-04-2020", trzecieMieszkanie);
        kacper.wynajmijMieszkanie("20-02-2020", "20-04-2020", czwarteMieszkanie);
//        kacper.wynajmijMieszkanie("20-02-2020", "20-04-2020",piateMieszkanie);
        kacper.wynajmijMiejsceParkingowe(pierwszeMiejsceParkingowe, "20-02-2020", "20-04-2020");
        michal.wynajmijMieszkanie("20-02-2020", "20-04-2020", pierwszeMieszkanie);
        kacper.odnowNajem(pierwszeMieszkanie, "27-03-2020");
        kacper.odnowNajem(pierwszeMiejsceParkingowe, "20-03-2020");
//        kacper.wymeldujLokatora(michal,pierwszeMieszkanie);
//        kacper.zameldujLokatora(michal,pierwszeMieszkanie);
//        kacper.zameldujLokatora(michal,pierwszeMieszkanie);
//        kacper.zameldujLokatora(michal,pierwszeMieszkanie);
//        kacper.zameldujLokatora(michal,pierwszeMieszkanie);
//        kacper.wypowiedzMieszkanie(piateMieszkanie);
//        kacper.wypowiedzMiejsceParkingowe(pierwszeMiejsceParkingowe);
        kacper.anulujNajem(pierwszeMieszkanie);
        kacper.anulujNajem(pierwszeMiejsceParkingowe);

        try {
            kacper.wlozPrzedmiot(pierwszeMiejsceParkingowe, samochodMiejski);
//            kacper.wlozPrzedmiot(czwarteMiejsceParkingowe,samochodMiejski2);
//            kacper.wyjmijPrzedmiot(pierwszeMiejsceParkingowe,samochodMiejski);
        } catch (TooManyThingsException e) {
            e.printStackTrace();
        }


        Thread thread = new DateMover(osiedleZielone);
        thread.start();
        Thread thread1 = new RentalValidity(osiedleZielone);
        thread1.start();
    }
}
