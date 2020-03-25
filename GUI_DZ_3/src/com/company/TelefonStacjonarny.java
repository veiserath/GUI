package com.company;

public class TelefonStacjonarny extends Urzadzenie implements Callable {

    public TelefonStacjonarny(String nazwaProducenta, double cena) {
        super(nazwaProducenta, cena);
    }

    @Override
    public void callMe() {
        System.out.println("Halkoooo");
    }

    @Override
    public String toString() {
        return "TelefonStacjonarny{" + super.toString() + "}" ;
    }
}
