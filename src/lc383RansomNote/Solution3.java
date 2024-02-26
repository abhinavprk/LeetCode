package lc383RansomNote;

public class Solution3 {

    public static void main(String[] args) {
        String ransomNote = "aaap";
        String magazine = "abba";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        boolean possible = true;
        for (char c : ransomNote.toCharArray()) {
            /* Find index of the char in magazine after the last index of char.
                If there is no further index present, the word cant be formed
                for example.
                in first iteration, index will be searched from 0th index in magazine, it is found on 0th index
                So the next time the same char will be searched from the index 1 onwards
                Next time a is found at index 3. The next search of a would be form index 4 onwards. This means
                the third a will not be found that i will be -1
             */
            int i = magazine.indexOf(c, alphabet[c -'a']);
            if (i == -1) {
                possible = false;
                break;
            }
            alphabet[c -'a'] = i + 1;
        }

        return possible;
    }
}
