package com.company;

import java.util.ArrayList;
import java.util.List;

public class Osiedle {

    protected String nazwaOsiedla;
    protected List<Blok> bloki = new ArrayList<>();
    protected List<MiejsceParkingowe> miejscaParkingowe = new ArrayList<>();

    public Osiedle(String nazwaOsiedla) {
        this.nazwaOsiedla = nazwaOsiedla;
    }

    public static void wyswietlWolnePomieszczenia(List<Osiedle> osiedla) {
        for (Osiedle osiedle : osiedla) {
            for (Blok blok : osiedle.bloki) {
                for (Mieszkanie mieszkanie : blok.mieszkania) {
                    if (mieszkanie.getNajemca() == null)
                    System.out.println(mieszkanie.getId() + " " + mieszkanie.getObjetosc());

                }
            }
            for (MiejsceParkingowe miejsceParkingowe : osiedle.miejscaParkingowe) {
                if (miejsceParkingowe.getNajemca() == null)
                System.out.println(miejsceParkingowe.getId() + " " + miejsceParkingowe.getObjetosc());

            }
        }
    }

    public static Mieszkanie znajdzMieszkanie(List<Osiedle> osiedla, String idPomieszczenia) {

        for (Osiedle osiedle : osiedla) {
            for (Blok blok : osiedle.bloki) {
                for (Mieszkanie mieszkanie : blok.mieszkania) {
                    if (mieszkanie.getId().equals(idPomieszczenia)) {
                        return mieszkanie;
                    }

                }
            }
        }
        return null;
    }

    public static MiejsceParkingowe znajdzMiejsceParkingowe(List<Osiedle> osiedla, String idPomieszczenia) {
        for (Osiedle osiedle : osiedla) {
            for (MiejsceParkingowe miejsceParkingowe : osiedle.miejscaParkingowe) {
                if (miejsceParkingowe.getId().equals(idPomieszczenia)) {
                    return miejsceParkingowe;
                }

            }
        }
        return null;
    }

    public String getNazwaOsiedla() {
        return nazwaOsiedla;
    }

    public List<Blok> getBloki() {
        return bloki;
    }

    public List<MiejsceParkingowe> getMiejscaParkingowe() {
        return miejscaParkingowe;
    }

    @Override
    public String toString() {
        return "Osiedle{" +
                "nazwaOsiedla='" + nazwaOsiedla + '\'' +
                ", bloki=" + bloki +
                ", miejscaParkingowe=" + miejscaParkingowe +
                '}';
    }
}
