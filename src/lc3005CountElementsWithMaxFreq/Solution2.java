package lc3005CountElementsWithMaxFreq;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1,2,2,3,1,4}));
    }

    private static int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);

        int[] freqArray = new int[nums[nums.length-1]+1];
        for (int val : nums) {
            freqArray[val] = ++freqArray[val];
        }
        Arrays.sort(freqArray);
        int highestFreq = freqArray[freqArray.length - 1];
        int freqSum = 0;
        for (int i = freqArray.length - 1; i >= 0; i--) {
            if(freqArray[i] == highestFreq){
                freqSum = freqSum + freqArray[i];
            } else if (freqArray[i] !=0) {
                break;
            }
        }
        return freqSum;
    }
}
