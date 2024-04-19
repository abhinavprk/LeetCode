package lc18FourSum;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
        System.out.println(fourSum(new int[]{2,2,2,2,2},8));
        System.out.println(fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long sumIJ = nums[i] + nums[j];
                Set<Long> visited = new HashSet<>();
                for (int k = j+1; k < nums.length; k++) {
                    long sumIJK = sumIJ + nums[k];
                    long fourth = (target - sumIJK);
                    if(visited.contains(fourth)){
                        List<Integer> indices = Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                        Collections.sort(indices);
                        if(!result.contains(indices)) {
                            result.add(indices);
                        }
                    }
                    visited.add((long) nums[k]);
                }
            }

        }

        return result;
    }
}
