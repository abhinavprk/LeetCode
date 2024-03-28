package lc2958LengthOfLongestSubarrayWithAtMostKFrequency;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 2, 1, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{2, 2, 3}, 1));
    }
    private static int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int start = -1;
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int end = 0; end < nums.length; end++) {
            frequency.put(nums[end], frequency.getOrDefault(nums[end], 0) + 1);
            while (frequency.get(nums[end]) > k) {
                start++;
                frequency.put(nums[start], frequency.get(nums[start]) - 1);
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}
