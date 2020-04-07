package com.company;

import java.util.ArrayList;
import java.util.List;

public class Mieszkanie {
    String idMieszkania;
    double objetosc;
    static int mieszkaniaCreated;
    String dataRozpoczeciaNajmu;
    String dataZakonczeniaNajmu;

    List<Osoba> mieszkancy = new ArrayList<>();

    //kazde mieszkanie moze miec tylko 1 najemce
    public Mieszkanie(double objetosc, Najemca najemca) {
        mieszkaniaCreated++;
        this.idMieszkania = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = objetosc;
    }

    public Mieszkanie(double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia, Najemca najemca) {
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

}
