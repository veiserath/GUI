package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        Letters letters = new Letters("ABCD");
//        for (Thread t : letters.getThreads()){
//            System.out.println(t.getName());
//        }
//
//        for (Thread t : letters.getThreads()){
//            t.start();
//        }
//
//
//        /*<- w tym miejscu należy uruchomić wszystkie kody w wątkach
//         */
//        System.out.println("teraz bedzie spanko");
//        Thread.sleep(5000);
//
//        for (Thread t : letters.getThreads()){
//            t.interrupt();
//        }
//
//
//        /*<- tu należy zapisać
//        fragment , który kończy działanie wątków, wypisujących
//        litery
//        */
//        System.out.println("\nProgram skończył działanie");

        StringTask task = new StringTask("A", 70000);
        System.out.println("Task " + task.getState());
        task.start();
        if (args.length > 0 && args[0].equals("abort")) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    task.abort();
                }
            });
            thread.start();

        }
        while (!task.isDone()) {
            Thread.sleep(500);
            switch (task.getState()) {
                case RUNNING:
                    System.out.print("R.");
                    break;
                case ABORTED:
                    System.out.println(" ... aborted.");
                    break;
                case READY:
                    System.out.println(" ... ready.");
                    break;
                default:
                    System.out.println("unknown state");
            }
        }
        System.out.println("Task " + task.getState());
        System.out.println(task.getResult().length());


    }
}
