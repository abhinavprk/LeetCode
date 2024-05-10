package lc34FindFirstAndLastOccurrenceOfANumber;

import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }


    private static int[] searchRange(int[] nums, int target) {
        int[] result;
        int firstOccurrence = findBound(nums, target, true);
        if (firstOccurrence == -1) {
            result = new int[]{-1, -1};
        } else {
            int lastOccurrence = findBound(nums, target, false);
            result = new int[]{firstOccurrence, lastOccurrence};
        }
        return result;
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int index = -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (isFirst) {
                    // This means we need to find our lower bound.
                    if (mid == low || nums[mid - 1] != target) {
                        //We have found lower bound
                        index = mid;
                        break;
                    }
                    // Search on the left side for the bound.
                    high = mid - 1;
                } else {
                    // This means we need to find our upper bound.
                    if (mid == high || nums[mid + 1] != target) {
                        //we have found our upper bound
                        index = mid;
                        break;
                    }
                    // Search on the right side for the bound.
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}
