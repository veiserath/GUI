package com.company;

public class Smartfon extends Urzadzenie implements Callable, Surfable, Playable, Textable{

    boolean simcard;
    boolean internet;

    public Smartfon(String nazwaProducenta, double cena, boolean simcard, boolean internet) {
        super(nazwaProducenta, cena);
        this.simcard = simcard;
        this.internet = internet;
    }

    @Override
    public void surfTheNet() throws NoInternetException{
    if (internet == false){
        throw new NoInternetException();
    }
    else{
        System.out.println("Wczytuje Twoja ulubiona strone.");
    }

    }

    @Override
    public void textMe() throws NoSimcardException {
        if (simcard == false){
            throw new NoSimcardException();
        }
        else{
            System.out.println("Halko, piszę ze smartfona");
        }

    }

    @Override
    public void callMe() throws NoSimcardException{
        if (simcard == false){
            throw new NoSimcardException();
        }
        else{
            System.out.println("Halko, piszę ze smartfona");
        }

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
    public String toString() {
        return "Smartfon{" +
                "simcard=" + simcard +
                ", internet=" + internet + ", " + super.toString() +
                '}';
    }
}
