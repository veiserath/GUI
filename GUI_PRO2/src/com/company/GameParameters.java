package com.company;

import java.util.LinkedList;
import java.util.List;

public class VirusAdvancement extends Thread {
    long infected;
    long totalPopulation;
    long cured;
    long died;
    List<Long> coronaCases = new LinkedList<>();

    public VirusAdvancement() {
        this.infected = 0L;
        this.totalPopulation = 7600000000L;
        int i = 0;
        while (true) {
            if (infected == totalPopulation) {
                System.out.println("Game over!");
            } else if (i == 14 && coronaCases.isEmpty()) {
                coronaCases.add(infected);
                i = 0;
            } else if (i == 14 && !coronaCases.isEmpty()) {
                coronaCases.add(infected);
//                get people who got infected two weeks ago
//                3% of them dies
                long died = (long) (coronaCases.get(0) * 0.05);
                coronaCases.remove(0);
                i = 0;
            }

            infected = infected + 2 * infected; //MINUS UPGRADE'y!!! + NALICZENIE PKT ZA WYZDROWIAKOW
            try {
                i++;
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void currentTime() {

    }
}
