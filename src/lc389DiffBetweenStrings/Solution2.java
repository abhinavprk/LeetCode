package lc389DiffBetweenStrings;

public class Solution2 {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }

    /**
     *
     * @param s base String
     * @param t modified String
     * @return difference
     *
     * The bitwise XOR for same bits are 0. If we XOR all chars of two Strings, the result would be the
     * difference, because only the different char will not be in pair
     */

    private static char findTheDifference(String s, String t) {
        String comString = s + t;
        char result = 0;
        for (char i : comString.toCharArray()) {
            result = (char) (result ^ i);
        }
        return result;
    }
}
