package com.company;

public class Osoba {
    String twOjstary;
    int lolik;

    public Osoba(String twOjstary, int lolik) {
        this.twOjstary = twOjstary;
        this.lolik = lolik;
    }

    public void czyUdane(Mieszkanie mieszkanie){
        if (mieszkanie.najemca == this){
            System.out.println("sukces");
        }
    }
}
