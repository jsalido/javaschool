package com.nearsoft.threads.sample3;

class TestSync implements Runnable {
    private int balance;

    public void run() {
        for (int i = 0; i < 50; i++) {
            increment();
            System.out.println("balance is " + balance);
        }
    }

    public void increment() {
        int i = balance;
        System.out.println("   [" + Thread.currentThread().getName() + "] Balance: " + i);
        balance = i + 1;
        try {
            Thread.sleep(350);
        } catch (InterruptedException ex) {
            // ignore
        }
    }

}
