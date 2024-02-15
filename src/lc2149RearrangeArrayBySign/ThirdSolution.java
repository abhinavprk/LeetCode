package lc2149RearrangeArrayBySign;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign
 */
public class ThirdSolution {

    public static void main(String[] args) {
        int[] input = {-3, 1, 2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(input)));
        int[] input1 = {-27, -30, 8, -16, 38, 30, 20, 21, -2, -18, 40, -29};
        System.out.println(Arrays.toString(rearrangeArray(input1)));
    }

    private static int[] rearrangeArray(int[] nums) {
        int[] finalArr = new int[nums.length];
        int posIndex = 0;
        int negIndex = 1;
        for(int val : nums ){
            if(val > 0){
                finalArr[posIndex] = val;
                posIndex = posIndex + 2;
            } else {
                finalArr[negIndex] = val;
                negIndex = negIndex +2;
            }
        }
        return finalArr;

    }
}
