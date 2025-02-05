package lc219ContainsDuplicateII;

import java.util.*;

public class Solution3 {

    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        //Store the current index as the last index found in the Map
        //The idea is that if the condition fulfils it, could be fulfilled by at least two
        //consecutive indices where the elements are same
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            int curr = nums[i];
            Integer lastIndex = valueIndexMap.getOrDefault(curr, -1);
            //If the lastIndex is -1, which means the element has been found for the first time.
            if(lastIndex != -1) {
                //If not, check the condition with the lastIndex of the current element.
                if((i - lastIndex) <= k){
                    return true;
                }
            }
            //If this is the first occurrence of the element or the condition is not matched,
            //store the current index as the last found index in the map.
            valueIndexMap.put(curr, i);
        }
        return false;
    }
}
