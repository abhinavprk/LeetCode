package lc1TwoSum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Will not work because it is not necessary that only two consecutive values will add up to target
 */
public class FifthSolutionSlidingWindow {

    public static void main(String[] args) {

        int [] nums = new int[]{2, 5, 8, 3};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2]; // The resulting array can contain only two elements
        int [][] numsAndIndex = new int[nums.length][2];

        for(int inputIndex = 0; inputIndex < nums.length; inputIndex++){
            numsAndIndex[inputIndex][0] = nums[inputIndex];
            numsAndIndex[inputIndex][1] = inputIndex;
        }
        Arrays.sort(numsAndIndex, Comparator.comparing(a -> a[0]));

        for(int inputIndex = 0; inputIndex < nums.length; inputIndex++){
            int firstVal = numsAndIndex[inputIndex][0];
            int secondVal = numsAndIndex[0][0];
            if(inputIndex == nums.length -1) {
                secondVal = numsAndIndex[inputIndex + 1][0];
            }
            if(firstVal + secondVal == target) {
                result[0] = numsAndIndex[inputIndex][1];
                result[1] = numsAndIndex[0][1];
                if(inputIndex == nums.length -1) {
                    result[1] = numsAndIndex[inputIndex + 1][1];
                }
                break;
            }
        }
        return result;
    }
}
