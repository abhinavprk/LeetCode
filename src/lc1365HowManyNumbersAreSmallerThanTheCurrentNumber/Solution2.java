package lc1365HowManyNumbersAreSmallerThanTheCurrentNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfSmaller(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(numberOfSmaller(new int[]{6, 5, 4, 8})));
        System.out.println(Arrays.toString(numberOfSmaller(new int[]{7, 7, 7, 7})));
    }

    private static int[] numberOfSmaller(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int[] res = new int[nums.length];
        Map<Integer, Integer> sortIndexMap = new HashMap<>();
        for (int i = 0; i <sortedNums.length; i++) {
            if(!sortIndexMap.containsKey(sortedNums[i])){
                sortIndexMap.put(sortedNums[i], i );
            }
        }
        int resIndex = 0;
        for (int num : nums){
            res[resIndex] = sortIndexMap.get(num);
            resIndex++;
        }
        return res;
    }
}
