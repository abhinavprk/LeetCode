package lc153FindMInimumInRotatedSortedArray;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1,2,4,5,6,7,0}));
        System.out.println(findMin(new int[]{8}));
        System.out.println(findMin(new int[]{2,1}));
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{0,1,2,4,5,6,7}));
    }

    private static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        int count = 0;
        while(low <= high){
            count++;
            int mid = low + (high - low)/2;
            min = Math.min(min, nums[mid]);
            if((nums[mid] >= nums[low]) && (nums[mid] >= nums[high])){
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        System.out.println("Count: "+count);
        return min;
    }
}
