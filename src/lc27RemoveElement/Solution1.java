package lc27RemoveElement;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(nums,val));
    }

    private static int removeElement(int[] nums, int val) {
       int count =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                int k = i-1;
                int l = i;
                while((k>=0) && (nums[k] == val)){
                    int temp = nums[k];
                    nums[k] = nums[l];
                    nums[l] = temp;
                    k--;
                    l--;
                }
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }
}
