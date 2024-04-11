package lc791CustomSortString;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(customSortString("bcafg", "abcd"));
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("cba", "abcdb"));
    }

    /*
    Time Complexity:

    Overall: O(n + m), where n is the length of string s and m is the length of string order.
    Detailed:
    Counting character frequencies in sChar: O(n)
    Building the result string using order: O(m)
    Appending remaining characters from s: O(n) (in the worst case, all characters are in s but not in order)
    Space Complexity:

    O(1), constant space
    sChar array has a fixed size of 26, regardless of input string lengths.
    resultStrBuilder only holds the final string, which is at most the size of the input string s.
    Key points:

    The method avoids typical sorting algorithms, leading to better-than-linear time complexity.
    It effectively utilizes a fixed-size array and a string builder for efficient operations.
    It handles characters not present in order gracefully.
     */
    private static String customSortString(String order, String s) {
        int[] sChar = new int[26];
        for (char val : s.toCharArray()) {
            sChar[val - 'a'] = sChar[val - 'a'] + 1;
        }
        StringBuilder resultStrBuilder = new StringBuilder();
        for (char val : order.toCharArray()) {
            resultStrBuilder.repeat(val, sChar[val - 'a']);
        }
        for (char val : s.toCharArray()) {
            if (order.indexOf(val) == -1) {
                resultStrBuilder.append(val);
            }
        }
        return resultStrBuilder.toString();
    }
}
