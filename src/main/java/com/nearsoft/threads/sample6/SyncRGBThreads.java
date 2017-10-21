package com.nearsoft.threads.sample6;

public class SyncRGBThreads extends Thread {
    static SynchronizedRGB color = new SynchronizedRGB();

    public static void main(String[] args) {

        Thread threadRed = new Thread(new Runnable() {
            @Override
            public void run() {
                doColor(16, 0, 0, "red", 1000, 0);
            }
        });
        Thread threadBlack = new Thread(new Runnable() {
            @Override
            public void run() {
                doColor(0, 0, 0, "black", 0, 3000);
            }
        });

        threadBlack.setName("tblack");
        threadBlack.start();
        threadRed.setName("tred");
        threadRed.start();

    }

    private static void doColor(int red, int green, int blue, String colorName, int sleepStart, int sleepMiddle) {
        try {
            sleep(sleepStart);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        color = new SynchronizedRGB(red, green, blue, colorName);
        int myColorInt = color.getRGB();

        try {
            sleep(sleepMiddle);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String myColorName = color.getName();
        System.out.println(Thread.currentThread().getName() + " value: " + myColorInt + " name: " + myColorName);
    }

}
