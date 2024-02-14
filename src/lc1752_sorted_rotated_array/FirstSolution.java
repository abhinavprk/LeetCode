package lc1752_sorted_rotated_array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/">...</a>
 * <p>
 * Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
 * <p>
 * There may be duplicates in the original array.
 * <p>
 * Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: nums = [3,4,5,1,2]
 * Output: true
 * Explanation: [1,2,3,4,5] is the original sorted array.
 * You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
 * Example 2:
 * <p>
 * Input: nums = [2,1,3,4]
 * Output: false
 * Explanation: There is no sorted array once rotated that can make nums.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: true
 * Explanation: [1,2,3] is the original sorted array.
 * You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class FirstSolution {
    public static void main(String[] args) {

        int [] array0 = {2, 1};
        System.out.println(isSorted(array0));

        int [] array = {3, 4, 5, 1, 2};
        System.out.println(isSorted(array));

        int [] array1 = {2, 1, 3, 4};
        System.out.println(isSorted(array1));

        /*int [] array3 = {1, 2, 3};
        System.out.println(isSorted(array3));

        int [] emptyArray = {};
        System.out.println(isSorted(emptyArray));

        int [] oneArray = {1};
        System.out.println(isSorted(oneArray));

        int [] sameArray = {1, 1, 1};
        System.out.println(isSorted(sameArray));*/
    }

    private static boolean isSorted(int[] nums) {
        int rotations = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            // ((i+1) % length) returns the same value as (i+1) in case of (i < length)
            // ((i+1) % length) returns 0 in case of (i = length). This will happen when i == length -1
            // We check the number of instances in the array when current element is greater than the
            // next element. There could be only one such instance in a sorted and rotated array. If the
            // array is not sorted or sorted in descending order, there will be more than such instances.
            if (nums[i] > nums[(i + 1) % length])
                rotations += 1;
            if(rotations >1){
                return false;
            }

        }
        return true;
    }
}
