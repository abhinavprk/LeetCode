package lc1TwoSum;

import java.util.Arrays;

/**
 * Will not work because it is not necessary that only two consecutive values will add up to target
 */
public class SixthSolution {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 8, 3};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int j = 1;

        while (j < nums.length) {
            for (int i = 0; i + j < nums.length; i++) {
                if (target == nums[i] + nums[i + j]) {
                    result[0] = i;
                    result[1] = i + j;
                    return result;
                }
            }
            j++;
        }
        return result;
    }
}
