package lc1544MakeStringGreatAgain;

import java.util.Stack;

public class Solution3 {

    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("s"));
        System.out.println(makeGood(""));
    }

    /*
    Space Complexity

    The method uses a Stack to store characters during processing. In the worst case, when no adjacent characters differ by 32, the entire string will be added to the stack.
    The size of the stack is directly proportional to the length of the input string s.
    Therefore, the space complexity of the algorithm is O(n), where n is the length of the input string.
    Time Complexity

    The method iterates through the input string s once using a for loop. This loop contributes O(n) time complexity.
    Inside the loop, there are constant time operations like pushing/popping elements from the stack and character comparisons.
    Even though the StringBuilder operations happen outside the loop, their time complexity is also O(n) in the worst case, as iterating through the entire string and building a new string takes linear time.
    Overall, the time complexity of the algorithm is dominated by the linear operations and is O(n).
    In summary:

    Space complexity: O(n)
    Time complexity: O(n)
     */
    private static String makeGood(String s) {
        if (s.length() > 1) {
            Stack<Character> chars = new Stack<>();
            chars.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int currChar = s.charAt(i);
                if ((!chars.isEmpty()) && (Math.abs(chars.peek() - currChar) == 32)) {
                    chars.pop();
                } else {
                    chars.push((char) currChar);
                }
            }
            StringBuilder str = new StringBuilder();
            while (!chars.isEmpty()) {
                str.insert(0, chars.pop());
            }
            s = str.toString();
        }
        return s;
    }
}
