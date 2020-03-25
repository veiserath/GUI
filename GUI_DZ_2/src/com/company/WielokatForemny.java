package com.company;

public class WielokatForemny extends FiguraGeometryczna {

    Double a;
    Double r;
    Integer n;

    public WielokatForemny(Double a, Double r, Integer n, String kolor) {
        super(kolor);
        this.a = a;
        this.n = n;
        this.r = r;
    }

    @Override
    public double getObwod() {
        return a * n;
    }

    @Override
    public double getPole() {
        return (a*n*r)/2d;
    }

    @Override
    public String toString() {
        return "[WielokatForemny] - r = " + r + "; a = " + a + "; n = " + n + super.toString();
    }

}
