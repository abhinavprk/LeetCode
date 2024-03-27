package lc713SubarryProductLessThanK;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }

    /*
    The time complexity of the given method is O(n^2).

    Here's a breakdown of why:

    The outer for loop iterates through the entire array nums with n elements, resulting in O(n) complexity.
    Inside the outer loop, there's an inner for loop that iterates in the worst case from i + 1 to nums.length - 1
    (when nums[i] < k). This contributes another O(n) complexity within the outer loop.
    The total nested loops become O(n) * O(n) = O(n^2).
    However, the space complexity of the method is O(1).

    Here's why:

    The method only uses a fixed number of variables (count, i, j, mul) regardless of the input size n.
    These variables don't grow with the size of the input, so the space complexity remains constant.
    In simpler terms, the algorithm iterates through each element in the array and then potentially iterates
    through the remaining elements to calculate the product. This nested loop structure leads to the quadratic time complexity. On the other hand, the space complexity is constant because it only uses a fixed amount of extra space for variables irrespective of the input size.

    There are more efficient ways to solve this problem using a sliding window approach with a time complexity of
    O(n) and space complexity of O(1). Would you like to see how that approach works?
     */
    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < k) {
                //If nums[i] is smaller than k, then i will be one subarray itself
                count++;
            } else {
                //If nums[i] itself is not smaller than k, the further multtiplications will not be smaller than k
                //So, skip the inner loop
                continue;
            }
            //Initialize the mul with val at index i
            long mul = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                //Starting from index i+1, find multiplications and check if they are smaller than k
                //If not break the loop
                mul = mul * nums[j];
                if (mul < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
