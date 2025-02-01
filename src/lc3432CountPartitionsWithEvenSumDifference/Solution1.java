package lc3432CountPartitionsWithEvenSumDifference;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{1,2,2}));
        System.out.println(countPartitions(new int[]{2,4,6,8}));
    }

    private static int countPartitions(int[] nums) {
        int count = 0;
        int [] sumUntil = new int[nums.length];
        int [] oppositeSum = new int[nums.length];
        int prefixSum = 0;
        int oppositePrefixSum = 0;
        //Create sum from 0 - n
        for(int i = 0; i<nums.length; i++){
            prefixSum += nums[i];
            sumUntil[i] = prefixSum;
        }

        //Create sum from n - 1
        for(int i = nums.length-1; i>=0; i--){
            oppositePrefixSum += nums[i];
            oppositeSum[i] = oppositePrefixSum;
        }

        //count the even sum differences
        for(int i = 0; i<nums.length - 1 ; i++){
            int sumUntilHere = sumUntil[i];
            int oppositeSumHere = oppositeSum[i+1];
            if(Math.abs( sumUntilHere - oppositeSumHere) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}
