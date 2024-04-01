package lc159LongestSubstringWithAtMostTwoDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aa"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aaew"));
        System.out.println(lengthOfLongestSubstringTwoDistinct(""));
        System.out.println(lengthOfLongestSubstringTwoDistinct("aabacd"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("a"));
    }

    /*
    Time Complexity:

    O(n) in the average and best cases
    The outer for loop iterates over the string once, contributing O(n) time.
    The inner while loop might iterate multiple times, but its total iterations across all calls are bounded by n, as it only shrinks the window and never expands it.
    O(n^2) in the worst case
    The worst-case scenario occurs when the string has a distinct character at every position, and k is 1. In this case, the inner while loop could potentially iterate n times for each character, leading to a quadratic time complexity.
    Space Complexity:

    O(k + d):
    The allCharSet and charFreq sets can store up to k distinct characters.
    The charFreq map can also store up to k character-frequency pairs.
    In practice, d is often considered a constant (the number of distinct characters in the character set), so the space complexity is typically expressed as O(k).
    Key Points:

    The average-case time complexity is linear, making this method efficient for most inputs.
    The worst-case time complexity is quadratic, but this scenario is less common.
    The space complexity is linear in k, the number of allowed distinct characters.
    The sliding window approach helps efficiently track unique characters within the window, contributing to the linear time complexity in average cases.
     */
    private static int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0; // The length of the longest substring with maximum 2 distinct characters
        //The size of the map represents the number of distinct chars in the current substring
        //The value of each char represents the frequency of the char in the current substring
        Map<Character,Integer> charFrequencyCount = new HashMap<>();
        int left = 0;
        for(int right = left; right < s.length(); right++){
            char currRight = s.charAt(right);
            //Add the current right char to the frequency map or increase the count if already in the map
            charFrequencyCount.put(currRight, charFrequencyCount.getOrDefault(currRight, 0) +1);
            if(charFrequencyCount.size() <= 2){
                //if current frequency is equal to or less than 2, check if it can be the substring with
                //maximum length
                int currentLen = right-left+1; //Length of the current substring
                result = Math.max(currentLen, result);
            } else {
                //If no of distinct chars in the substring is more than 2
                //Update the substring until the number of distinct chars in the substring is equal to 2
                while(charFrequencyCount.size() != 2) {
                    char currLeft = s.charAt(left);
                    int currLeftFreq = charFrequencyCount.getOrDefault(currLeft, 0);
                    if (currLeftFreq == 1) {
                        //Remove the char from map if its frequency is equal to one because after moving the left
                        //pointer its frequency will be zero and we don't want a char with frequency zero in the
                        //map, otherwise the size of the map will not represent the number of distinct
                        //chars in the current substring
                        charFrequencyCount.remove(currLeft);
                    } else {
                        //Decrease the count of the char from the frequency map
                        charFrequencyCount.put(currLeft, currLeftFreq - 1);
                    }
                    //Move the left pointer
                    left++;
                }
            }
        }

        return result;
    }
}
