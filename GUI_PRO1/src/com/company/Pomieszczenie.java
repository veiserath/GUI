package com.company;

public class Pomieszczenie extends Mieszkanie {

    String rozpoczecieNajmu;
    String zakonczenieNajmu;

    public Pomieszczenie(double powierzchniaUzytkowa, Najemca najemca) {
        super(powierzchniaUzytkowa, najemca);
    }
}


//relacja miedzy pomieszczeniem, a mieszkaniem.
//mieszkanie wynajete w ramach osiedla?
//