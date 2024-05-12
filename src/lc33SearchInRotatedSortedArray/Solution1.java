package lc33SearchInRotatedSortedArray;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5,1,3}, 5));
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
                if ((nums[low] <= target) && (target <= midVal)) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else {
                if ((midVal <= target) && (target <= nums[high])) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return result;
    }
}
