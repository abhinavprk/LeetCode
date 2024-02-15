package lc1TwoSum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Use Two pointers to calculate values
 * Time Complexity = O(nlogn)
 * Space Complexity = O(1)
 */
public class FourthSolutionTwoPointer {

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
        int left = 0;
        int right = numsAndIndex.length-1;
        while(left < right) {
            int sum = numsAndIndex[left][0] + numsAndIndex[right][0];
            if(sum == target ){
                result[0] = numsAndIndex[left][1];
                result[1] = numsAndIndex[right][1];
            } else if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
