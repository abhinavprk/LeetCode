package lc75SortColors;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1 {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }

    private static void sortColors(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
        for (int val: nums){
            queue.add(val);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!queue.isEmpty()) {
                nums[i] = queue.poll();
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
