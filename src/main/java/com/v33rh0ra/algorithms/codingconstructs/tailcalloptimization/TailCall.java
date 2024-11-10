package com.v33rh0ra.algorithms.codingconstructs.tailcalloptimization;

import java.util.stream.Stream;
import java.math.*;

@FunctionalInterface
public interface TailCall<T> {

    TailCall<T> apply();

    default boolean isDone() {
        return false;
    }

    default T result() {
        throw new UnsupportedOperationException("Not done yet.");
    }

    default T invoke() {
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isDone)
                .findFirst()
                .get()
                .result();
    }

    static <T> TailCall<T> done(final T value) {
        return new TailCall<T>() {
            @Override
            public T result() {
                return value;
            }
            @Override
            public boolean isDone() {
                return true;
            }
            @Override
            public TailCall<T> apply() {
                throw new UnsupportedOperationException("Not supported.");
            }
        };
    }

    static BigInteger streamFactorial(int n) {
        return streamFactorial(BigInteger.ONE, n).invoke();
    }
    static TailCall<BigInteger> streamFactorial(BigInteger x, int n) {
        return () -> {
            switch (n) {
                case 1:
                    return TailCall.done(x);
                default:
                    return streamFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
            }
        };
    }

    static BigInteger stackFactorial(int n) {
        return stackFactorial(BigInteger.ONE, n);
    }
    static BigInteger stackFactorial(BigInteger x, int n) {
        if (n==1) return x;
        else return stackFactorial(x.multiply(BigInteger.valueOf(n)), n - 1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final int num = 55555;
        System.out.println("calculating " + num + "!");
        try {
            stackFactorial(num);
            System.out.println("stack: " + (System.currentTimeMillis() - start));
        } catch (StackOverflowError e) {
            System.err.println(e);
        }
        streamFactorial(num);
        System.out.println("stream: " + (System.currentTimeMillis() - start) + "ms");
    }
}
