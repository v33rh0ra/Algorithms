package com.v33rh0ra.codingquestions.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeNumberSum {
    public static List<Integer[]> hashSetBasedApproach(int[] nums, int targetSum){
        ArrayList<Integer[]> res = new ArrayList<>();
        for (int x : nums) {
//            System.out.println("x = " + x);
            int twoNumberSum = targetSum - x;
            int[] subNums = Arrays.stream(nums)
                    .filter(j-> j!= x).toArray();
            String arrayStr = Arrays.stream(subNums).mapToObj(String::valueOf).collect(Collectors.joining(","));
//            System.out.println(arrayStr);

            int[] twoNumberSumArr = TwoNumberSum.hashSetBasedApproach(
                    subNums,
                    twoNumberSum);

            if (twoNumberSumArr!= null && twoNumberSumArr.length > 0) {
//                && Arrays.stream(twoNumberSumArr).noneMatch(num -> num == x)
//                System.out.println(
//                        Arrays.stream(twoNumberSumArr)
//                                .mapToObj(String::valueOf)
//                                .collect(Collectors.joining(","))
//                );
//                System.out.println("x:"+x+"twoNumberSum: "+twoNumberSum);
                System.out.println(x+","+twoNumberSumArr[0]+","+twoNumberSumArr[1]+":: sum == "+targetSum);
                res.add(new Integer[]{x, twoNumberSumArr[0], twoNumberSumArr[1]});
            }
        }
        return res;
    }

    public static List<Integer[]> arrayBasedApproach(int[] nums, int targetSum){
        ArrayList<Integer[]> res = new ArrayList<>();
        if(nums.length<3){
            return res;
        }else if (nums.length == 3){
            int currentSum = Arrays.stream(nums).sum();
            if (currentSum == targetSum){
                res.add(Arrays.stream(nums).boxed().toArray(Integer[]::new));
                return res;
            }
        }
        Arrays.sort(nums);

//        int currentPtr = 0;
        int left = 1;
        int right = nums.length - 1;
        for (int currentPtr = 0; currentPtr < nums.length - 2; currentPtr++){

            left = currentPtr + 1;
            right = nums.length - 1;
            System.out.println("i:"+currentPtr+", left:"+left+", right:"+right);
            // [-4, 1, 2, 8, 9] : 6 : [ (-4, 1, 9), (-4, 2,8)]
            // [
            while (left < right ){
                int currentSum = nums[currentPtr] + nums[left] + nums[right];
                if(currentSum == targetSum){
                    res.add(new Integer[] {nums[currentPtr], nums[left], nums[right]});
                    left++;
                    right--;
                }else if(currentSum < targetSum){
                    left++;
                }else if (currentSum > targetSum){
                    right--;
                }
                System.out.println("i:"+currentPtr+", left:"+left+", right:"+right);

            }
        }


        return res;
    }
}
