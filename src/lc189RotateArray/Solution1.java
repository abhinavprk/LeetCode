package lc189RotateArray;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int index = 0; index < nums.length; index++){
            result[(index+k) % nums.length] = nums[index];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);

    }
}
