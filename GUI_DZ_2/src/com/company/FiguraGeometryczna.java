package com.company;

public abstract class FiguraGeometryczna {

    String kolor;

    FiguraGeometryczna(String kolor){
        this.kolor = kolor;
    }


    public abstract double getPole();

    public abstract double getObwod();

    @Override
    public String toString(){
        return "Pole : " + getPole() + "obwod: " + getObwod();
    }
}
