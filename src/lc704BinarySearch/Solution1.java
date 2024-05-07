package lc704BinarySearch;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, -2));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 22));
        System.out.println(search(new int[]{5}, 5));
    }

    private static int search(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid] > target){
                high = mid-1;
            } else if (nums[mid] < target) {
                low = mid +1;
            } else if(nums[mid] == target){
                result = mid;
                break;
            }
        }
        if((low < nums.length) && (nums[low] == target)){
            result = low;
        }
        return result;
    }
}
