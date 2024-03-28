package lc2958LengthOfLongestSubarrayWithAtMostKFrequency;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 2, 1, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{2, 2, 3}, 1));
    }

    private static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> frequency = new HashMap<>();
        int start = 0;
        int charsWithFreqOverK = 0;

        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            if (frequency.get(num) == k + 1) {
                charsWithFreqOverK++;
            }
            if (charsWithFreqOverK > 0) {
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
                if (frequency.get(nums[start]) == k) {
                    charsWithFreqOverK--;
                }
                start++;
            }
        }
        return n - start;
    }
}
