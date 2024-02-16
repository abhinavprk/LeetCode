package lc1481LeastNumberOfUniqueIntAfterKRemovals;

import java.util.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description
 */
public class SecondSolution {
    public static void main(String[] args) {
       int[] input = {2,4,1,8,3,5,1,3};
       System.out.println(getLeastNumberOfUniqueElements(input, 3));
      }

    private static long getLeastNumberOfUniqueElements(int[] input, int k) {
        // First sort the array for a later use
        //Create a map of values and number of occurrences
        Map<Integer, Integer> frequencyHashMap = new HashMap<>();
        for (int val : input) {
            frequencyHashMap .put(val, frequencyHashMap.getOrDefault(val, 0) + 1);
        }
        // Create array of frequencies and sort them
        int[] frequency = new int[frequencyHashMap.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> val : frequencyHashMap.entrySet()) {
            frequency[index] = val.getValue();
            index++;
        }
        Arrays.sort(frequency);

        //The idea is that the number of unique elements are equal to the size of frequencyHashMap and frequency
        // array. Now if we sort the frequency array from least to highest number of frequencies, and if we
        //remove first the element with the least number of frequencies, we would be able to remove maximum number
        //of unique elements
        int leastNumber = frequency.length;
        for (int j : frequency) {
            k = k - j;
            if (k >= 0) {
                //If k is still greater or equal than zero, this means that the element with the current frequency
                //has been completely removed, and now we have one lesser number of unique elements.
                leastNumber--;
            } else {
                //If k is negative, this means that we can not remove any more elements, and now we are with
                // the maximum number of unique elements that can be removed that means, least number of unique
                // elements that is possible after removal of k elements.
                break;
            }
        }
        return leastNumber;
    }
}
