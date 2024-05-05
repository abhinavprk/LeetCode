package lc493ReversePairs;

import java.util.Arrays;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs(new int[]{2}));
        System.out.println(reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high-low) / 2;
            count = count + mergeSort(nums, low, mid);
            count = count + mergeSort(nums, low + 1, high);
            count = count + merge(nums, low, high, mid);
        }
        return count;
    }

    private static int  merge(int[] nums, int low, int high, int mid) {
        int count = 0;

        int [] leftArray = Arrays.copyOfRange(nums, low, mid+1);
        int [] rightArray = Arrays.copyOfRange(nums, mid+1, high+1);

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int mainArrayLow = low;

        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if ((long) leftArray[leftArrayIndex] > 2 * (long) rightArray[rightArrayIndex]) {
                count += leftArray.length - leftArrayIndex;
                rightArrayIndex++;
            } else {
                leftArrayIndex++;
            }
        }
        leftArrayIndex = 0;
        rightArrayIndex = 0;

        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                nums[mainArrayLow++] = leftArray[leftArrayIndex++];
            } else {
                nums[mainArrayLow++] = rightArray[rightArrayIndex++];
            }
        }

        while (leftArrayIndex < leftArray.length) {
            nums[mainArrayLow++] = leftArray[leftArrayIndex++];
        }
        while (rightArrayIndex < rightArray.length) {
            nums[mainArrayLow++] = rightArray[rightArrayIndex++];
        }
        return count;
    }
}
