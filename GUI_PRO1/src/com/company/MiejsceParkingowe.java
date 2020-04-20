package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MiejsceParkingowe extends Osiedle implements Comparable<MiejsceParkingowe> {
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

    public String getId() {
        return id;
    }

    public double getObjetosc() {
        return objetosc;
    }

    public Date getDataRozpoczeciaNajmu() {
        return dataRozpoczeciaNajmu;
    }

    public Date getDataZakonczeniaNajmu() {
        return dataZakonczeniaNajmu;
    }

    public Osoba getNajemca() {
        return najemca;
    }

    public boolean isZadluzone() {
        return zadluzone;
    }

    public boolean isWynajete() {
        return wynajete;
    }

    public List<Przedmiot> getPrzedmioty() {
        return przedmioty;
    }


    public void setDataRozpoczeciaNajmu(Date dataRozpoczeciaNajmu) {
        this.dataRozpoczeciaNajmu = dataRozpoczeciaNajmu;
    }

    public void setDataZakonczeniaNajmu(Date dataZakonczeniaNajmu) {
        this.dataZakonczeniaNajmu = dataZakonczeniaNajmu;
    }

    public void setNajemca(Osoba najemca) {
        this.najemca = najemca;
    }

    public void setZadluzone(boolean zadluzone) {
        this.zadluzone = zadluzone;
    }

    public void setWynajete(boolean wynajete) {
        this.wynajete = wynajete;
    }

    public void setPrzedmioty(List<Przedmiot> przedmioty) {
        this.przedmioty = przedmioty;
    }

    @Override
    public int compareTo(MiejsceParkingowe miejsceParkingowe) {
        if (this.getObjetosc() < miejsceParkingowe.getObjetosc()){
            return -1;
        }
        if (this.getObjetosc() > miejsceParkingowe.getObjetosc()){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "MiejsceParkingowe{" +
                "id='" + id + '\'' +
                ", przedmioty=" + przedmioty +
                '}';
    }
}
