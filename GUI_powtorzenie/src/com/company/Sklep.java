package com.company;

public class Sklep {

    Pracownik pracownicy[] = new Pracownik[5];
    double budzet;
    Cennik cennik;


    Sklep(Cennik cennik, double budzet) {
        this.cennik = cennik;
        this.budzet = budzet;
    }

    public void zatrudnij(Pracownik pracownik) throws UnderageException {
        if (2020 - pracownik.rokUrodzenia < 18) {
            throw new UnderageException();
        } else {
            if (Pracownik.ileStworzonych < 5) {
                pracownicy[Pracownik.ileStworzonych - 1] = pracownik;
            } else {
                System.out.println("Osiagnieto limit pracownikow!");
            }
        }

    }

    public void zatrudnij(String imie, String nazwisko, int rokUrodzenia, int pensja) throws UnderageException {
        if (2020 - rokUrodzenia < 18) {
            throw new UnderageException();
        } else {
            Pracownik pracownik = new Pracownik(imie, nazwisko, rokUrodzenia, pensja);

            if (Pracownik.ileStworzonych < pracownicy.length) {
                pracownicy[Pracownik.ileStworzonych - 1] = pracownik;
            } else {
                System.out.println("Osiagnieto limit pracownikow!");
            }
        }

    }

    public void wyplacPensje() {

        for (int i = 0; i < Pracownik.ileStworzonych; i++) {
            this.budzet -= pracownicy[i].pensja;
        }
        System.out.println("Stan budzetu po wyplaceniu pensji: " + this.budzet);

    }

    public void zwiekszBudzet(double zasilenieBudzetu) {
        if (zasilenieBudzetu < 0) {
            System.out.println("Nie mozna zasilic budzetu ujemna kwota!");
        } else {
            this.budzet += zasilenieBudzetu;
            System.out.println("Teraz budzet wynosi: " + this.budzet);
        }

    }

    public void wyswietlPracownikow() {
        System.out.println("----- Lista pracownikow: -----");
        for (int i = 0; i < Pracownik.ileStworzonych; i++) {
            System.out.println(pracownicy[i]);
        }
        System.out.println("--------------------------");
    }
}
