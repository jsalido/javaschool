package com.nearsoft.threads.sample4;

import java.util.Date;
import java.util.concurrent.Semaphore;

public class SemaphoreTask implements Runnable {

    private Semaphore semaphore;

    public SemaphoreTask(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task: " + Thread.currentThread().getName() + "; Date " + new Date() + ": Running the task.");
            semaphore.acquire();
            // some task
            Thread.sleep(1000);
            System.out.println("Task: " + Thread.currentThread().getName() + "; Date " + new Date() + ": Execution has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
