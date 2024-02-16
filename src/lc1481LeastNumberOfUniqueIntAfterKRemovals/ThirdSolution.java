package lc1481LeastNumberOfUniqueIntAfterKRemovals;

import java.util.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description
 */
public class ThirdSolution {
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

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyHashMap.entrySet());
        List<Map.Entry<Integer, Integer>> sortedEntryList = entryList.stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue)).toList();

        for (Map.Entry<Integer,Integer> entry : sortedEntryList) {
            k = k - entry.getValue();
            if (k >= 0) {
                //If k is still greater or equal than zero, this means that the element with the current frequency
                //has been completely removed, and now we have one lesser number of unique elements.
                frequencyHashMap.remove(entry.getKey());
            } else {
                //If k is negative, this means that we can not remove any more elements, and now we are with
                // the maximum number of unique elements that can be removed that means, the least number of unique
                // elements that is possible after removal of k elements.
                break;
            }
        }
        return frequencyHashMap.size();
    }
}
