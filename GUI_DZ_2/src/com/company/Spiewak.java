package com.company;

public abstract class Spiewak {

    String nazwisko;
    int numerStartowy;
    static int statycznyNumerStartowy = 0;

    Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        ++Spiewak.statycznyNumerStartowy;
        numerStartowy = Spiewak.statycznyNumerStartowy;
    }

    abstract String spiewaj();

    public String toString() {
        return "(" + this.numerStartowy + ") " + this.nazwisko + ": " + spiewaj();
    }

    static Spiewak najglosniej(Spiewak spiewacy[]) {
        int uppercaseCount = 0;
        int lastupperCase = 0;
        int winnerIndex = 0;
        for (int i = 0; i < spiewacy.length; i++) {

            for (int j = 0; j < spiewacy[i].spiewaj().length(); j++) {
                if (spiewacy[i].spiewaj().charAt(j) >= 'A' && spiewacy[i].spiewaj().charAt(j) <= 'Z') {
                    uppercaseCount++;
                }
            }
            if (lastupperCase == 0) {
                lastupperCase = uppercaseCount;
                winnerIndex = i;
            } else if (lastupperCase < uppercaseCount) {
                winnerIndex = i;
                lastupperCase = uppercaseCount;
            }
            uppercaseCount = 0;
        }
        return spiewacy[winnerIndex];
    }
}
