package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Mieszkanie extends Blok implements Comparable<Mieszkanie> {
    private String id;
    private double objetosc;
    private Date dataRozpoczeciaNajmu;
    private Date dataZakonczeniaNajmu;
    private Osoba najemca;
    private static int mieszkaniaCreated;
    private boolean zadluzone;
    private boolean wynajete;


    private List<Osoba> mieszkancy = new ArrayList<>();


    public Mieszkanie(String nazwaOsiedla, String nazwaBloku, double dlugoscPomieszczenia, double szerokoscPomieszczenia, double wysokoscPomieszczenia) {
        super(nazwaOsiedla, nazwaBloku);
        mieszkaniaCreated++;
        this.id = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = dlugoscPomieszczenia * szerokoscPomieszczenia * wysokoscPomieszczenia;
        this.zadluzone = false;
        this.najemca = null;
    }

    public Mieszkanie(String nazwaOsiedla, String nazwaBloku, double objetosc) {
        super(nazwaOsiedla, nazwaBloku);
        mieszkaniaCreated++;
        this.id = "Mieszkanie: " + mieszkaniaCreated;
        this.objetosc = objetosc;
        this.zadluzone = false;
        this.najemca = null;
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

    public List<Osoba> getMieszkancy() {
        return mieszkancy;
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


    @Override
    public int compareTo(Mieszkanie mieszkanie) {
        if (this.getObjetosc() < mieszkanie.getObjetosc()) {
            return -1;
        }
        if (this.getObjetosc() > mieszkanie.getObjetosc()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", objetosc=" + objetosc +
                ", mieszkancy=" + mieszkancy;
    }
}
