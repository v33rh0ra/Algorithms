package com.v33rh0ra.algorithms.codingconstructs.lambdaexpr;

public class LambdaExplorer {
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());
    String sql = "select * from table";
    Runnable r3 = ()->{
//        sql = "select * from new table";
        System.out.println("Executing sql = " + sql);
    };

    public String toString(){
        return "Hello World!!";
    }


    public static void main(String[] args) {
        new LambdaExplorer().r1.run();
        new LambdaExplorer().r2.run();
        new LambdaExplorer().r3.run();
    }
}
