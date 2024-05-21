package lc162FindPeakElement;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,3,4}));
        System.out.println(findPeakElement(new int[]{1,2,3,4,5,6,7}));
        System.out.println(findPeakElement(new int[]{3,2,3,4,5,7,8}));
        System.out.println(findPeakElement(new int[]{1,2}));
    }

    private static int findPeakElement(int[] nums) {
        int result = 0;
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if((mid < nums.length-1) && (nums[mid] < nums[mid + 1])) {
                low = mid +1;
            } else if ((mid > 0) && (nums[mid] < nums[mid - 1])) {
                high = mid - 1;
            } else {
                result = mid;
                break;
            }
        }
        return result;
    }
}
