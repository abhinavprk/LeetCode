package lc217ContainsDuplicate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }
    /*
    TLE in leetcode
     */
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int curr : nums){
            visited.add(curr); //O(1)
        }
        return nums.length > visited.size();
    }
}
