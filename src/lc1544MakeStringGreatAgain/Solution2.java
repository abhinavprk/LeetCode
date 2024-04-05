package lc1544MakeStringGreatAgain;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
        System.out.println(makeGood(""));
    }
    private static String makeGood(String s) {
        // If we find a pair in 's', remove this pair from 's'
        // and solve the remaining string recursively.
        for (int i = 0; i < s.length() - 1; ++i) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32)
                return makeGood(s.substring(0, i) + s.substring(i + 2));
        }

        // Base case, if we can't find a pair, just return 's'.
        return s;
    }
}
