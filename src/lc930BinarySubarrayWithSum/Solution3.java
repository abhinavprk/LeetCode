package lc930BinarySubarrayWithSum;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    /*
    Time Complexity:

    slidingWindowAtMost method: O(n)

    The outer for loop iterates through the array once, taking O(n) time.
    The inner while loop might execute multiple times within each iteration of the outer loop, but it's essential to remember that:
    Its primary purpose is to adjust the window's size to satisfy the condition (currentSum <= goal).
    It does this by shifting the start pointer forward, effectively removing elements from the window's beginning.
    Crucially, each element can be removed at most once during the entire execution of the method.
    Therefore, the total number of times the while loop can execute is bounded by the total number of elements in the array, n.
    This makes the overall time complexity of the slidingWindowAtMost method linear, O(n).
    numSubarraysWithSum method: O(n)

    It calls slidingWindowAtMost twice with different goals, but each call has a time complexity of O(n).
    The subtraction and return operations are constant-time, so they don't affect the overall time complexity.
    Therefore, the numSubarraysWithSum method also has a linear time complexity of O(n).
    Space Complexity:

    slidingWindowAtMost method: O(1)

    It only uses a constant amount of extra space to store variables like start, currentSum, totalCount, and a few loop counters.
    The space usage does not grow with the input size n.
    numSubarraysWithSum method: O(1)

    It doesn't introduce any additional space usage beyond the calls to slidingWindowAtMost.
    Key points:

    The sliding window technique is often used to achieve linear time complexity in problems involving subarrays or substrings.
    It's important to analyze the potential number of iterations of inner loops within sliding window algorithms to accurately determine their time complexity.
    The space efficiency of sliding window algorithms is typically constant, as they often work with a fixed-size window and a few variables.
     */
    private static int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }

    private static int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        // Iterate through the array using a sliding window approach
        for (int end = 0; end < nums.length; end++) {
            currentSum = currentSum + nums[end];

            // Adjust the window by moving the start pointer to the right
            // until the sum becomes less than or equal to the goal
            while (start <= end && currentSum > goal) {
                currentSum = currentSum - nums[start];
                start++;
            }

            // Update the total count by adding the length of the current subarray
            totalCount = totalCount + end - start + 1;
        }
        return totalCount;
    }


}
