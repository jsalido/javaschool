package com.nearsoft.threads.sample6;

public class Counter {

    private long count;

    public void add(long value) {
        long c = this.getCount();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setCount(c + value);
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
