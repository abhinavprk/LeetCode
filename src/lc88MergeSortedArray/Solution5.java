package lc88MergeSortedArray;

import java.util.Arrays;

public class Solution5 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{2, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1}, 1, new int[]{}, 0)));

    }


    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backward through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            //The idea is that the last n elements in nums1 are 0, they could be filled with the elements from
            //nums2. We start from m-1 and n-1, the value which is greater is put at the index m+n-1 in nums1.
            //If the greater value is from nums1, it is moved to a later index otherwise the value from nums2 is consumed.
            //Since the arrays are sorted, once the nums2 array is completely consumed, the array nums1 will contain
            //all the values from nums1 ans nums2 in sorted order
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }

        return nums1;
    }

}
