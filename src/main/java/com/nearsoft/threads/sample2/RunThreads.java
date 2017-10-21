package com.nearsoft.threads.sample2;

/**
 * Source: Head first java
 */
public class RunThreads implements Runnable {

    public static void main(String[] args) {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");

        RunThreads runner = new RunThreads();
        Thread alpha = new Thread(runner);
        Thread beta= new Thread(runner);
        alpha.setName("Alpha thread");
        beta.setName("Beta thread");
        // todo: check how priority values affect the results
//        alpha.setPriority(Thread.MAX_PRIORITY);
//        beta.setPriority(Thread.MIN_PRIORITY);
        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running. (" + i + ")");
        }
    }
}
