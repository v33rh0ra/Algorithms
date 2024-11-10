package com.v33rh0ra.codingquestions.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*

 */
public class TwoNumberSum {

    /*
    Hashset based approach
    O(n)T, O(2n)s
     */
    public static int[] hashSetBasedApproach(int[] array, int targetSum){
        Set<Integer> traversedSet = new HashSet<>();

        for (int x : array){
            int y = targetSum - x;
            if(traversedSet.contains(y)){
                return new int[] { x, y};

            }else{
                traversedSet.add(x);
            }

        }
        return null;
    }

    public static int[] arrayBasedApproach(int[] nums, int targetSum){
        int[] res = null;
        Arrays.sort(nums);
//        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf)
//                .collect(Collectors.joining(",")));

        int l = 0;
        int h = nums.length - 1;
        while (l<h){
            int lVal = nums[l];
            int rVal = nums[h];
//            System.out.println("l:"+lVal+", r:"+rVal);
            int intSum = lVal + rVal;
            if (intSum == targetSum){
                res = new int[]{lVal, rVal};
                break;
            }else if(intSum < targetSum){
                l++;
            }else if(intSum > targetSum){
                h--;
            }
        }

        return res;
    }
}
