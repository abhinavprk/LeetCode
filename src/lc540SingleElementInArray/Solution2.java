package lc540SingleElementInArray;

public class Solution2 {

    public static void main(String[] args) {

        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(singleNonDuplicate(new int[]{1}));
    }

    private static int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            // The elements in the array are in pair like 0-1 2-3 4-5 until a single element is found
            // 0-1 2-3 4-5 6 7-8 9-10
            //mid is and even index, if its value is equal to the value at mid+1 this means that
            //the index of single element is after mid, else before mid.
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

}
