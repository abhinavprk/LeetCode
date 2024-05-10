package lc34FindFirstAndLastOccurrenceOfANumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }


    /*
        Time Complexity:

        searchRange: O(log N) + O(log N) = O(log N)

        The findLeftMostIndex and findRightMostIndex functions each use a binary search approach,
        which has a time complexity of O(log N) due to the efficient halving of the search space in each iteration.
        Since both functions are called once in searchRange, the overall time complexity is dominated by the
        logarithmic term, resulting in O(log N).

        findLeftMostIndex and findRightMostIndex: O(log N)

        These functions employ binary search, which iteratively compares the target element with the middle element
        of a subarray and discards half of the search space based on the comparison.
        In the worst case, the binary search needs to iterate log2(N) times (where N is the length of the input array)
         to find the target element or determine its absence.

        Space Complexity:

        searchRange: O(1)

        The method creates a fixed-size array result to store the leftmost and rightmost indices (constant space).
        It doesn't use any additional data structures that grow with the input size.
        findLeftMostIndex and findRightMostIndex: O(1)

        Similar to searchRange, these functions use constant extra space for variables like ind, low, and high.
        They don't introduce any data structures that scale with the input size.
        Explanation:

        The searchRange method combines two binary searches to find the target element's range in a sorted array.
        The findLeftMostIndex and findRightMostIndex functions implement a standard binary search to locate the target
        and then iterate linearly in either direction (left or right) to find the first/last occurrence of the target within the array.
         */
    private static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findLeftMostIndex(nums, target);
        result[1] = findRightMostIndex(nums, target);
        return result;
    }

    private static int findRightMostIndex(int[] nums, int target) {
        int ind = -1;
        int low = 0;
        int high = nums.length - 1;
        //Find the postion of the target in the array
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                ind = mid;
                break;
            }
        }
        int result = ind;
        //Since nums array is an ascending sorted array find the right most index that has the value equal to the target
        while ((result + 1 < nums.length) && (nums[result + 1] == target)) {
            result++;
        }
        return result;
    }

    private static int findLeftMostIndex(int[] nums, int target) {
        int ind = -1;
        int low = 0;
        int high = nums.length - 1;
        //Find the postion of the target in the array
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                ind = mid;
                break;
            }
        }
        int result = ind;
        //Since nums array is an ascending sorted array find the left most index that has the value equal to the target
        while ((result - 1 >= 0) && (nums[result - 1] == target)) {
            result--;
        }
        return result;
    }
}
