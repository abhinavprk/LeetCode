package lc389DiffBetweenStrings;

public class Solution1 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }

    private static char findTheDifference(String s, String t) {
        int[] count = new int[27];
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            count[val - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            char val = t.charAt(i);
            count[val - 'a'] += 1;
        }

        for (int num = 0; num < 27; num++) {
            if (count[num] % 2 == 1) {
                result = (char)(num + 'a');
                break;
            }
        }
        return result;
    }
}
