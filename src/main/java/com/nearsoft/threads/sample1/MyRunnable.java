package com.nearsoft.threads.sample1;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("This is MyRunnable. I am running!");
        System.out.println("Now I'm going to sleep... ZzZzZz");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            // ignore
        }
        System.out.println("Awake!");
    }
}
