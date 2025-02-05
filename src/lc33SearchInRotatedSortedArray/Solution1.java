package lc33SearchInRotatedSortedArray;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5, 1, 3}, 5));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[]{1}, 0));
    }

    private static int search(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                result = mid;
                break;
            } else if (midVal >= nums[low]) {
                //This means that the elements in the left are sorted
                if ((nums[low] <= target) && (target < midVal)) {
                    //target is grater than the lower boundary, and smaller than midVal
                    // element exists in the left subarray
                    high = mid - 1;
                } else {
                    // element exist in the right subarray
                    low = mid + 1;
                }
            } else {
                //This means the elements in the right of mid are sorted
                if ((midVal < target) && (target <= nums[high])) {
                    // if target is bigger than midVal and smaller than the high value
                    // element exists in the right subarray
                    low = mid + 1;
                } else {
                    // element exist in the left subarray
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}
