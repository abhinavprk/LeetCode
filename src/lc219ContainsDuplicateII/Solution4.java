package lc219ContainsDuplicateII;

public class Solution4 {

    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    //TLE in leetcode
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        //For every element check if a similar value at a correct index exists.
        for (int i = 0; i < nums.length; ++i) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
