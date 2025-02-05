package lc219ContainsDuplicateII;

import java.util.Set;
import java.util.TreeSet;

public class Solution5 {

    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //TLE in leetcode
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        //A set stores all the visited elements, but its size is always equal to k
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            //if there is already present current value, the condition is met
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            //If the size of the set increases k, remove the value that is k indices away, because that value at that index will never fulfil the condition
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
