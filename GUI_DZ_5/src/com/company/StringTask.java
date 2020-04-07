package com.company;

public class StringTask implements Runnable {

    public enum TaskState {
        CREATED,
        RUNNING,
        ABORTED,
        READY,
    }

    private boolean created;
    private boolean running;
    private boolean aborted;
    private boolean ready;

    String napisPowielany;
    String napisPowielony;
    int ileRazyPowielic;

    Thread thread;

    public StringTask(String napisPowielany, int ileRazyPowielic) {
        this.napisPowielany = napisPowielany;
        this.ileRazyPowielic = ileRazyPowielic;
        napisPowielony = "";
        this.created = true;
        this.running = false;
        this.aborted = false;
        this.ready = false;
        this.thread = new Thread();


    }
    @Override
    public void run() {
        for (int i = 0; i < this.ileRazyPowielic; i++) {
            this.napisPowielony = this.napisPowielony + this.napisPowielany;
        }
        this.running = false;
        this.ready = true;
    }

    public String getResult() {
        return this.napisPowielony;
    }

    public TaskState getState() {
        if (created) {
            return TaskState.CREATED;
        } else if (!ready && !aborted) {
            return TaskState.RUNNING;
        } else if (aborted) {
            return TaskState.ABORTED;
        } else if (ready) {
            return TaskState.READY;
        }
//        return TaskState.CREATED;
        return TaskState.READY;
    }

    public void start() {
        this.created = false;
        this.running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public void abort() {

        this.aborted = true;
        this.running = false;
        thread.interrupt();
    }

    public boolean isDone() {
        if (ready || aborted){
            return true;
        }
        return false;
    }
}
