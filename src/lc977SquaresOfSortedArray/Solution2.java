package lc977SquaresOfSortedArray;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    private static int[] sortedSquares(int[] nums) {
        for(int i=0; i< nums.length; i++){
            int curr = nums[i];
            nums[i]= curr*curr;
        }
        Arrays.sort(nums);
        return nums;
    }
}
