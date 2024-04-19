package lc18FourSum;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
        System.out.println(fourSum(new int[]{2,2,2,2,2},8));
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                long sumIJ = nums[i] + nums[j];
                int k = j+1;
                int l = nums.length-1;
                while(k<l) {
                    long sum = sumIJ + nums[k] + nums[l];
                    if ( sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        do {
                            k++;
                        } while ((k < l) && nums[k] == nums[k - 1]);

                        do {
                            l--;
                        } while ((k < l) && nums[l] == nums[l + 1]);
                    } else if(sum > target){
                        do {
                            l--;
                        } while ((k < l) && nums[l] == nums[l + 1]);
                    } else {
                        do {
                            k++;
                        } while ((k < l) && nums[k] == nums[k - 1]);
                    }
                }
            }

        }

        return result;
    }
}
