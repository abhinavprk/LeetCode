package lc31NextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1, 1, 5});
        nextPermutation(new int[]{2, 1, 5, 4, 3, 0, 0});
    }

    private static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        //Find the fist index from the right where the value is smaller than the value to the right
        while ((i > 0) && (nums[i] <= nums[i - 1])) {
            i--;
        }
        if (i == 0) {
            //If no such value found, this means that this array is the last possible permutation
            //Just sort the array, it will give the first permutation
            //{5,4,3,2,1} --> No pivot could be found {1,2,3,4,5} will be the answer
            Arrays.sort(nums);
        } else {
            //{2, 1, 5, 4, 3, 0, 0}  here index 1 is the pivot value
            // i-1 will be the first value that is smaller than the value right to it
            int pivotVal = nums[i - 1];
            //Find the least possible value that is greater than the pivot value out of all the values right to it
            //Once found swap the values
            //{2, 3, 5, 4, 1, 0, 0}  found 3 (index 4) and swapped it with 1 (index 1)
            for(int j = nums.length-1; j> i-1; j--){
                if(nums[j]>pivotVal){
                    int temp = nums[j];
                    nums[j] = pivotVal;
                    nums[i-1] = temp;
                    break;
                }
            }
            //Now we need to just sort the values right to the pivot index in ascending order
            //{2, 3, 5, 4, 1, 0, 0}  from index 2 to end has to be sorted
            int beg = i;
            int end = nums.length-1;
            while (beg<end){
                int temp = nums[beg];
                nums[beg] = nums[end];
                nums[end] = temp;
                beg++;
                end--;
            }
            //{2, 3, 0, 0, 1, 4, 5}  is the result
        }

        System.out.println(Arrays.toString(nums));
    }
}
