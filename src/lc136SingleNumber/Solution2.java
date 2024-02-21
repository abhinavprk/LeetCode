package lc136SingleNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }

    private static int singleNumber(int[] nums) {
        int sumOfSet = 0;
        int sumOfNums = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sumOfNums += num;
        }
        return 2 * sumOfSet - sumOfNums;
    }
}
