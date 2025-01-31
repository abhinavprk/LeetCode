package lc217ContainsDuplicate;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }
    /*
    TLE in leetcode
     */
    private static boolean containsDuplicate(int[] nums) {
        List<Integer> visited = new ArrayList<>();
        for (int curr : nums){ //O(n)
            if(visited.contains(curr)){ // O(n)
                return true;
            }
            visited.add(curr); //O(1)
        }
        return false;
    }
}
