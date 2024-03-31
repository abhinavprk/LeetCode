package lc340LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(lengthOfLongestSubstringKDistinct("aaew", 5));
        System.out.println(lengthOfLongestSubstringKDistinct("", 1));
        System.out.println(lengthOfLongestSubstringKDistinct("aabacd", 5));
        System.out.println(lengthOfLongestSubstringKDistinct("a", 0));
    }

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int subLength;
        if (s.length() <= k) {
            subLength = s.length();
        } else {
            int left = k;
            int right = s.length();
            while (left < right) {
                int windowSizeToTest = (left + right + 1) / 2;
                boolean valid = isValidSubstring(s, windowSizeToTest, k);
                if (valid) {
                    left = windowSizeToTest;
                } else {
                    right = windowSizeToTest - 1;
                }
            }
            subLength = left;
        }
        return subLength;
    }

    private static boolean isValidSubstring(String s, int windowSize, int k) {
        boolean valid = false;
        int left = 0;
        int right = left + windowSize - 1;
        Map<Character, Integer> counter = new HashMap<>();
        while (left <= right) {
            char curr = s.charAt(left);
            counter.put(curr, counter.getOrDefault(curr, 0) + 1);
            left++;
        }
        left = 0;
        while (right < s.length()) {
            if (counter.size() <= k) {
                valid = true;
                break;
            } else {
                char currLeft = s.charAt(left);
                int currLeftFreq = counter.getOrDefault(currLeft, 0);
                if (currLeftFreq == 1) {
                    counter.remove(currLeft);
                } else {
                    counter.put(currLeft, counter.getOrDefault(currLeft, 0) - 1);
                }
                left++;
                right++;
                if (right < s.length()) {
                    char newRight = s.charAt(right);
                    counter.put(newRight, counter.getOrDefault(newRight, 0) + 1);
                }
            }
        }
        return valid;
    }
}
