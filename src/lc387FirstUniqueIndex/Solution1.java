package lc387FirstUniqueIndex;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("ee"));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));
    }

    private static int firstUniqChar(String s) {
        Map<Integer, int[]> charMap = new HashMap<>();
        int index = 0;
        for (char val : s.toCharArray()) {
            int[] data = charMap.get(val - 'a');
            if (Objects.isNull(data)) {
                data = new int[2];
                data[1] = s.length();
            }
            data[0]= data[0]+1;
            int prevIndex = data[1];
            data[1] =  Math.min(index, prevIndex);
            charMap.put(val - 'a', data);
            index++;
        }
        int minIndex = s.length();
        for (Map.Entry<Integer, int[]> entry : charMap.entrySet()) {
            int[] data = entry.getValue();
            if (data[0] == 1) {
                minIndex = Math.min(minIndex, data[1]);
            }
        }
        if(minIndex == s.length()){
            minIndex = -1;
        }
        return minIndex;
    }
}
