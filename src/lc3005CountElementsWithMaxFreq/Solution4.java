package lc3005CountElementsWithMaxFreq;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
    }

    private static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int freqSum=0;
        int maxFreq = 0;
        for(int val: nums){
            int newFreq = freqMap.getOrDefault(val, 0)+1;
            if(newFreq > maxFreq){
                maxFreq = newFreq;
                freqSum = newFreq;
            } else if (newFreq == maxFreq) {
                freqSum = freqSum + maxFreq;
            }
            freqMap.put(val, newFreq);
        }
        return freqSum;
    }
}
