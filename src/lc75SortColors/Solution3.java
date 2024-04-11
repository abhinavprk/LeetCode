package lc75SortColors;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        sortColors(new int[]{1, 2, 0});
    }

    private static void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int curr = 0;

        while (curr <= right) {
            int val = nums[curr];
            if (val == 0) {
                swapValues(nums, curr, left);
                left++;
                curr++;
            } else if (val == 2) {
                swapValues(nums, curr, right);
                right--;
            } else {
                curr++;
            }


        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swapValues(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
