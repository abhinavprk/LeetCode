package lc88MergeSortedArray;

import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{2, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1}, 1, new int[]{}, 0)));

    }

    /*
    The provided merge function implements a merge operation for two sorted arrays with improved efficiency compared to the previous approach. Let's analyze its time and space complexity:

    Time Complexity:

        The main loop iterates while left < m, right < n, and num1Index < m + n. In the worst case, this happens when all elements need comparison (m + n iterations).
    Additionally, there are separate loops to copy remaining elements from nums2 and nums1Read (at most n and m iterations each).
    Considering the worst case:

    Total iterations = (m + n) + n + m
    This simplifies to O(m + n)
    Therefore, the time complexity of the merge function is O(n + m), which is significantly better than O(n^2) in the previous approach.

    Space Complexity:

    The function creates an additional array nums1Read of size m to store a copy of the first m elements from nums1.
    This introduces extra space usage compared to the previous approach that modified nums1 in-place.
     Therefore, the space complexity of the merge function is O(m) due to the auxiliary array.

    In summary:

    Time Complexity: O(n + m) (better than O(n^2))
    Space Complexity: O(m) (due to the nums1Read array)
     */

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Read = new int[m];
        System.arraycopy(nums1, 0, nums1Read, 0, m);
        int left = 0; //First index of the nums1Read array
        int right = 0; //First index of the nums2 array
        int num1Index = 0;
        while ((num1Index < (m + n)) && (right < n) && (left < m)) {
            if (nums1Read[left] > nums2[right]) {
                nums1[num1Index] = nums2[right];
                right++;
            } else if (nums1Read[left] < nums2[right]) {
                nums1[num1Index] = nums1Read[left];
                left++;
            } else {
                nums1[num1Index] = nums1Read[left];
                left++;
                num1Index++;
                nums1[num1Index] = nums2[right];
                right++;
            }
            num1Index++;
        }
        while (right < n) {
            nums1[num1Index++] = nums2[right++];
        }
        while (left < m) {
            nums1[num1Index++] = nums1Read[left++];
        }
        return nums1;
    }

}
