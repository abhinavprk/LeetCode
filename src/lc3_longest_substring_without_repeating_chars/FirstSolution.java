package lc3_longest_substring_without_repeating_chars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstSolution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

    private static int lengthOfLongestSubstring(String s) {
        int length = 0; // Length of the longest substring with non repeating characters
        if (!s.isEmpty()) {
            length = 1; // The minimum length will be 1 if the String is not empty
            Map<String, Integer> coveredChars = new HashMap<>(); // store the value and indexes of the traversed
            // characters
            int begIndex = 0; // start with first index
            int endIndex = 0; // end index will be same as first index
            for (int index = 0; index < s.length(); index++) {
                String valAtIndex = s.substring(index, index + 1); // get the value at current index
                if (coveredChars.containsKey(valAtIndex) && begIndex <= coveredChars.get(valAtIndex)) {
                    begIndex = coveredChars.get(valAtIndex) + 1; // Start index of the new substring. The previous index +1 of the repeating character
                    if (endIndex < index) {
                        endIndex = index;
                    }
                } else {
                    endIndex = index; // update the end index to the current index
                }
                int newLength = endIndex - begIndex + 1;
                if (newLength > length) { // replace the value of length variable if this length is longer
                    length = newLength;
                }
                coveredChars.put(valAtIndex, index); // Add the current value to the map
            }
        }
        return length;
    }
}
