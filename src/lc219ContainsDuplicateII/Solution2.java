package lc219ContainsDuplicateII;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //TLE in leetcode
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        //Store all the indices of elements present in the array in a Map
        Map<Integer, List<Integer>> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int curr = nums[i];
            List<Integer> indices = valueIndexMap.getOrDefault(curr, new ArrayList<>());
            indices.add(i);
            valueIndexMap.put(curr, indices );
        }
        //If a particular element exists multiple times, find out if they are at the correct indices
        for (Map.Entry<Integer, List<Integer>> en : valueIndexMap.entrySet()){
            List<Integer> currList = en.getValue();
            if(currList.size() > 1){
                //Sort the list of indices
                Collections.sort(currList);
                if(existsIndexes(currList, k)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean existsIndexes(List<Integer> currList, int k) {
        for (int i = 0; i < currList.size() - 1; i++) {
            //Check all the neighbouring indices for the condition match
            if((currList.get(i + 1) - currList.get(i)) <= k){
                return true;
            }
        }
        return false;
    }

}
