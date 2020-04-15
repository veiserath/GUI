package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Mieszkanie {
    String idMieszkania;
    double objetosc;
    static int mieszkaniaCreated;
    Date dataRozpoczeciaNajmu;
    Date dataZakonczeniaNajmu;
    Najemca najemca;
    MiejsceParkingowe miejsceParkingowe;


    List<Osoba> mieszkancy = new ArrayList<>();

    //kazde mieszkanie moze miec tylko 1 najemce
    public Mieszkanie(double objetosc) {
        mieszkaniaCreated++;
        this.idMieszkania = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = objetosc;
    }

    public Mieszkanie(double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia) {
        mieszkaniaCreated++;
        this.idMieszkania = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = dlugoscPomieszczenia * szerokoscPomieszczenia * wysokoscPomieszczenia;
    }

    public void eksmisja() {

    }

    public void dodajNajemce(Najemca osoba) throws ProblematicTenantException {
        if (osoba.pisma.size() >= 3) {
            throw new ProblematicTenantException("Osoba: " + osoba.imie + " " + osoba.nazwisko + " posiada juz Mieszkania: " + osoba.mieszkania + " oraz Miejsca Parkingowe: " + osoba.miejscaParkingowe);
        }
        this.mieszkancy.add(osoba);
    }

    public void usunNajemce(Osoba osoba) {
        this.mieszkancy.remove(osoba);
    }

    public void wynajmij(Najemca najemca, String dataRozpoczeciaNajmu, String dataZakonczeniaNajmu) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.dataRozpoczeciaNajmu = simpleDateFormat.parse(dataRozpoczeciaNajmu);
        this.dataZakonczeniaNajmu = simpleDateFormat.parse(dataZakonczeniaNajmu);
        this.najemca = najemca;
    }

    public void wynajmijMiejsceParkingowe(MiejsceParkingowe miejsceParkingowe) {
        this.miejsceParkingowe = miejsceParkingowe;
    }

}
