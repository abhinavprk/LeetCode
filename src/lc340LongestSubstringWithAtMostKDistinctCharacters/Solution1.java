package lc340LongestSubstringWithAtMostKDistinctCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

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

    Worst-case: O(n^2)

    The nested loops iterate over all possible substrings of the input string, leading to a quadratic time complexity in the worst case.
    This occurs when the string doesn't contain repeated characters and k is greater than or equal to the number of unique characters in the string.
    Best-case: O(n)

    If the string's length is less than or equal to k, or if the string has fewer unique characters than k, the method returns early, resulting in a linear time complexity.
    Space Complexity:

    O(n)
    The space used depends primarily on the allCharSet and subStrUniqChars sets, which can store up to n characters in the worst case.
    Other variables have constant space usage.
    Key Points:

    The method's time complexity is typically dominated by the nested loops in the worst-case scenario.
    The space complexity is linear due to the use of sets for character storage.
    In practice, the actual time complexity might be closer to O(n) if the string contains many repeated characters or if k is small.
     */
    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int subLength = 0;
        Set<Character> allCharSet = new HashSet<>();
        //Get the unique characters from the string
        for (char val : s.toCharArray()) {
            allCharSet.add(val);
        }
        //If length of the string is smaller or equal to k or,
        //If total number of unique chars in the string is less than or equal to k
        //The result will be the length of the string
        if ((s.length() <= k) || (allCharSet.size() <= k)) {
            subLength = s.length();
        } else {
            //Apply bruteforce
            for (int i = 0; i < s.length(); i++) {
                Set<Character> subStrUniqChars = new HashSet<>();
                int currSubLen;
                for (int j = i; j < s.length(); j++) {
                    char curr = s.charAt(j);
                    if (!subStrUniqChars.contains(curr)) {
                        subStrUniqChars.add(curr);
                        if (subStrUniqChars.size() > k) {
                            break;
                        }
                    }
                    currSubLen = j - i + 1;
                    subLength = Math.max(currSubLen, subLength);
                }
            }
        }
        return subLength;
    }
}
