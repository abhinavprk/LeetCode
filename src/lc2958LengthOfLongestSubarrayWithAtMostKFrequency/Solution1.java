package lc2958LengthOfLongestSubarrayWithAtMostKFrequency;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(maxSubarrayLength(new int[]{1, 2, 2, 1, 3}, 1));
        System.out.println(maxSubarrayLength(new int[]{2, 2, 3}, 1));
    }

    /*
    Time Complexity: The time complexity of the given method is O(n).

    Here's why:

    While loop: The main while loop iterates through the array nums at most once, resulting in n iterations in the worst case.
    Inner while loop: The inner while loop, which adjusts the left index, runs only when the frequency of an element reaches k.
    Its iterations are bounded by the current length of the subarray (currSubArrLength), which is always less than or equal to n.
    HashMap operations: Operations within the HashMap (like getOrDefault and put) take constant time (O(1) on average) due to their
    efficient implementation.
    Therefore, even though the loops are nested, the overall time complexity is still linear as the inner loop's iterations are limited
    by the outer loop's progress.

    Space Complexity: The space complexity of the method is O(n).

    Here's why:

    HashMap: The frequencyMap can potentially store up to n unique elements from the array nums, leading to a space complexity of O(n).
    Other variables: The other variables used (longest, left, right, currSubArrLength) consume a constant amount of space independent of the input size.
    In summary, both the time complexity (O(n)) and space complexity (O(n)) of the given method are linear,
    indicating efficient performance for most practical input sizes.
     */
    private static int maxSubarrayLength(int[] nums, int k) {
        int longest = 0;
        //Stores the frequency of the elements in current sub-array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int left = 0; //It is the left index of the current sub-array
        int right = 0; // Right index of the current sub-array
        int currSubArrLength = 0; //It stores the length of current sub-array
        while ((left <= right) && (left < nums.length) && (right < nums.length)) {
            int rightVal = nums[right];
            //Get the frequency of the element at right index
            int currFreq = frequencyMap.getOrDefault(rightVal, 0);
            //If the frequency of the element at right index is already equal to k, we need to reduce the
            //sub-array from left so that the highest frequency can be maintained
            if (currFreq == k) {
                while (nums[left] != nums[right]) {
                    //Before moving the left index, reduce the frequency of the element from the frequencyMap
                    int freq = frequencyMap.getOrDefault(nums[left], 0);
                    if (freq > 0) {
                        freq--;
                    }
                    frequencyMap.put(nums[left], freq);
                    //Move the left index by one
                    left++;
                }
                //Here the value at left index will be equal to the value at right index, so we need to
                //move the left index by one so that the highest frequency can be maintained
                left++;
                //The current sub-array length from left index to right index
                currSubArrLength = right - left + 1;
            } else {
                //If frequency of the element at right index is not equal to k, it will be smaller than k,
                //increase the frequency by one and increase the current sub-array length
                frequencyMap.put(rightVal, currFreq + 1);
                currSubArrLength++;
            }
            //Move  the right index forward
            right++;
            //Update the length of longest sub-array by comparing it to the current sub-array length
            longest = Math.max(longest, currSubArrLength);
        }
        return longest;
    }
}
