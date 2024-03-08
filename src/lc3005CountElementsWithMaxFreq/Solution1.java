package lc3005CountElementsWithMaxFreq;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution1 {
    public static void main(String[] args) {

    }

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int val : nums) {
            freqCount.put(val, freqCount.getOrDefault(val, 0) + 1);
        }
        int[] freqArray = freqCount.values().stream().toList().stream()
                .flatMapToInt(IntStream::of).sorted().toArray();
        int highestFreq = freqArray[freqArray.length - 1];
        int freqSum = 0;
        for (int i = freqArray.length - 1; i >= 0; i--) {
            if (freqArray[i] == highestFreq) {
                freqSum = freqSum + freqArray[i];
            } else {
                break;
            }
        }
        return freqSum;
    }
}
