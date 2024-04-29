package lc88MergeSortedArray;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3)));
        System.out.println(Arrays.toString(merge(new int[]{1}, 1, new int[]{}, 0)));

    }

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int indexNum1 = m;
        for(int val : nums2){
            nums1[indexNum1] = val;
            indexNum1++;
        }
        Arrays.sort(nums1);
        return nums1;
    }
}