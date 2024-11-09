package com.v33rh0ra.algorithms.codingconstructs.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NumberDividerTask extends RecursiveTask<Integer> {
    public static final Integer MAX_TASK_LEN = 100_000;
    Integer[] numbers;

    NumberDividerTask(Integer[] numbers){
        this.numbers = numbers;
    }

    @Override
    protected Integer compute() {
        Integer sum = 0;
        List<RecursiveTask<Integer>> forks = new ArrayList<>();
        int len_numbers = numbers.length;
        if(len_numbers > MAX_TASK_LEN){
            int mid = len_numbers/2;
            NumberDividerTask task1 = new NumberDividerTask(Arrays.copyOfRange(
                    numbers, 0, mid
            ));
            NumberDividerTask task2 = new NumberDividerTask(Arrays.copyOfRange(
                    numbers, mid, len_numbers
            ));
            forks.add(task1);
            forks.add(task2);
            task1.fork();
            task2.fork();
        }else{
            SumCalculatorTask sumCalculatorTask = new SumCalculatorTask(numbers);
            forks.add(sumCalculatorTask);
            sumCalculatorTask.fork();
        }
        for (RecursiveTask<Integer> task: forks){
            sum+=task.join();
        }
        return sum;
    }
}
