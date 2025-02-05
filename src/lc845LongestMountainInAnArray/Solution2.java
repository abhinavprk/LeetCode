package lc845LongestMountainInAnArray;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[] {2,1,4,7,3,2,5}));
        System.out.println(longestMountain(new int[] {2,2,2}));
        System.out.println(longestMountain(new int[] {2,1,4,7,2,2,5}));

    }

    private static int longestMountain(int[] arr){

        int longest = 0;
        //Since the array length in min 3, the peak could be index 1 only
        int peakIndex = 1;
        while (peakIndex < arr.length - 1) {
            int peak = arr[peakIndex];
            int left = peakIndex-1;
            int right = peakIndex + 1;
            //move the left boundary until left is smaller than peak and also smaller than the adjacent element to it's left
            if((arr[left] < peak) && (arr[right]<peak)) {
                while (left > 0  && (arr[left - 1] < arr[left])) {
                    left--;
                }
                //move the right boundary until right is smaller than peak and also smaller than the adjacent element to it's right
                while (right < arr.length - 1 && (arr[right + 1] < arr[right])) {
                    right++;
                }
                //Update the longest based on the current length of the mountain
                longest = Math.max(longest, right - left + 1);
            }
            peakIndex = right;
        }


        return longest;
    }
}
