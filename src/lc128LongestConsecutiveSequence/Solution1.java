package lc128LongestConsecutiveSequence;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(longestConsecutive(new int[]{}));
    }
    private static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 1;
        if (nums.length == 0) {
            longest = 0;
        } else {
            int count = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i] + 1) {
                    count++;
                    longest = Math.max(count, longest);
                } else if(nums[i + 1] == nums[i]){
                    continue;
                } else{
                    count =1;
                }
            }
        }
        return longest;
    }
}
