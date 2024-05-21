package lc162FindPeakElement;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,3,4}));
        System.out.println(findPeakElement(new int[]{1,2,3,4,5,6,7}));
        System.out.println(findPeakElement(new int[]{3,2,3,4,5,7,8}));
        System.out.println(findPeakElement(new int[]{1,2}));
    }

    private static int findPeakElement(int[] nums) {
        return searchPeak(nums, 0, nums.length-1);
    }

    private static int searchPeak(int [] nums, int left, int right){
        if(left == right){
            return left;
        }
        int mid = left + (right - left)/2;

        if(nums[mid] > nums[mid+1]){
            return searchPeak(nums, left, mid);
        }
        return searchPeak(nums, mid+1, right);
    }

    private static int search(int[] nums, int l, int r) {
        if (l == r){
            return l;
        }
        int mid = l + (r - l)/2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }
}
