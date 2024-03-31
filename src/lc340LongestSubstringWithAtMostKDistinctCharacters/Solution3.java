package lc340LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(lengthOfLongestSubstringKDistinct("aaew", 5));
        System.out.println(lengthOfLongestSubstringKDistinct("", 1));
        System.out.println(lengthOfLongestSubstringKDistinct("aabacd", 5));
        System.out.println(lengthOfLongestSubstringKDistinct("a", 0));
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
    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int subLength = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        int left = 0;
        int currLen; //Length of the current substring
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            int rightCharFrequency = charFreq.getOrDefault(rightChar, 0);
            charFreq.put(rightChar, rightCharFrequency + 1);
            if (charFreq.size() <= k) {
                //If current freq of unique elements is less than or equal to K
                //compare the length of substring with the overall Maxlength substring and update
                currLen = right - left + 1;
                subLength = Math.max(currLen, subLength);
            } else {
                //move left pointer forward until the number of unique chars is equal to k
                while (charFreq.size() > k) {
                    char leftChar = s.charAt(left);
                    int leftCharFrequency = charFreq.getOrDefault(leftChar, 0);
                    if (leftCharFrequency == 1) {
                        //if freq is equal to 1 this means there is no occurrence of this char in the substring until
                        //current right. This char can be removed
                        charFreq.remove(leftChar);
                    } else {
                        //if freq is more than 1 this means there is more occurrences of this char in the substring until
                        //current right. This char cannot be removed from charFreq map@
                        charFreq.put(leftChar, leftCharFrequency - 1);
                    }
                    left++;
                }
            }
        }
        return subLength;
    }
}
