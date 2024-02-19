package lc189RotateArray;

import java.util.Arrays;

public class Solution4 {
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
        k = k % nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++) {
            int prev = nums[start];
            int current = start;
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}

