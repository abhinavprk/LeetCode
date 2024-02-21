package lc283MoveZeroes;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int [] input = {0,1,0,3,12};
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(moveZeroes(input)));
        int[] input2 = {4,2,4,0,0,3,0,5,1,0};
        System.out.println();
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(moveZeroes(input2)));

    }

    private static int[] moveZeroes(int[] nums) {
        for (int i = 0, j = i + 1; i < nums.length-1; i++, j++) {
            int k = j;
            if ((nums[i] == 0)) {
                while ((k < nums.length-1) && (nums[k] == 0) ) {
                    k++;
                }
                nums[i] = nums[k];
                nums[k] = 0;
            }
            if(k == nums.length-1){
                break;
            }
        }
        return nums;
    }
}
