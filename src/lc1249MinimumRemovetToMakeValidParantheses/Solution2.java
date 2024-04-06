package lc1249MinimumRemovetToMakeValidParantheses;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }
    /*
    Space Complexity:

    openIndices (Stack): O(n) - In the worst case (all opening parentheses), the stack can hold up to n indices.
    str (StringBuilder): O(n) - In the worst case (all parentheses removed), the StringBuilder might store the entire string, resulting in a size of n.
    Since these data structures can potentially grow linearly with the input string length n, the overall space complexity is:

    O(n)

    Time Complexity:

    First Loop: O(n) - Iterates through the string once, performing constant-time operations like character checks, stack operations (push, pop, peek), and potential string access (s.charAt(top)) on average.
    Second Loop: O(n) - Iterates through the string once more, performing constant-time operations like character checks and string appending.
    As both loops contribute linear time complexity, the overall time complexity of the method is:

    O(n)
    */

    private static String minRemoveToMakeValid(String s) {
        Stack<Integer> openIndices = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                openIndices.push(i);
            } else if (curr == ')') {
                if (openIndices.isEmpty()) {
                    openIndices.push(i);
                } else {
                    int top = openIndices.peek();
                    if (s.charAt(top) == '(') {
                        openIndices.pop();
                    } else {
                        openIndices.push(i);
                    }
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!openIndices.contains(i)) {
                str.append(curr);
            }
        }

        return str.toString();
    }
}
