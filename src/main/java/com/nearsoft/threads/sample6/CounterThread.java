package com.nearsoft.threads.sample6;

public class CounterThread extends Thread {

    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.add(i);
            System.out.println(Thread.currentThread().getName() + ":: " + counter.getCount());
        }
    }

}
