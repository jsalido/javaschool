package com.nearsoft.threads.sample3;

public class TestSyncTest {
    public static void main(String[] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        a.setName("A");
        Thread b = new Thread(job);
        b.setName("B");
        a.start();
        b.start();
    }
}