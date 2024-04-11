package lc560SubarraySumEqualK;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    /*
    The time complexity of the given method is O(n^2).

    Here's why:

    The outer for loop iterates through the array nums with n elements, resulting in n iterations.
    Within the outer loop, there's an inner for loop that also iterates through the array nums. In the worst case
    scenario (when k is not found before the end of the inner loop), this loop will also run n times.
    This nested loop structure leads to a total time complexity of O(n * n) which can be simplified to O(n^2).

    The space complexity of the method is O(1).

    This is because the method only uses a constant amount of extra space for variables like count and sum. It doesn't
    use any additional data structures that scale with the size of the input array nums.


     */
    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    if (nums[i] == k) {
                        count++;
                    }
                } else {
                    sum = sum + nums[j];
                    if (sum == k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
