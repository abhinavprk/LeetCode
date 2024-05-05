package lc88MergeSortedArray;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{2, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1}, 1, new int[]{}, 0)));

    }

    /*
    Time Complexity: O(n^2)
    Space Complexity: O(1)
    Here's a breakdown of the reasoning:

    Time Complexity:

    The dominant factor is the nested loops. The outer while loop iterates up to m+n times in the worst case,
    comparing all elements from both arrays. Additionally, the inner while loop in insertValInArray runs for a
    maximum of lastIndex - left iterations, happening at most m times.
    Combining these loops and considering m and n are of the same order, the time complexity becomes O(m^2 + n^2).
    Since the terms are of the same order, we drop constants resulting in O(n^2).
    Space Complexity:

    The function doesn't allocate any significant additional data structures. It modifies the existing nums1
    array in-place, using temporary variables with constant space cost.
    Therefore, the time complexity is O(n^2) for worst-case scenarios, and the space complexity is O(1) due
    to constant extra space usage.
     */
    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0; //First index of the nums1 array
        int right = 0; //First index of the nums2 array
        // The last index of the actual value in nums1 when a new element will be inserted, initially the last index is m-1, so
        // it would be m if a new element is inserted
        int lastIndex = m;

        //Run the loop until one of the nums1 and nums2 is completely traversed
        while ((left < lastIndex) && (right < n)) {
            int leftVal = nums1[left]; // Value from the nums1
            int rightVal = nums2[right]; // value from the nums2
            if (rightVal < leftVal) {
                //If value from nums2 is smaller than the value from nums1, insert the value from nums2 into nums1
                //at the current index left
                insertValInArray(nums1, rightVal, left, lastIndex);
                //increase the index in nums1, the left index now contains the value from nums2
                left++;
                //increase the index in nums2 and lastIndex
                right++;
                lastIndex++;
            } else {
                //increase the index in nums1 to find the next suitable index where the value from nums2 can be inserted
                left++;
            }
        }
        //if there are still values in nums2 that are not visited yet, insert them in nums1. Because both nums1 ans nums2 are initially
        //sorted in the ascending order, the remaining values in nums2 must be greater than the greatest value in the nums1
        while (right < n) {
            nums1[left++] = nums2[right++];
        }
        return nums1;
    }

    private static void insertValInArray(int[] nums1, int rightVal, int left, int lastIndex) {
        //move values to one index right to make space for the value from nums2 (rightVal)
        //left is the index where the rightValue has to be inserted
        //lastIndex-1 is the index until where the non-zero values are present in nums1
        while (lastIndex > left) {
            nums1[lastIndex] = nums1[--lastIndex];
        }
        nums1[left] = rightVal;
    }
}
