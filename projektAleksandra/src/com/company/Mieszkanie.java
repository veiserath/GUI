package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mieszkanie extends Pomieszczenie {


    private static int nr = 0;
    private final String id ;
    private final List<Osoba> listalokatorow = new ArrayList<>();

    public Mieszkanie(int rozmiarPomieszczenia){
        super(rozmiarPomieszczenia);
        id = "M" +" "+ ++nr;

    }
    public Mieszkanie(int dlugosc, int szerokosc, int wysokosc) {
        super(dlugosc*szerokosc*wysokosc);
        id = "M" +" "+ ++nr;
    }

    @Override
    public void setNajemca(Osoba najemca) {
        super.setNajemca(najemca);
        listalokatorow.add(0,najemca);
    }

    public List<Osoba> getListalokatorow() {
        return listalokatorow;
    }
    /*  @Override
    public void najmij(Osoba najemca) {
        super.najmij(najemca);
        listalokatorow.add(0,najemca);
    }*/

  /*  public void zamelduj(Osoba os){
        this.listalokatorow.add(os);
    }
    public void wymelduj(Osoba os){
        this.listalokatorow.remove(os);
    }*/

    @Override
    public String toString() {
        return "Mieszkanie " +
                " id = " + id +super.toString()+" ";
    }
}
