package com.company;

public class Samochod {
    enum Marka {
        Ford, MercedesBenz, Audi, Porsche, Skoda, Volkswagen, Toyota, Citroen, Mazda, Volvo, BMW
    }
    Marka marka;

    String rejestracja;

    public Samochod(String rejestracja, Marka marka) {
        this.rejestracja = rejestracja;
        this.marka = marka;

    }

    @Override
    public String toString() {
        return marka + " " + rejestracja;
    }
}

