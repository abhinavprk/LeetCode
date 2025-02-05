package lc845LongestMountainInAnArray;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[] {2,1,4,7,3,2,5}));
        System.out.println(longestMountain(new int[] {2,2,2}));
        System.out.println(longestMountain(new int[] {2,1,4,7,2,2,5}));

    }

    private static int longestMountain(int[] arr){

        int longest = 0;
        //Assume every index could be a peak and check for each of them if it is the peak for the longest mountain
        for (int i = 1; i < arr.length -1 ; i++) {
            int peak = arr[i];
            int left = i-1;
            int right = i + 1;
            //move the left boundary until left is smaller than peak and also smaller than the adjacent element to it's left
            if((arr[left] < peak) && (arr[right]<peak)) {
                while (left > 0  && (arr[left - 1] < arr[left])) {
                    left--;
                }
                //move the right boundary until right is smaller than peak and also smaller than the adjacent element to it's right
                while (right < arr.length - 1 && (arr[right + 1] < arr[right])) {
                    right++;
                }
                //Update the longest length based on the length of the current mountain.
                longest = Math.max(longest, right - left + 1);
            }
        }
        return longest;
    }
}
