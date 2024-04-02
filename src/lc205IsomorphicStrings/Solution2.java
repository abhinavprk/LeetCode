package lc205IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    private static boolean isIsomorphic(String s, String t) {
        boolean isomorphic = true;
        Map<Character, Character> charSMapT = new HashMap<>();
        Map<Character, Character> charTMapS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currSChar = s.charAt(i);
            char currTChar = t.charAt(i);
            if (!charSMapT.containsKey(currSChar)
                    && !charTMapS.containsKey(currTChar)) {
                charSMapT.put(currSChar, currTChar);
                charTMapS.put(currTChar, currSChar);
            } else if (charTMapS.containsKey(currTChar) && charSMapT.containsKey(currSChar)) {
                if((charTMapS.get(currTChar) != currSChar) || (charSMapT.get(currSChar) != currTChar)){
                    isomorphic = false;
                }

            } else {
                isomorphic = false;
            }
        }
        return isomorphic;
    }
}
