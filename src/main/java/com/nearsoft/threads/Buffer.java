package com.nearsoft;

public class Buffer {

    private int data;
    private boolean empty;

    public Buffer() {
        this.empty = true;
    }

    public synchronized void produce(int newData) {
        // Wait until the buffer is empty
        while (!this.empty) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        this.data = newData;
        this.empty = false;
        this.notify();
        System.out.println("Produced: " + newData);
    }

    public synchronized int consume() {
        while (this.empty) {
            try {
                this.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        this.empty = true;
        this.notify();
        System.out.println("Consumed: " + data);
        return data;
    }

}
