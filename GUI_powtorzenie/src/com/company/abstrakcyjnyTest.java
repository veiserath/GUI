package com.company;

public class abstrakcyjnyTest {

    public static void main(String[] args) {

        abstrakcyjnyPacjent jan = new abstrakcyjnyPacjent("Jan") {

            String choroba = "glowa";
            String leczenie = "aspiryna";

            @Override
            public String nazwisko() {
                return super.nazwisko();
            }

            @Override
            public String choroba() {
                return this.choroba;
            }

            @Override
            public String leczenie() {
                return this.leczenie;
            }

        };
        abstrakcyjnyPacjent edzio = new abstrakcyjnyPacjent("Edzio") {

            String choroba = "noga";
            String leczenie = "gips";

            @Override
            public String nazwisko() {
                return super.nazwisko();
            }

            @Override
            public String choroba() {
                return this.choroba;
            }

            @Override
            public String leczenie() {
                return this.leczenie;
            }

        };
        abstrakcyjnyPacjent marian = new abstrakcyjnyPacjent("Marian") {

            String choroba = "dyspepsja";
            String leczenie = "węgiel";

            @Override
            public String nazwisko() {
                return super.nazwisko();
            }

            @Override
            public String choroba() {
                return this.choroba;
            }

            @Override
            public String leczenie() {
                return this.leczenie;
            }
        };
        abstrakcyjnyPacjent[] pacjenci = {jan, edzio, marian};


        for (abstrakcyjnyPacjent p : pacjenci) {
            System.out.println("Pacjent: " + p.nazwisko() + '\n' +
                    "Chory na: " + p.choroba() + '\n' +
                    "Zastosowano: " + p.leczenie() + "\n\n"
            );
        }


    }
}