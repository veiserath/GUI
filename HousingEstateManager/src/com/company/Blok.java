package com.company;

import java.util.ArrayList;
import java.util.List;

public class Blok extends Osiedle {
    protected String nazwaBloku;
    protected List<Mieszkanie> mieszkania = new ArrayList<>();

    public Blok(String nazwaOsiedla, String nazwaBloku) {
        super(nazwaOsiedla);
        this.nazwaBloku = nazwaBloku;
    }

    public String getNazwaBloku() {
        return nazwaBloku;
    }

    public List<Mieszkanie> getMieszkania() {
        return mieszkania;
    }
}
