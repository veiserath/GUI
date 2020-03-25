package com.company;

public class Kolo extends FiguraGeometryczna{

    double radius;

    Kolo(double radius, String kolor){
        super(kolor);
        this.radius = radius;
    }

    @Override
    public double getPole() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getObwod() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "[Kolo] - promien = " + radius + super.toString();
    }
}
