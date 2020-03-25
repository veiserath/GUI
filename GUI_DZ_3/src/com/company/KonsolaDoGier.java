package com.company;

public class KonsolaDoGier extends Urzadzenie implements Playable, Surfable{

    boolean internet;

    public KonsolaDoGier(String nazwaProducenta, double cena, boolean internet) {
        super(nazwaProducenta, cena);
        this.internet = internet;
    }

    @Override
    public void playTheGame() {
        if (internet == false){
            System.out.println("Dostepny tylko tryb singleplayer.");
        }
        else {
            System.out.println("Graj do woli!");
        }


    }

    @Override
    public void surfTheNet() throws NoInternetException {
    if (this.internet == false){
        throw new NoInternetException();
    }
    else {
        System.out.println("Wczytuje Twoja ulubiona stronke.");
    }
    }

    @Override
    public String toString() {
        return "KonsolaDoGier{" +
                "internet=" + internet + ", " + super.toString() +
                '}';
    }
}
