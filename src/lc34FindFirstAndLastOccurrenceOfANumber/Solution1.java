package lc34FindFirstAndLastOccurrenceOfANumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 7)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }



    private static int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        result[0] = findLeftMostIndex(nums, target);
        result[1] = findRightMostIndex(nums, target);
        return result;
    }

    private static int findRightMostIndex(int[] nums, int target) {
        int ind = -1;
        int low = 0;
        int high = nums.length-1;
        //Find the postion of the target in the array
        while (low<=high){
            int mid = low + (high-low)/2;
            if(target < nums[mid]){
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else{
                ind = mid;
                break;
            }
        }
        int result = ind;
        //Since nums array is an ascending sorted array find the right most index that has the value equal to the target
        while((result+1 < nums.length) && (nums[result+1] == target)){
            result++;
        }
        return result;
    }

    private static int findLeftMostIndex(int[] nums, int target) {
        int ind = -1;
        int low = 0;
        int high = nums.length-1;
        //Find the postion of the target in the array
        while (low<=high){
            int mid = low + (high-low)/2;
            if(target < nums[mid]){
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else{
                ind = mid;
                break;
            }
        }
        int result = ind;
        //Since nums array is an ascending sorted array find the left most index that has the value equal to the target
        while((result-1 >= 0) && (nums[result-1] == target)){
            result--;
        }
        return result;
    }
}
