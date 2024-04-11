package lc128LongestConsecutiveSequence;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
        System.out.println(longestConsecutive(new int[]{}));
    }
    private static int longestConsecutive(int[] nums) {
        int longest = 1;
        if (nums.length == 0) {
            longest = 0;
        } else {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int val: nums){
                queue.add(val);
            }
            int count = 1;
            int prev = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                if (curr == prev+1) {
                    count++;
                    longest = Math.max(count, longest);
                    prev = curr;
                } else if((curr != prev+1)&& (curr != prev)){
                    prev = curr;
                }
            }
        }
        return longest;
    }
}
