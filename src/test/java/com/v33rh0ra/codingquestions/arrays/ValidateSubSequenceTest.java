package com.v33rh0ra.codingquestions.arrays;



import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ValidateSubSequenceTest {

    @Test
    public void testArrayBasedApproachValid() {
        List<Integer> nums = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        boolean res = ValidateSubSequence.arrayBasedApproach(nums,sequence);
        assertThat(res).isTrue();
    }
    @Test
    public void testArrayBasedApproachInvalid() {
        List<Integer> nums = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, 4, 10);
        boolean res = ValidateSubSequence.arrayBasedApproach(nums,sequence);
        assertThat(res).isFalse();
    }

}