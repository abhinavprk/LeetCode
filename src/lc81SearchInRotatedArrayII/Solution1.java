package lc81SearchInRotatedArrayII;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1}, 1));
        System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }

    private static boolean search(int[] nums, int target) {
        boolean result = false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = nums[mid];
            if (midVal == target) {
                result = true;
                break;
            } else if((nums[low]==midVal) && (nums[high]==midVal)) {
                //If low, mid, and high are equal, we can ignore those values
                high = high - 1;
                low = low + 1;
            }else if (midVal >= nums[low]) {
                //This means that the elements in the left are sorted
                if ((nums[low] <= target) && (target < midVal)) {
                    //target is greater than the lower boundary, and smaller than midVal
                    //element exists in the left subarray
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
