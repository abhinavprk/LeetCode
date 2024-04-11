package lc3005CountElementsWithMaxFreq;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
    }

    private static int maxFrequencyElements(int[] nums) {

        int[] freqArray = new int[101];
        for (int val : nums) {
            freqArray[val] = ++freqArray[val];
        }
        Arrays.sort(freqArray);
        int freqSum = 0;
        for (int i = freqArray.length - 1; i >= 0; i--) {
            if(freqArray[i] == freqArray[freqArray.length - 1]){
                freqSum = freqSum + freqArray[i];
            } else if (freqArray[i] !=0) {
                break;
            }
        }
        return freqSum;
    }
}
