package com.nearsoft;

public class ThreadState extends Thread {

    private boolean keepRunning = true;
    private boolean wait = false;
    private Object syncObject = null;
    private int counter = 0;

    public ThreadState(Object syncObject) {
        this.syncObject = syncObject;
    }

    public void run() {
        while (keepRunning) {
            counter++;
            synchronized (syncObject) {
                if (wait) {
                    try {
                        syncObject.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
        }
    }

    public void setKeepRunning(boolean keepRunning) {
        this.keepRunning = keepRunning;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

}
