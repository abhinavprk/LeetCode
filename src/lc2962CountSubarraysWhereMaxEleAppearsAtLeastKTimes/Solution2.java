package lc2962CountSubarraysWhereMaxEleAppearsAtLeastKTimes;

import java.util.Collections;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(countSubarrays(new int[]{1,4,2,1}, 3));
        System.out.println(countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));
    }

    /*
    TLE in leetcode
    The countSubarrays method has the following time and space complexities:

    Time Complexity: O(n^2)

    The method uses nested loops to iterate through all possible subarrays, leading to O(n^2) time complexity in the worst case.
    While there's an additional O(n log n) term due to sorting, it becomes negligible compared to the nested loops for large input sizes (n).
    Space Complexity: O(n)

    The sorting process creates a new sorted array sortedNums, which takes O(n) additional space.
    Other variables used have constant space consumption, independent of the input size.
    In summary, the method's time complexity is dominated by the nested loops, making it less efficient for very large arrays
    compared to approaches that avoid nested loops.
     */
    private static long countSubarrays(int[] nums, int k) {
        //Find max element of the array. Sort the array in descending order and pick the first
        int[] sortedNums = IntStream.of(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(a -> a).toArray();
        int maxElement = sortedNums[0]; //Max element of the array
        //Store the frequency of the maximum element
        int frequency = 0;
        int count = 0;
        //Loop through the array and check for every subarray
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                //If the frequency is greater than k, increase the count
                if (frequency >= k) {
                    count++;
                } else if (nums[j] == maxElement) {
                    //if new element is equal to the max element, increment the frequency
                    frequency++;
                    //If the frequency is greater than k, increase the count
                    if (frequency >= k) {
                        count++;
                    }
                }

            }
            //Reset the frequency for the next loop
            frequency = 0;
        }

        return count;

    }
}
