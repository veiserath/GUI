package com.company;


import java.util.LinkedList;
import java.util.List;

public class Letters {

    public List<Thread> list;

    public Letters(String napis) {
        list = new LinkedList<>();

        for (int i = 0; i < napis.length(); i++) {
            char tmp = napis.charAt(i);

            Thread thread = new Thread(() -> {
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                    System.out.print(tmp);
                }
            });
            thread.setName("Thread " + tmp);
            list.add(thread);
        }
    }


    public List<Thread> getThreads() {
        return list;
    }

}