package lc560SubarraySumEqualK;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }
    /*
    The time complexity of the improved subarraySum method is  O(n) and the space complexity is  O(n).

    Here's the breakdown:

    Time Complexity (O(n)):

    The outer for loop iterates through the array nums with n elements, resulting in n iterations.
    Inside the loop, the operations like calculating sum, getting the value from cumSum,
    and updating cumSum are all constant time operations (O(1)).
    Space Complexity (O(n)):

    The cumSum map stores the cumulative sums and their frequencies. In the worst case scenario,
    the map will have a unique entry for each possible cumulative sum encountered while processing the array nums.
    This can potentially lead to n entries in the map.
    While the space complexity scales with the input size, the time complexity remains linear (O(n))
    due to the constant time operations within the loop. This is a significant improvement compared to the nested loop solution with a time complexity of O(n^2).
     */
    private static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> cumSum = new HashMap<>();
        /*
        The reason we add (0, 1) to the cumSum map in the beginning of the subarraySum method is to handle cases where the
        subarray itself contributes a sum of k.

        Here's a breakdown:

        cumSum map: This map stores the cumulative sum (sum till that point in the iteration) as the key and the number of
        times that sum has been encountered as the value.
        (0, 1): This initial entry represents an empty subarray (with a sum of 0). We set its value to 1 because we want
        to count the subarray that starts and ends at the same element (i.e., a single element) if its value is equal to k.
        Let's see why this is important:

        Consider a single element k in the array: If the first element in the array is k, the sum after processing the
        element will also be k. However, without the initial (0, 1), the cumSum map won't have an entry for k yet. So, count wouldn't be incremented for this subarray.

        Multiple elements with sum k: If there are multiple subarrays with a sum of k, some might start at positions where
        the cumulative sum before them is not k. But, the (0, 1) entry ensures that any subarray ending at an element with a
        sum of k will be counted, regardless of the previous cumulative sum.

        By adding (0, 1), we essentially account for subarrays that contribute to the target sum k themselves, even if
        they don't follow another subarray with a cumulative sum of k-sum_of_current_element. This simplifies the logic and
        avoids the need for an extra check within the loop.
         */
        cumSum.put(0, 1);
        for (int num : nums) {
            sum = num + sum;
            count = count + cumSum.getOrDefault(sum - k, 0);
            cumSum.put(sum, cumSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
