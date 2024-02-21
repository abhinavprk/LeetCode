package lc283MoveZeroes;

import java.util.Arrays;

public class Solution2 {

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
        int[] array = new int[nums.length];
        int arrayIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                array[arrayIndex] = num;
                arrayIndex++;
            }
        }
        return array;
    }
}
