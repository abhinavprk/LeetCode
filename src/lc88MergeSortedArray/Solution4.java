package lc88MergeSortedArray;

import java.util.Arrays;

public class Solution4 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{2, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1}, 1, new int[]{}, 0)));

    }


    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;
        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
        for (int p = 0; p < m + n; p++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            if ((p2 >= n) || ((p1 < m) && (nums1Copy[p1] < nums2[p2]))) {
                //If p2>=n this means all the elements from nums2 are already consumed, this means that
                //we should push the values from nums1copy to nums1

                //if p2<n then check if nums2[p2] is smaller than nums1Copy[p1], if not push value from
                //nums1Copy to nums1
                nums1[p] = nums1Copy[p1++];
            } else {
                //Otherwise if nums2 is not consumed, and nums2[p2] is smaller, push the value from nums2 to nums1
                nums1[p] = nums2[p2++];
            }
        }

        return nums1;
    }

}
