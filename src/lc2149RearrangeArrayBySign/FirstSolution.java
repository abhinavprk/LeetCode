package lc2149RearrangeArrayBySign;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign
 */
public class FirstSolution {

    public static void main(String[] args) {
        int[] input = {3,1,-2,-5,2,-4};

        System.out.println(Arrays.toString(rearrangeArray(input)));
    }

    private static int[] rearrangeArray(int[] nums) {
        int subArrayLength = nums.length/2;
        int[] positive = new int[subArrayLength];
        int[] negative = new int[subArrayLength];
        int[] finalArr = new int[nums.length];

        int posIndex = 0;
        int negIndex = 0;
        //Store the positive and negative values in two different arrays
        for(int val : nums){
            if(val < 0){
                negative[negIndex] = val;
                negIndex++;
            }else{
                positive[posIndex] = val;
                posIndex++;
            }
        }
        posIndex = 0;
        negIndex = 0;
        //Merge the positive and negative arrays alternatively.
        for(int index = 0; index < nums.length; index++){
            if(index % 2 == 0){
                finalArr[index] = positive[posIndex];
                posIndex++;
            } else {
                finalArr[index] = negative[negIndex];
                negIndex++;
            }
        }
        return finalArr;

    }
}
