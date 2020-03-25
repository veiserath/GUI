package com.company;

public class TelefonKomorkowy extends Urzadzenie implements Callable, Textable {
    boolean simcard;

    public TelefonKomorkowy(String nazwaProducenta, double cena, boolean simcard) {
        super(nazwaProducenta, cena);
        this.simcard = simcard;
    }

    @Override
    public void callMe() throws NoSimcardException{
        if (this.simcard == false){
            throw new NoSimcardException();
        }
        else{
            System.out.println("Halko tu telefon komorkowy.");
        }

    }

    @Override
    public void textMe() throws NoSimcardException{
        if (this.simcard == false){
            throw new NoSimcardException();
        }
        else{
            System.out.println("Witam, pisze z komorki.");
        }
    }

    @Override
    public String toString() {
        return "TelefonKomorkowy{" +
                "simcard=" + simcard + ", " + super.toString() +
                '}';
    }
}
