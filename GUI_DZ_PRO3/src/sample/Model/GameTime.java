package sample.Model;

import java.util.concurrent.TimeUnit;

public class GameTime extends Thread {

    private long seconds;
    private long minutes;
    private long totalRankingTime;

    public GameTime() {

        this.seconds = 0L;
        this.minutes = 0L;
        this.totalRankingTime = 0L;
    }


    public synchronized void calculateTime() {
        long startTime = System.nanoTime();
        while (true) {
            long elapsedTime = System.nanoTime() - startTime;
            this.seconds = TimeUnit.NANOSECONDS.toSeconds(elapsedTime) % 60;
            this.minutes = TimeUnit.NANOSECONDS.toMinutes(elapsedTime) % 60;
            this.totalRankingTime = TimeUnit.NANOSECONDS.toMinutes(elapsedTime);
        }
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            calculateTime();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public long getSeconds() {
        return seconds;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getTotalRankingTime() {
        return totalRankingTime;
    }
}


