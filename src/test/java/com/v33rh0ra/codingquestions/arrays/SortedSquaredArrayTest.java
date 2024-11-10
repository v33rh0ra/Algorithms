package com.v33rh0ra.codingquestions.arrays;


import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class SortedSquaredArrayTest {

    @Test
    public void testArrayBasedApproachOdd() {
        int[] nums = new int[] {1,2,3,5,6,8,9};
        int[] expected = new int[] {1, 4, 9, 25, 36, 64, 81};
        int[] actual = SortedSquaredArray.arrayBasedApproach(nums);
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testArrayBasedApproachEven() {
        int[] nums = new int[] {1,2,3,5,6,8};
        int[] expected = new int[] {1, 4, 9, 25, 36, 64};
        int[] actual = SortedSquaredArray.arrayBasedApproach(nums);
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testArrayBasedApproachNegative() {
        int[] nums = new int[] {-8,1,2,3,5,6,9,100};
        int[] expected = new int[] {1, 4, 9, 25, 36, 64, 81,10000};
        int[] actual = SortedSquaredArray.arrayBasedApproach(nums);
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void testArrayBasedApproachZero() {
        int[] nums = new int[] {0};
        int[] expected = new int[] {0};
        int[] actual = SortedSquaredArray.arrayBasedApproach(nums);
        assertThat(actual).isEqualTo(expected);

    }

}