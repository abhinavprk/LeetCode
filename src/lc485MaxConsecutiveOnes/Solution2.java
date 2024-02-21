package lc485MaxConsecutiveOnes;

public class Solution2 {
    public static void main(String[] args) {
        int [] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = nums[0];
        for (int i=1; i<nums.length; i++) {
          nums[i] = nums[i] * (nums[i] + nums[i-1]);
          maxConsecutive = Math.max(nums[i], maxConsecutive);
        }
        return maxConsecutive;
    }
}
