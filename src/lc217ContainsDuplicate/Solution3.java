package lc217ContainsDuplicate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }
    /*
    TLE in leetcode
     */
    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int curr : nums){ //O(n)
            if(visited.containsKey(curr)){ // O(1)
                return true;
            }
            visited.put(curr, curr); //O(1)
        }
        return false;
    }
}
