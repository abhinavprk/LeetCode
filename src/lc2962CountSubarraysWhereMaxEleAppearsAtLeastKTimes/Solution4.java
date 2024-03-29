package lc2962CountSubarraysWhereMaxEleAppearsAtLeastKTimes;

import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(countSubarrays(new int[]{1,4,2,1}, 3));
        System.out.println(countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));
    }

    private static long countSubarrays(int[] nums, int k) {
        //Store the frequency of the maximum element
        int frequency = 0;
        long count = 0;
        //Find max element of the array
        OptionalInt maxElementOpt = Arrays.stream(nums).max();
        int maxElement;
        if(maxElementOpt.isPresent()){
            maxElement = maxElementOpt.getAsInt();
            int start=0;
            for (int end = start; end < nums.length; end++){
                if(nums[end] == maxElement){
                    frequency++;
                }
                while(frequency == k){
                    if(nums[start] == maxElement){
                        frequency--;
                    }
                    start++;
                }
                count = count + start;
            }
        }



        return count;

    }
}
