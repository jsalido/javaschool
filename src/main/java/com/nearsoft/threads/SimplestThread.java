package com.nearsoft;

import com.nearsoft.threads.MyThreadClass;
import com.nearsoft.threads.ThreadTest;

public class SimplestThread {

    public static void main(String[] args) {
        Thread simplestThread = new Thread();
        simplestThread.start();

        Thread myThread = new MyThreadClass();
        myThread.start();


        Runnable aRunnableObject = () -> System.out.println("Hello Java thread v2!");
        Thread myRunnableThread = new Thread(aRunnableObject);
        myRunnableThread.start();

        Thread executeThread = new Thread(ThreadTest::execute);
        executeThread.start();

        Thread imprimirNumerosA = new Thread(SimplestThread::print);
        Thread imprimirNumerosB = new Thread(SimplestThread::print);
        imprimirNumerosA.start();
        imprimirNumerosB.start();


    }


    public static void print() {
        for (int i = 1; i <= 500; i++) {
            System.out.print(i + " ");
        }
    }

}
