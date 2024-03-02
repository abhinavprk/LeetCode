package lc41FirstMissingPositive;

import java.util.Arrays;
/*
O(nlogn) solution
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));

    }

    private static int firstMissingPositive(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int missingVal =0;
        int countPositive = 0;
        for (int curr : nums) {
            if (curr > 0) {
                countPositive++;
                if (curr < smallest) {
                    smallest = curr;
                }
                if (curr > largest) {
                    largest = curr;
                }
            }
        }
        Arrays.sort(nums);
        if (smallest > 1) {
            missingVal = 1;
        } else {
            for(int i = 2; i<= countPositive+1; i++){
                int res = Arrays.binarySearch(nums, i);
                if(res < 0){
                    missingVal = i;
                    break;
                }
            }
        }
        return missingVal;
    }
}
