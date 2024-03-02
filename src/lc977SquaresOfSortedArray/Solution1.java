package lc977SquaresOfSortedArray;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int val;
        int iterator = nums.length-1;
        int[] result = new int[nums.length];
        while (left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                val = nums[left];
                left++;
            } else {
                val = nums[right];
                right--;
            }
            result[iterator] = val*val;
            iterator--;
        }
        return result;
    }
}
