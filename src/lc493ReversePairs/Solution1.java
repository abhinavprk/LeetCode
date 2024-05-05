package lc493ReversePairs;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(reversePairs(new int[]{2,4,3,5,1}));
        System.out.println(reversePairs(new int[]{2}));
    }

    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int val1 = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(val1 > 2*nums[j]){
                    count++;
                }
            }

        }
        return count;
    }


}
