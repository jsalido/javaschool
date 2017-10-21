package com.nearsoft.threads.sample4;

import java.util.concurrent.CountDownLatch;

public class CountDownTask implements Runnable {
    private CountDownLatch countDownLatch;
    public CountDownTask(CountDownLatch countDownLatch) {
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {
        // some task
        countDownLatch.countDown();
    }
}
