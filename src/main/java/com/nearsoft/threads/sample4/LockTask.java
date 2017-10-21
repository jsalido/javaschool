package com.nearsoft.threads.sample4;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class LockTask implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    private String name;

    public LockTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("Task: " + name + "; Date " + new Date() + ": Running the task.");
            // some task here
            System.out.println("Task: " + name + "; Date " + new Date() + ": Execution has finished.");
        } finally {
            lock.unlock();
        }
    }

}
