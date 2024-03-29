package lc53MaximumSubarray;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        /* System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-1}));*/
    }

    private static int maxSubArray(int[] nums) {

        // Initialize our variables using the first element.
        int currentSubarraySum = nums[0];
        int maxSubarraySum = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarraySum = Math.max(num, currentSubarraySum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
        }

        return maxSubarraySum;
    }
}
