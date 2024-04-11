package lc930BinarySubarrayWithSum;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] {1,0,1,0,1}, 2));
        System.out.println(numSubarraysWithSum(new int[] {0,0,0,0,0}, 0));
    }
    /*
    The time complexity of the given method is O(n^2).

    Here's a breakdown of why:

    There are two nested loops:

    The outer loop iterates through left from 0 to nums.length - 1. This loop runs n times.
    The inner loop iterates through right from left to nums.length - 1. In the worst case, the inner loop runs n
    times for each iteration of the outer loop.
    Inside the inner loop, there are constant time operations like comparisons and incrementing the counter.

    Therefore, the total number of operations performed by the nested loops is proportional to n * n, which is O(n^2).

    The space complexity of the method is O(1).

    It only uses a constant amount of extra space for variables like sum, count, left, and right.
    The space complexity does not depend on the input size n.
    Even though the space complexity is efficient, the time complexity of O(n^2) can be slow for large inputs. There are more
    efficient solutions to this problem that use techniques like sliding window with a time complexity of O(n).
     */
    private static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        for (int left = 0; left < nums.length; left++) {
            sum = sum + nums[left];
            for (int right = left; right < nums.length; right++) {
                if ((left == right) && (sum == goal)) {
                    count++;
                } else if (left != right) {
                    sum = sum + nums[right];
                    if (sum == goal) {
                        count++;
                    } else if (sum > goal) {
                        break;
                    }
                }
            }
            sum = 0;
        }
        return count;
    }
}
