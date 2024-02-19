package lc189RotateArray;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {-1, -100, 3, 99};
        System.out.println(Arrays.toString(nums2));
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));
    }

    private static void rotate(int[] nums, int k) {
        reverseArray(nums, 0, nums.length);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length);

    }


    private static void reverseArray(int[] input, int start, int end) {
        while (start < end) {
            int temp = input[start];
            input[start] = input[end - 1];
            input[end - 1] = temp;
            end--;
            start++;
        }

    }
}
