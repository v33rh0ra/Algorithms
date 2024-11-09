package com.v33rh0ra.algorithms.codingconstructs.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumCalculatorTask extends RecursiveTask<Integer> {
    Integer[] numbers;
    SumCalculatorTask(Integer[] numbers){
        this.numbers = numbers;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        for(int i : numbers){
            sum+=i;
        }
        return sum;
    }
}
