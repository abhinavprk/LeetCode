package lc448FindAllMissingNumbersFromArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(findAllMissingNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findAllMissingNumbers(new int[]{1, 1}));
    }

    private static List<Integer> findAllMissingNumbers(int[] nums) {
        var numCount = nums.length;

        for (int num : nums) {
            var index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (var i = 0; i < numCount; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
