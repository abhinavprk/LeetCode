package lc349IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {

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
        Set<Integer> num2HashSet = new HashSet<>();
        for (int val : nums2) {
            num2HashSet.add(val);
        }
        num1HashSet.retainAll(num2HashSet);
        return  num1HashSet.stream().mapToInt(a-> a).toArray();
    }
}
