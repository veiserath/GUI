package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MiejsceParkingowe {
    String idMiejscaParkingowego;
    double objetosc;
    static int miejscaParkingoweCreated;
    Date dataRozpoczeciaNajmu;
    Date dataZakonczeniaNajmu;
    Najemca najemca;

    List<Przedmiot> przedmioty = new ArrayList<>();

    public MiejsceParkingowe(double objetoscPomieszczenia) {
        miejscaParkingoweCreated++;
        this.idMiejscaParkingowego = "Miejsce parkingowe: " + miejscaParkingoweCreated;
        this.objetosc = objetoscPomieszczenia;
    }

    public MiejsceParkingowe(double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia) {

        miejscaParkingoweCreated++;
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

    public void wynajmij(Najemca najemca, String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.dataRozpoczeciaNajmu = simpleDateFormat.parse(dataRozpoczeciaNajmu);
        this.dataZakonczeniaNajmu = simpleDateFormat.parse(dataZakonczeniaNajmu);
        this.najemca = najemca;
    }
}
