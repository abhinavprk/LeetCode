package lc15ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if ((i == 0) || (nums[i - 1] != nums[i])) {
                var seen = new HashSet<Integer>();
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -(nums[i] + nums[j]);
                    if (seen.contains(complement)) {
                        result.add(Arrays.asList(nums[i], nums[j], complement));
                        while (j + 1 < nums.length && nums[j] == nums[j + 1])
                            ++j;
                    }
                    seen.add(nums[j]);
                }
            }
        }
        return result;
    }
}
