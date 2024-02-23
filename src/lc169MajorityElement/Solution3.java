package lc169MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,3,1,1,4,1,1,5,1,1,6,2,2}));
        System.out.println(majorityElement(new int[]{-1,1,1,1,2,1}));
    }

    private static int majorityElement(int[] nums) {
        int majCount = 0;
        int majVal = nums[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int currentVal : nums) {
            int currentCount = countMap.getOrDefault(currentVal, 0) + 1;
            countMap.put(currentVal, currentCount);
            if (currentCount > majCount) {
                majCount = currentCount;
                majVal = currentVal;
            }
        }
        return majVal;
    }
}
