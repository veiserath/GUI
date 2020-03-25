package com.company;

public class Kwadrat extends Prostokat {


    Kwadrat(double bok, String kolor){
        super(bok,bok,kolor);
    }

    @Override
    public String toString() {
        return "[Kwadrat] - bok: " + bokA + "; P= " + getPole() + "; Ob = " + getObwod();
    }


}
