package com.company;

import java.util.ArrayList;
import java.util.List;

public class MiejsceParkingowe {
    String idMiejscaParkingowego;
    double objetosc;
    static int miejscaParkingoweCreated;
    String dataRozpoczeciaNajmu;
    String dataZakonczeniaNajmu;

    List<Przedmiot> przedmioty = new ArrayList<>();

    public MiejsceParkingowe(double objetoscPomieszczenia) {
        this.idMiejscaParkingowego = "Miejsce parkingowe: " + miejscaParkingoweCreated;
        this.objetosc = objetoscPomieszczenia;
    }

    public MiejsceParkingowe(double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia) {
        this.idMiejscaParkingowego = "Miejsce parkingowe: " + miejscaParkingoweCreated;
        this.objetosc = dlugoscPomieszczenia * szerokoscPomieszczenia * wysokoscPomieszczenia;
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) throws TooManyThingsException {
        if (this.objetosc - przedmiot.objetosc < 0) {
            throw new TooManyThingsException();
        } else {
            this.objetosc -= przedmiot.objetosc;
            przedmioty.add(przedmiot);
        }


    }
}
