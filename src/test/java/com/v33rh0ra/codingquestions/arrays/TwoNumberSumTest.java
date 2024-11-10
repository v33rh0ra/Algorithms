package com.v33rh0ra.codingquestions.arrays;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

public class TwoNumberSumTest {

    private TwoNumberSum tnsum;

    @Before
    public void setup(){
//        tnsum = new TwoNumberSum();
    }

    @Test
    public void testHashSetApproach(){
//        int[] nums = new int[] {4,13,1,2,9,-11,18,21};
        int[] nums = new int[] { 3,1,2,-6,5,-8,6};
        int targetSum = -12;
//        int targetSum = 25;
        int[] res = TwoNumberSum.hashSetBasedApproach(nums,targetSum);
        if(res!=null){
            System.out.println(res[0]+","+res[1]);
            int sum = Arrays.stream(res).sum();
            assertThat(sum).isEqualTo(targetSum);
        }

    }

    @Test
    public void testArrayApproach(){
        int[] nums = new int[] {4,13,1,2,9,-11,18,21};
        int targetSum = -2;
        int[] res = TwoNumberSum.arrayBasedApproach(nums,targetSum);
        System.out.println(res[0]+","+res[1]);
        int sum = Arrays.stream(res).sum();
        assertThat(sum).isEqualTo(targetSum);
    }

}