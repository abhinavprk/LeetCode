package lc383RansomNote;

import java.util.HashMap;

public class Solution1 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        boolean possible = true;
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        HashMap<Character, Integer> ranCharCount = new HashMap<>();
        for (char val : ransom) {
            ranCharCount.put(val, ranCharCount.getOrDefault(val, 0) + 1);
        }
        HashMap<Character, Integer> magCharCount = new HashMap<>();
        for (char val : mag) {
            magCharCount.put(val, magCharCount.getOrDefault(val, 0) + 1);
        }

        for (char val : ranCharCount.keySet()) {
            int reqCount = ranCharCount.get(val);
            int availableCount = magCharCount.getOrDefault(val,0);
            if (availableCount < reqCount) {
                possible = false;
                break;
            }
        }
        return possible;
    }
}
