package lc1365HowManyNumbersAreSmallerThanTheCurrentNumber;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfSmaller(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(numberOfSmaller(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(numberOfSmaller(new int[]{7, 7, 7, 7})));
    }

    private static int[] numberOfSmaller(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int smallCount = 0;
            for (int num : nums) {
                if (num < curr) {
                    smallCount++;
                }
            }
            res[i] = smallCount;
        }
        return res;
    }
}
