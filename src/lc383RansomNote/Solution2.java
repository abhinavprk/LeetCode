package lc383RansomNote;

import java.util.HashMap;

public class Solution2 {

    public static void main(String[] args) {
        String ransomNote = "aap";
        String magazine = "abba";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        boolean possible = true;
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] magCharCount = new int[27];
        for (char val : mag) {
           magCharCount[val-'a'] += 1;
        }

        for (char val : ransom) {
            int available = magCharCount[val-'a'];
            if(available - 1 < 0){
                possible = false;
                break;
            }
            magCharCount[val-'a'] = available -1;

        }
        return possible;
    }
}
