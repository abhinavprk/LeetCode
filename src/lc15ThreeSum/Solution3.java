package lc15ThreeSum;

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(threeSum(new int[]{0, 1, 1}));
        //System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                Set<Integer> seen = new HashSet<>();
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.contains(complement)) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.add(nums[j]);
                }
            }
        return res.stream().toList();
    }
}
