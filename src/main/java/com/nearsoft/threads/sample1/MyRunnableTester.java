package com.nearsoft.threads.sample1;

public class MyRunnableTester {

    public static void main(String[] args) {

        // We create an instance of MyRunnable class
        Runnable myRunnable = new MyRunnable();



        // Now we create a thread so it executes whatever myRunnable does
        Thread t = new Thread(myRunnable);

        // Check some thread data / status
        System.out.println("Thread state 1: " + t.getState());
        System.out.println("Thread name before: " + t.getName());
        System.out.println("Thread priority: " + t.getPriority());

        // We can even give the thread a name!
        t.setName("MyRunnableThread");
        System.out.println("Thread name after: " + t.getName());
        System.out.println("Thread state 2: " + t.getState());

        // Thread needs to call the start method to actually do its job
        t.start();
        System.out.println("Thread state 3: " + t.getState());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            // ignore
        }
        System.out.println("Thread state 4: " + t.getState());

    }

}
