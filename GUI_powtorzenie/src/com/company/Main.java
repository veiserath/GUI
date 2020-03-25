package com.company;

public class Main {

    public static void main(String[] args) {
//        int oldTable[][] = {{1, 2, 3}, {2, 3, 0, 1}, {3, 2}};
//        int sortMe[] = {5,2,6,0,1,10,1,1,5,4,3};
        //Sortowanie.mergeSort(sortMe,sortMe.length);
        //Sortowanie.printTable(sortMe);


        //Pracownik pracownik = new Pracownik("Stefek", "Kowalski",1995, 6000);

        //Pracownik pracownik1 = new Pracownik("Michalek", "Kowalski",1995, 6000);
        //System.out.println(Pracownik.liczbaPracownikow);


        Cennik cennik = Cennik.getUniqueInstance();
        cennik.wyswietlCennik();
        Sklep sklep = new Sklep(cennik, 10500);
        System.out.println("Stworzono pracownikow " + Pracownik.ileStworzonych);
        Pracownik pracownik = new Pracownik("Anna", "Nowak", 1990, 1200);
        System.out.println("Powinna byc Anna Nowak: " + pracownik);
        System.out.println("Powinna byc jeden: " + Pracownik.ileStworzonych);
        try{
            sklep.zatrudnij(pracownik);
            sklep.zatrudnij("Jan", "Kowalski", 1982, 1200);
        } catch (UnderageException e){
         e.printStackTrace();
        }

        sklep.wyswietlPracownikow();
        sklep.wyplacPensje();
        sklep.zwiekszBudzet(1000);
        cennik.ileKosztuje("jabłko");
        cennik.ileKosztuje("kgakasdf");

    }

    public static void wyswietlZnaki(char first, char second) {
        if (first < second) {
            for (int i = first + 1; i < second; i++) {
                System.out.println((char) i);
            }
        }
        if (first > second) {
            for (int i = first - 1; i > second; i--) {
                System.out.println((char) i);
            }
        }

    }

    public static int ileNieparzystych(int someTable[]) {
        int iloscWystapien = 0;
        for (int i = 0; i < someTable.length; i++) {
            if (someTable[i] % 2 == 1) {
                iloscWystapien++;
            }
        }
        return iloscWystapien;
    }

    public static void odbicie(int someTable[][]) {

        int inverseIndex = 0;
        for (int i = 0; i < someTable.length; i++) {
            for (int j = 0; j < someTable[i].length/2; j++){
                inverseIndex = someTable[i].length - 1 - j;
                int tmp = someTable[i][j];
                someTable[i][j] = someTable[i][inverseIndex];
                someTable[i][inverseIndex] = tmp;
            }
        }

    }
    public static void printTable(int someTable[][]){
        for (int i = 0; i < someTable.length; i++){
            for (int j = 0; j < someTable[i].length; j++){
                System.out.print(someTable[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int sumaMniejszych(int liczbaNaturalna){
        if (liczbaNaturalna > 0){
            return liczbaNaturalna + sumaMniejszych(liczbaNaturalna-1);
        }
        else {
            return 0;
        }
    }
}
