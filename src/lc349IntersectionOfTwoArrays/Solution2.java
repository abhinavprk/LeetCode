package lc349IntersectionOfTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
    /*
    Time Complexity:

    O(n log n + m log m + k)
    Explanation:
    Sorting nums1 and nums2 takes O(n log n) and O(m log m) time, respectively.
    The getCommonNums method uses a two-pointer approach to iterate through both
    sorted arrays, taking a total of O(k) time, where k is the size of the intersection.
    Converting the set back to an array takes O(k) time.
    Space Complexity:

    O(min(m, n) + k)
    Explanation:
    The largest set (resultHashSet) can hold at most min(m, n) elements.
    The final resultArray holds k elements.
    Other variables and data structures contribute constant space, O(1).
     */

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> resultHashSet = getCommonNums(nums1, nums2);
        return resultHashSet.stream().mapToInt(a -> a).toArray();
    }

    private static Set<Integer> getCommonNums(int[] nums1, int[] nums2) {
        Set<Integer> resultHashSet = new HashSet<>();
        int nums1Index = 0;
        int nums2Index = 0;
        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            int currNum1 = nums1[nums1Index];
            int currNum2 = nums2[nums2Index];
            if (currNum1 == currNum2) {
                resultHashSet.add(nums1[nums1Index]);
                nums1Index++;
                nums2Index++;
            } else if (currNum1 > currNum2) {
                nums2Index++;
            } else {
                nums1Index++;
            }
        }
        return resultHashSet;
    }
}
