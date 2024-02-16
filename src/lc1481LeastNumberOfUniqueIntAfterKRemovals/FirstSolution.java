package lc1481LeastNumberOfUniqueIntAfterKRemovals;

import java.util.*;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description
 */
public class FirstSolution {
    public static void main(String[] args) {
       int[] input = {2,4,1,8,3,5,1,3};
       System.out.println(getLeastNumberOfUniqueElements(input, 3));
      }

    private static long getLeastNumberOfUniqueElements(int[] input, int k) {
        // First sort the array for a later use
        int[] sortedArray = Arrays.copyOf(input, input.length);
        Arrays.sort(sortedArray);
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int val : sortedArray) {
            if (hashMap.containsKey(val)) {
                hashMap.put(val, hashMap.get(val) + 1);
            } else {
                hashMap.put(val, 1);
            }
        }
        HashMap<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(hashMap.entrySet());
        List<Map.Entry<Integer, Integer>> sortedEntryList = entryList.stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).toList();
        for (Map.Entry<Integer, Integer> val : sortedEntryList){
            sortedHashMap.put(val.getKey(), val.getValue());
        }
        int leastNumber = sortedHashMap.size();
        for (Map.Entry<Integer, Integer> val : sortedHashMap.entrySet()){
            k = k - val.getValue();
            if(k >= 0){
                leastNumber--;
            } else{
                break;
            }
        }


        return leastNumber;
    }
}
