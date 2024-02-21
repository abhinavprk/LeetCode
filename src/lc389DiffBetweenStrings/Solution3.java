package lc389DiffBetweenStrings;

public class Solution3 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }


    private static char findTheDifference(String s, String t) {
        int result = 0;
        for (int val : t.toCharArray()) {
            result = result + val;
        }
        for (int val : s.toCharArray()) {
            result = result - val;
        }

        return (char)result;
    }
}
