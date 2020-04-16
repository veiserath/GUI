package com.company;

import java.util.ArrayList;
import java.util.List;

public class Osiedle {

    String nazwaOsiedla;
    List<Blok> bloki = new ArrayList<>();
    List<MiejsceParkingowe> miejscaParkingowe = new ArrayList<>();

    public Osiedle(String nazwaOsiedla) {
        this.nazwaOsiedla = nazwaOsiedla;
    }
}
