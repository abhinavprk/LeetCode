package lc485MaxConsecutiveOnes;

public class Solution1 {
    public static void main(String[] args) {
        int [] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int consecutiveOneCount = 0;
        int maxConsecutive = 0;
        for (int val : nums) {
            if (val == 1) {
                consecutiveOneCount++;
                maxConsecutive = Math.max(maxConsecutive, consecutiveOneCount);
            } else {
                consecutiveOneCount = 0;
            }
        }
        return maxConsecutive;
    }
}
