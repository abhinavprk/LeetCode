package lc713SubarryProductLessThanK;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
    /*
    The given method has a time complexity of O(n) and a space complexity of O(1).

    Time Complexity (O(n))

    The outer while loop iterates through the entire array nums in the worst case. This contributes O(n) complexity.
    Inside the outer loop, the inner while loop keeps iterating as long as the product mul is greater than or equal
    to k. However, the key point is that the inner loop doesn't iterate over the entire array for every element in the
    outer loop. It terminates early when mul becomes less than k.
    This early termination prevents the loops from becoming strictly nested, reducing the overall complexity
    from O(n^2) to O(n).

    Space Complexity (O(1))

    The method only uses a fixed number of variables (count, left, right, and mul) regardless of the input size n.
     These variables don't grow with the size of the input, so the space complexity remains constant (O(1)).
    In simpler terms, the algorithm uses two pointers to create a sliding window that efficiently iterates through the array.
    This window keeps track of elements that contribute to subarrays with product less than k. The early termination of the inner loop and the fixed number of variables used lead to the linear time and constant space complexity.
    */

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        if (k > 1) {
            int left = 0;
            int right = 0;
            long mul = 1; // choose mul as long to prevent integer overflow
            while (right < nums.length) {
                mul = mul * nums[right];
                while (mul >= k) {
                    mul = mul / nums[left];
                    left++;
                }
                //The number of subarrays that can be possible for within indices a and b is  b-a+1
                count = count + (right - left + 1);
                right++;
            }
        }
        return count;
    }
}
