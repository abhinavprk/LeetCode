package lc2149_rearrange_array_by_sign;

import java.util.*;

/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign
 */
public class SecondSolution {

    public static void main(String[] args) {
        //int[] input = {-3,1,2,-5,2,-4};

        //System.out.println(Arrays.toString(rearrangeArray(input)));
       int[] input1 = {-27,-30,8,-16,38,30,20,21,-2,-18,40,-29};
        System.out.println(Arrays.toString(rearrangeArray(input1)));
    }

    private static int[] rearrangeArray(int[] nums) {
        int[] finalArr = new int[nums.length];
        Queue<Integer> arrayQueue = new LinkedList<>();
        boolean lastValNegative = true;
        int finalArrIndex = 0;
        for(int index = 0; ((index < nums.length) || (!arrayQueue.isEmpty())); index++){
            int currentVal = 0;
            if(!arrayQueue.isEmpty()){
                int head = arrayQueue.peek();
                if((lastValNegative && head > 0) || (!lastValNegative && head<0)){
                    currentVal = arrayQueue.remove();
                    index --;
                }else{
                    currentVal = nums[index];
                }
            } else{
                currentVal = nums[index];
            }
            if(lastValNegative){
                if(currentVal > 0){
                    finalArr[finalArrIndex] = currentVal;
                    lastValNegative = false;
                    finalArrIndex++;
                } else {
                    arrayQueue.add(currentVal);
                }
            } else {
                if(currentVal < 0){
                    finalArr[finalArrIndex] = currentVal;
                    lastValNegative = true;
                    finalArrIndex++;
                } else {
                    arrayQueue.add(currentVal);
                }
            }
        }
        return finalArr;

    }
}
