package com.v33rh0ra.codingquestions.arrays;

public class SortedSquaredArray {

    public static int[] optimalArrayBasedApproach(int[] array) {
        int[] res = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        for(int i = array.length - 1; i>=0; i--){
            if(Math.abs(array[left]) > Math.abs(array[right])){
                res[i] = array[left] * array[left];
                left++;
            }else{
                res[i] = array[right] * array[right];
                right--;
            }
        }
        return res;

    }


    public static int[] arrayBasedApproach(int[] nums){
        /* handle corner cases */
        if(nums==null || nums.length == 0){
            return nums;
        }
        if(nums.length == 1){
            return new int[] {nums[0]*nums[0]};
        }
        /*main logic*/
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length -1;
        int resPtr = nums.length - 1;
        while(left < right ){
            int numLeft = nums[left];
            int numRight = nums[right];
            System.out.println("left:"+numLeft+", right:"+numRight+",res:"+resPtr);
            if(Math.abs(numLeft) > Math.abs(numRight)){
                res[resPtr] = numLeft * numLeft;
                System.out.println("res:"+res[resPtr]);
                left++;
                resPtr--;
            }else if (Math.abs(numLeft) < Math.abs(numRight)){
                res[resPtr] = numRight * numRight;
                System.out.println("res:"+res[resPtr]);
                resPtr--;
                right--;
            }else{
                res[resPtr] = numLeft * numLeft;
                System.out.println("res:"+res[resPtr]);
                resPtr--;
                res[resPtr] = numRight * numRight;
                System.out.println("res:"+res[resPtr]);
                resPtr--;
                left++;
                right--;
            }

        }
        if(resPtr==0){
            res[resPtr] = nums[left]* nums[left];
        }
        return res;
    }

}
