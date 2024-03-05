package lc75SortColors;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }

    private static void sortColors(int[] nums) {

        int countZero = 0;
        int countOne = 0;

        for (int val : nums){
            if(val==0){
                countZero++;
            } else if (val == 1) {
                countOne++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(countZero>0){
                nums[i] = 0;
                countZero --;
            } else if(countOne>0){
                nums[i] = 1;
                countOne--;
            } else {
                nums[i] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
