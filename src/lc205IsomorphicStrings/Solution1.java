package lc205IsomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    /*
    Time Complexity: O(n)
    This method iterates through the strings s and t once in a for loop with a length of s.length().
    Inside the loop, there are constant time operations like accessing characters, checking for keys in maps,
    and adding/removing elements from sets.

    Therefore, the overall time complexity is dominated by the loop and is linear in the size of the input,
    resulting in O(n).

    Space Complexity: O(k)
    The space complexity depends on the number of unique characters in the strings, not the total length n.
    The method uses two data structures:

    HashMap<Character, Character> (charMap): This map stores the mapping between characters in s and t.
    In the worst case, all characters in s are unique, leading to a maximum of k (number of unique characters)
    entries in the map.
    HashSet<Character> (alreadyMapped): This set keeps track of characters already mapped in t. Similar
    to the map, it will have a maximum of k unique characters in the worst case.
    Since k is not directly related to the input size n (it can be smaller or even constant in some cases),
    the space complexity is considered O(k).

    Note: In some cases with a fixed character set (e.g., only lowercase alphabets), k becomes a constant,
    and the space complexity can be considered O(1). However, for general cases, it's better to use O(k) to represent the dependency on the number of unique characters.
     */
    private static boolean isIsomorphic(String s, String t) {
        boolean isomorphic = true;
        Map<Character, Character> charMap = new HashMap<>();
        Set<Character> alreadyMapped = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char currSChar = s.charAt(i);
            char currTChar = t.charAt(i);
            if (charMap.containsKey(currSChar)) {
                if (charMap.get(currSChar) != currTChar) {
                    isomorphic = false;
                    break;
                }
            } else {
                if (alreadyMapped.contains(currTChar)) {
                    isomorphic = false;
                } else {
                    charMap.put(currSChar, currTChar);
                    alreadyMapped.add(currTChar);
                }

            }
        }
        return isomorphic;
    }
}
