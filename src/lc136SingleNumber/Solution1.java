package lc136SingleNumber;

public class Solution1 {
    public static void main(String[] args) {

        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }

    private static int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
