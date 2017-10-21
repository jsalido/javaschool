package com.nearsoft.threads.spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 4, 6, 14, 23, 53, 21, 33, 42, 55, 16);

        Spliterator mySpliterator = integers.spliterator();
        System.out.println(mySpliterator.characteristics());
        System.out.println(mySpliterator.estimateSize());

        Spliterator aSplit = mySpliterator.trySplit();
        System.out.println(aSplit.characteristics());
        System.out.println(aSplit.estimateSize());

        System.out.println(aSplit.characteristics() | Spliterator.CONCURRENT);

    }

}
