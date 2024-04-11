package lc31NextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1, 1, 5});
        nextPermutation(new int[]{2, 1, 5, 4, 3, 0, 0});
    }

    private static void nextPermutation(int[] nums) {
        int[] result = new int[nums.length];
        int i = nums.length - 1;
        List<Integer> list = new ArrayList<>();
        while ((i > 0) && (nums[i] <= nums[i - 1])) {
            list.add(nums[i]);
            i--;
        }
        if (i == 0) {
            Arrays.sort(nums);
            result = nums;
        } else {
            list.add(nums[i]);
            Collections.sort(list);
            int pivotVal = nums[i - 1];
            System.arraycopy(nums, 0, result, 0, i - 2 + 1);
            int exchangeVal = 0;
            int exchangeIndex = 0;
            for (int val : list) {
                if (val > pivotVal) {
                    exchangeVal = val;
                    break;
                }
                exchangeIndex++;
            }
            list.remove(exchangeIndex);
            list.add(pivotVal);
            Collections.sort(list);
            result[i - 1] = exchangeVal;
            for (int val : list) {
                result[i] = val;
                i++;
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
