package lc75SortColors;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        sortColors(new int[]{1, 2, 0});
    }

    private static void sortColors(int[] nums) {

        // For all idx < i : nums[idx < i] = 0
        // j is an index of elements under consideration
        int p0 = 0, curr = 0;

        // For all idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // Swap p0-th and curr-th elements
                // i++ and j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if (nums[curr] == 2) {
                // Swap k-th and curr-th elements
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            }
            else curr++;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swapValues(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
