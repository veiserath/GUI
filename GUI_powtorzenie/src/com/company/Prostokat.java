package com.company;

import java.util.Scanner;

public class Prostokat {
    private int a,b,pole;
    private double przekatna;
    Prostokat(){
        this.a = 0;
        this.b = 0;
        this.pole = 0;
        this.przekatna = 0;
        czytajDane();
    }
    void czytajDane(){
        Scanner input = new Scanner(System.in);
        System.out.println("Wprowadz wartosc a: ");
        this.a = input.nextInt();
        System.out.println("Wprowadz wartosc b: ");
        this.b = input.nextInt();
        this.pole = a * b;
        this.przekatna = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    int obliczPole(){
        this.pole = a * b;
        return this.pole;
    }
    double obliczPrzekatna(){
        this.przekatna = Math.sqrt(Math.pow(this.a,2)+Math.pow(this.b,2));
        //czy to ma sens z tym this, co jakbym zrobil po prostu return przekatna?
        return this.przekatna;
    }
    //czemu tu musze dopisac public
    public String toString(){
        return "a: " + a + " b: " + b + " pole: " + pole + " przekatna: " + przekatna;
    }


}

