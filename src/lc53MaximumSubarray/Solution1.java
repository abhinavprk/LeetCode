package lc53MaximumSubarray;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[]{-1}));
    }

    private static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for (int left = 0; left < nums.length; left++) {
            int newSum = 0;
            for (int right = left; right < nums.length; right++) {
                newSum = newSum + nums[right];
                sum = Math.max(sum, newSum);
            }
        }
        return sum;
    }
}
