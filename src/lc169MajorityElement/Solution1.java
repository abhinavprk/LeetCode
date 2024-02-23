package lc169MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{3,3,4}));
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int maj = Integer.MIN_VALUE;
        int majElement = -1;
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            int key = entry.getKey();
            int count = entry.getValue();
            if(count > maj){
                maj = count;
                majElement = key;
            }
        }
        return majElement;
    }
}
