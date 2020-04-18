package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MiejsceParkingowe extends Osiedle {
    String id;
    double objetosc;
    static int miejscaParkingoweCreated;
    Date dataRozpoczeciaNajmu;
    Date dataZakonczeniaNajmu;
    Osoba najemca;
    boolean zadluzone;
    boolean wynajete;

    List<Przedmiot> przedmioty = new ArrayList<>();

    public MiejsceParkingowe(String nazwaOsiedla, double objetoscPomieszczenia) {
        super(nazwaOsiedla);
        miejscaParkingoweCreated++;
        this.id = "Miejsce parkingowe: " + miejscaParkingoweCreated;
        this.objetosc = objetoscPomieszczenia;
        this.zadluzone = false;
    }

    public MiejsceParkingowe(String nazwaOsiedla, double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia) {
        super(nazwaOsiedla);
        miejscaParkingoweCreated++;
        this.id = "Miejsce parkingowe: " + miejscaParkingoweCreated;
        this.objetosc = dlugoscPomieszczenia * szerokoscPomieszczenia * wysokoscPomieszczenia;
        this.zadluzone = false;
    }
}
