package lc2962CountSubarraysWhereMaxEleAppearsAtLeastKTimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        //System.out.println(countSubarrays(new int[]{1,4,2,1}, 3));
        //System.out.println(countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));
    }

    private static long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexesOfMaxElements = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxElement) {
                indexesOfMaxElements.add(i);
            }

            int freq = indexesOfMaxElements.size();
            if (freq >= k) {
                ans += indexesOfMaxElements.get(freq - k) + 1;
            }
        }

        return ans;

    }
}
