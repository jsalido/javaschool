package com.nearsoft.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;

public class CheckThreads {

    public static void main(String[] args) {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");

        IntStream s = IntStream.range(0, 100);

        Instant before = Instant.now();
        s.parallel().forEach(i -> {
            try {
                Thread.sleep(100);
            } catch (Exception ignore) {
            }
            System.out.println("Finished #" + i + " using thread [" + Thread.currentThread().getName() + "]");
        });
        Instant after = Instant.now();
        System.out.println("\nDuration: " + (Duration.between(before, after)).toMillis());

    }

}
