package com.nearsoft.threads.sample4;

public class FinishBarrierTask implements Runnable {
    @Override
    public void run() {
        System.out.println("FinishBarrierTask: All the tasks have finished");
    }
}