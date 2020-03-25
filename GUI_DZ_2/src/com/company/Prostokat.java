package com.company;

public class Prostokat extends FiguraGeometryczna {

    double bokA;
    double bokB;

    Prostokat(double bokA, double bokB, String kolor){
        super(kolor);
        this.bokA = bokA;
        this.bokB = bokB;
    }


    @Override
    public double getObwod() {
        return 2*bokA+2*bokB;
    }

    @Override
    public double getPole() {
        return bokA*bokB;
    }

    @Override
    public String toString(){
        return "[Prostokat] - boki: " + bokA + ", " + bokB + "; " + super.toString();
    }

}
