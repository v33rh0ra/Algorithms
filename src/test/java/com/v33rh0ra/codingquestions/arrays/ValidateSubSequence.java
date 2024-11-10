package com.v33rh0ra.codingquestions.arrays;

import java.util.List;

public class ValidateSubSequence {

    public static boolean arrayBasedApproach(List<Integer> nums, List<Integer> sequence){

        /* handle corner cases*/
        if (nums == null || sequence == null || nums.isEmpty() || sequence.isEmpty()){
            return false;
        }
        if (nums.size() < sequence.size()){
            return false;
        }
        /*main logic*/
        int numIndex = 0;
        int seqIndex = 0;
        int lenSeqFound = 0;
        while (numIndex < nums.size() && seqIndex < sequence.size()){
            int numVal = nums.get(numIndex);
            int seqVal = sequence.get(seqIndex);
            if(numVal == seqVal){
                lenSeqFound++;
                numIndex++;
                seqIndex++;
            }else {
                numIndex++;
            }
        }
        return lenSeqFound == sequence.size();

    }
}
