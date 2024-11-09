package com.v33rh0ra.algorithms.datastructures;


import java.sql.Array;

public class MyArray {
    public static final Integer DEFAULT_INITIAL_SIZE = 100;

    private Integer initialSize;

    public MyArray(){
        this.initialSize = DEFAULT_INITIAL_SIZE;
//        Integer[] numbers = new Integer[this.initialSize];
//        Array<Integer> numbers = new Array<>();
    }
    public MyArray(Integer size){
        this.initialSize = size;
    }

    public void add(Integer value){

    }

    public boolean remove(Integer value){
        return false;
    }

    public boolean exists(Integer value){
        return true;
    }
    public void index(Integer value){

    }

}
