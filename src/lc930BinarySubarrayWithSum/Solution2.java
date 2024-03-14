package lc930BinarySubarrayWithSum;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    /*
    Time Complexity: O(n)

    Loop: The main loop iterates through the array nums once, taking O(n) time.
    Map operations:
    containsKey, get, and put operations on a HashMap generally take constant time (O(1)) on average.
    The overall time spent on these map operations within the loop is still proportional to the input size n,
    as they are executed for each element in the array.
    Therefore, the overall time complexity of the method is linear, O(n).

    Space Complexity: O(n)

    HashMap: The space used by the frequency HashMap is the primary contributor to space complexity.
    In the worst-case scenario, all possible prefix sums could be different, leading to a HashMap with a size
    proportional to the input size n.
    Other variables: The other variables like sum, count, and loop counters use a constant amount of space, O(1).
    Therefore, the overall space complexity of the method is O(n) due to the potential size of the HashMap.
     */
    private static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int val : nums) {
            sum = sum + val;
            if (sum == goal) {
                count++;
            }
            if (frequency.containsKey(sum - goal)) {
                count = count + frequency.get(sum - goal);
            }
            frequency.put(sum, frequency.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
