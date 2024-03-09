package lc2540MinimumCommonValue;

public class Solution2 {

    public static void main(String[] args) {

        System.out.println(getCommon(new int[] {1,2,3,6},new int[] {2,3,4,5} ));
        System.out.println(getCommon(new int[] {1,2,3,6},new int[] {5,7,8,9} ));
        System.out.println(getCommon(new int[] {1,2,3,9},new int[] {5,7,8,9} ));
        System.out.println(getCommon(new int[] {1,2,3,9},new int[] {1,7,8,9} ));
        System.out.println(getCommon(new int[] {1},new int[] {1,7,8,9} ));
        System.out.println(getCommon(new int[] {1},new int[] {1} ));
        System.out.println(getCommon(new int[] {1},new int[] {} ));
        System.out.println(getCommon(new int[] {},new int[] {} ));

    }
/*

 */
    private static int getCommon(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return getCommon(nums2, nums1);
        }
        for(int val: nums1){
            if(binarySearch(val, nums2)){
                return val;
            }
        }
        return -1;
    }

    private static boolean binarySearch(int target, int[] array){
        boolean isThere = false;
        int start = 0;
        int end = array.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(array[mid] > target){
                end = mid-1;
            } else if(array[mid] < target){
                start=mid+1;
            } else {
                isThere = true;
                break;
            }
        }
        return isThere;
    }
}
