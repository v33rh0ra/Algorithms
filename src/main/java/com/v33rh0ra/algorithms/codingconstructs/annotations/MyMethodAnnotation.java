package com.v33rh0ra.algorithms.codingconstructs.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//Target specifies where annotation can be applied, i.e CLASS, METHOD, FIELD
//RETENTION POLICY defines how long the method is retained.
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation {
    String value();
    int priority() default 1;
}
