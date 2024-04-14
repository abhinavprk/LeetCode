package lc15ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {

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
                int first = nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if ((nums[j] + nums[k]) == -first) {
                        result.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                    } else if ((nums[j] + nums[k]) > -first) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
