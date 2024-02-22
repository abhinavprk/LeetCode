package lc27RemoveElement;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(nums,val));
    }

    private static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[count] = nums[j];
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
}
