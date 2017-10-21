package com.nearsoft.threads;

public class MyThreadClass extends Thread {

    @Override
    public void run() {
        System.out.println("Hello Java thread!");
    }
}
