package lc977SquaresOfSortedArray;

import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
        int[] nums1 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
    }

    private static int[] sortedSquares(int[] nums) {
       //Check if the list has a negative number in it
        if(nums[0]>=0){
            //loop through and square all the numbers
            return squareTheNumbers(nums);
        } else {
            //Split the array into negative and positive arrays.
            //For this first find the index of first positive element
            int firstPositiveIndex = -1;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i]>=0){
                    firstPositiveIndex = i;
                    break;
                }
            }
            //There are two conditions
            if(firstPositiveIndex == -1){
                //Reverse the array
                reverseArray(nums);
                //square the elements and return
                return squareTheNumbers(nums);
            } else {
                //We found the index of fist positive
                int lengthPositive = nums.length - firstPositiveIndex;
                int[] negativeNums = new int[firstPositiveIndex];
                int[] positiveNums = new int[lengthPositive];
                System.arraycopy(nums, 0, negativeNums, 0, firstPositiveIndex);
                System.arraycopy(nums, firstPositiveIndex, positiveNums, 0, lengthPositive );
                //We have array with negative nums, reverse it first
                reverseArray(negativeNums);
                //square the numbers
                int[] sqNegative = squareTheNumbers(negativeNums);
                //square the positive numbers
                int[] sqPositive = squareTheNumbers(positiveNums);
                return mergeSortedArrays(sqNegative, sqPositive);
            }
        }
    }

    private static int[] mergeSortedArrays(int[] sqNegative, int[] sqPositive) {
        int [] mergedNums = new int[sqPositive.length + sqNegative.length];
        int pIndex = 0;
        int nIndex = 0;
        int mIndex = 0;
        while((pIndex < sqPositive.length) && (nIndex < sqNegative.length))
        {
            int valNeg = sqNegative[nIndex];
            int valPos = sqPositive[pIndex];
            if(valNeg <= valPos){
                mergedNums[mIndex] = valNeg;
                nIndex++;
            }else {
                mergedNums[mIndex] = valPos;
                pIndex++;
            }
            mIndex++;
        }

        while(pIndex < sqPositive.length){
            mergedNums[mIndex] = sqPositive[pIndex];
            pIndex++;
            mIndex++;
        }

        while(nIndex < sqNegative.length){
            mergedNums[mIndex] = sqNegative[nIndex];
            nIndex++;
            mIndex++;
        }
        return mergedNums;
    }

    private static int[] squareTheNumbers(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    private static void reverseArray(int[] nums){
        //Reverse the array
        int firstIndex = 0;
        int lastIndex = nums.length-1;
        while(firstIndex < lastIndex){
            int temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
    }
}
