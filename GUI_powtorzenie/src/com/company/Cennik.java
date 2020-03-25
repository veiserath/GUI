package com.company;

public class Cennik {

    Produkt produkty[] = new Produkt[3];
    private static Cennik uniqueInstance;

    private Cennik() {
        produkty[0] = new Produkt("jabłko", 3);
        produkty[1] = new Produkt("ananas", 4);
        produkty[2] = new Produkt("długopis", 2);
    }

    public static Cennik getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Cennik();
        }
        return uniqueInstance;
    }

    public void ileKosztuje(String nazwaProduktu) {
        int produktyLength = produkty.length;
        boolean productFound = false;
        for (int i = 0; i < produktyLength; i++) {
            if (produkty[i].nazwaProduktu.equals(nazwaProduktu)) {
                System.out.println(produkty[i].cenaProduktu);
                productFound = true;
            }
        }
        if (productFound == false)
        System.out.println("-1");
    }

    public void wyswietlCennik() {
        System.out.println("--- Cennik: ---");
        int produktyLength = produkty.length;
        for (int i = 0; i < produktyLength; i++) {
            System.out.println(produkty[i].nazwaProduktu + " - "+ produkty[i].cenaProduktu);
        }
        System.out.println("------------");
    }
}
