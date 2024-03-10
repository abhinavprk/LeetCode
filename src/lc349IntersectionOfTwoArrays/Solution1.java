package lc349IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1,2,2,1}, new int[]{2,2})));
        System.out.println(Arrays.toString(intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersection(nums2, nums1);
        }

        Set<Integer> num1HashSet = new HashSet<>();
        for (int val : nums1) {
            num1HashSet.add(val);
        }
        Set<Integer> resultHashSet = new HashSet<>();
        for (int val : nums2) {
            if (num1HashSet.contains(val)) {
                resultHashSet.add(val);
            }
        }
        int[] resultArray = new int[resultHashSet.size()];
        int i = 0;
        for (int val : resultHashSet) {
            resultArray[i] = val;
            i++;
        }
        return resultArray;
    }
}
