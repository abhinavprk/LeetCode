package lc229MajorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{1,2}));
        System.out.println(majorityElement(new int[]{1}));
    }
    private static List<Integer> majorityElement(int[] nums) {
        int minCount = nums.length / 3;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int val : nums) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int val : counts.keySet()) {
            if (counts.get(val) > minCount) {
                ans.add(val);
            }
        }
        return ans;
    }
}
