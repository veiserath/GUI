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

    public static void wyswietlWolnePomieszczenia(List<Osiedle> osiedla) {
        for (Osiedle osiedle : osiedla) {
            for (Blok blok : osiedle.bloki) {
                for (Mieszkanie mieszkanie : blok.mieszkania) {
                    System.out.println(mieszkanie.getId() + " " + mieszkanie.getObjetosc());

                }
            }
            for (MiejsceParkingowe miejsceParkingowe : osiedle.miejscaParkingowe) {
                System.out.println(miejsceParkingowe.id + " " + miejsceParkingowe.objetosc);

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
                if (miejsceParkingowe.id.equals(idPomieszczenia)) {
                    return miejsceParkingowe;
                }

            }
        }
        return null;
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
