package lc189RotateArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
      //  int [] nums = {1,2,3,4,5,6,7};
      //  int k = 3;
      //  rotate(nums,k);
      //  System.out.println(Arrays.toString(nums));

        int [] nums2 = {-1,-100,3,99};
        int k2 = 2;
        rotate(nums2,k2);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * This solution doesn't work and ends in the loop for exchange
     * @param nums input array
     * @param k the number of steps to which array has to be rotated
     */
    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int replacedVal = nums[0]; ;
        int replacedIndex = 0;
        int count = 0;
        while(count <= nums.length){
            int next = (replacedIndex + k) % nums.length;
            int val = nums[next];
            nums[next] = replacedVal;
            replacedVal = val;
            replacedIndex = next;
            count++;
        }


    }
}
