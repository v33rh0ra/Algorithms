package com.v33rh0ra.algorithms.codingconstructs.annotations;

import java.lang.reflect.Method;

public class TestMethodAnnotation {
    @MyMethodAnnotation(value="example", priority=2)
    public void myMethod(){
        System.out.println("In TestMethodAnnotation.myMethod");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = TestMethodAnnotation.class.getMethod("myMethod");
        if (method.isAnnotationPresent(MyMethodAnnotation.class)){
            MyMethodAnnotation annotation = method.getAnnotation(MyMethodAnnotation.class);
            System.out.println("value:"+annotation.value());
            System.out.println("priority:"+annotation.priority());
        }
    }
}
