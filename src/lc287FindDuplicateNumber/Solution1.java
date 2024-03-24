package lc287FindDuplicateNumber;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
    private static int findDuplicate(int[] nums) {
        int dup = -1;
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];
            if(nums[Math.abs(curr)] < 0){
                dup = Math.abs(curr);
            } else{
                nums[Math.abs(curr)] = -1 * nums[Math.abs(curr)];
            }
        }
        return dup;
    }
}
