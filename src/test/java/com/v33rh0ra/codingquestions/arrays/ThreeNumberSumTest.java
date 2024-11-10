package com.v33rh0ra.codingquestions.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;


public class ThreeNumberSumTest {

    @Test
    public void testHashSetBasedApproach() {
        int[] nums = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        List<Integer[]> res = ThreeNumberSum.hashSetBasedApproach(nums,targetSum);
        assertThat(res.size()).isGreaterThan(0);
        boolean finalRes = true;
        res.forEach(x ->{
            System.out.println(
                    Arrays.stream(x).map(String::valueOf)
                            .collect(Collectors.joining(",")));
            int currentSum = Arrays.stream(x).mapToInt(Integer::intValue).sum();
            assertThat(currentSum).isEqualTo(targetSum);

        });
        assertThat(finalRes).isTrue();

    }

    @Test
    public void testArrayBasedApproach() {
        int[] nums = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        List<Integer[]> res = ThreeNumberSum.arrayBasedApproach(nums,targetSum);
        boolean finalRes = true;
        res.forEach(x ->{
            System.out.println(
                    Arrays.stream(x).map(String::valueOf)
                            .collect(Collectors.joining(",")));
            int currentSum = Arrays.stream(x).mapToInt(Integer::intValue).sum();
            assertThat(currentSum).isEqualTo(targetSum);

        });
        assertThat(finalRes).isTrue();
    }
}