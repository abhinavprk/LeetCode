package lc448FindAllMissingNumbersFromArray;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(findAllMissingNumbers(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(findAllMissingNumbers(new int[]{1,1}));
    }

    private static List<Integer> findAllMissingNumbers(int[] nums) {
        var numCount = nums.length;
        var presentNumbers = new HashSet<>();

        for (int num : nums) {
            presentNumbers.add(num);
        }
        List<Integer> res = new ArrayList<>();
        for (var i = 1; i <= numCount; i++) {
            if (!presentNumbers.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
