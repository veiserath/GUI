package com.company;

import java.util.ArrayList;
import java.util.List;

public class Blok extends Osiedle {
    String nazwaBloku;
    List<Mieszkanie> mieszkania = new ArrayList<>();

    public Blok(String nazwaOsiedla, String nazwaBloku) {
        super(nazwaOsiedla);
        this.nazwaBloku = nazwaBloku;
    }
}
