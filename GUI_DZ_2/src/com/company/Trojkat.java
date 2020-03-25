package com.company;

public class Trojkat extends FiguraGeometryczna {

    double bokA;
    double bokB;
    double bokC;

    Trojkat(double bokA, double bokB, double bokC, String kolor){
        super(kolor);
        this.bokA = bokA;
        this.bokB = bokB;
        this.bokC = bokC;

    }

    @Override
    public double getObwod() {
        return bokA + bokB + bokC;
    }

    @Override
    public double getPole() {
        double polowaObwodu = getObwod()/2;
        return Math.sqrt(polowaObwodu*(polowaObwodu-bokA)*(polowaObwodu-bokB)*(polowaObwodu-bokC));
    }

    @Override
    public String toString() {
        return "[Trojkat] - boki: " + bokA + ", " + bokB + ", " + bokC + "; " + super.toString();
    }
}
