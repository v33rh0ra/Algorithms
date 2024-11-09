package com.v33rh0ra.algorithms.codingconstructs.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    static ForkJoinPool forkJoinPool = new ForkJoinPool();
    public static final int LENGTH = 1000_000;

    public static void main(String[] args){
        Integer[] numbers = new Integer[LENGTH];
        for (int i = 0; i<LENGTH; i++){
            numbers[i] = i;
        }
        long startTime = System.nanoTime();
        int sum = forkJoinPool.invoke(new SumCalculatorTask(numbers));
        long endTime = System.nanoTime();
        System.out.println("sum = " + sum);
        long durationMS = (endTime - startTime) / 1_000_000 ;
        System.out.println("duration in ms = " + durationMS);

        startTime = System.nanoTime();
        sum = forkJoinPool.invoke(new NumberDividerTask(numbers));
        endTime = System.nanoTime();
        System.out.println("sum: " + sum);
        durationMS = (endTime - startTime)/ 1_000_000;
        System.out.println("duration in ms = " + durationMS);
    }
}
