package lc169MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{1,3,1,1,4,1,1,5,1,1,6,2,2}));
    }

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int majCount = 1;
        int majVal = nums[0];
        int localCount = 1;
        for (int i=0; i<nums.length-1;i++) {
            if(nums[i] == nums[i+1]){
                localCount++;
                if(i == nums.length-2){
                    if(majCount < localCount) {
                        majCount = localCount;
                        majVal = nums[i];
                    }
                }
            } else if((nums[i] != nums[i+1])){
                if(majCount < localCount) {
                    majCount = localCount;
                    majVal = nums[i];
                }
                localCount = 1;
            }
        }
        return majVal;
    }
}
