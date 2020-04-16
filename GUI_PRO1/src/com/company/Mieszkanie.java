package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Mieszkanie extends Blok {
    final String id;
    double objetosc;
    Date dataRozpoczeciaNajmu;
    Date dataZakonczeniaNajmu;
    Osoba najemca;
    static int mieszkaniaCreated;
    boolean zadluzone;


    List<Osoba> mieszkancy = new ArrayList<>();


    public Mieszkanie(String nazwaOsiedla, String nazwaBloku, double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia) {
        super(nazwaOsiedla, nazwaBloku);
        mieszkaniaCreated++;
        this.id = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = dlugoscPomieszczenia * szerokoscPomieszczenia * wysokoscPomieszczenia;
        this.zadluzone = false;
    }

    public Mieszkanie(String nazwaOsiedla, String nazwaBloku, double objetosc) {
        super(nazwaOsiedla, nazwaBloku);
        mieszkaniaCreated++;
        this.id = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = objetosc;
        this.zadluzone = false;
    }


}
