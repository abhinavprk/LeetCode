package lc1249MinimumRemovetToMakeValidParantheses;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    /*
    Space Complexity Analysis:

    The method utilizes two data structures:

    openIndex (List): O(n) - In the worst case (all opening parentheses), openIndex can hold up to n elements.
    closeIndex (List): O(n) - Similarly, in the worst case (all unmatched closing parentheses), closeIndex can reach a size of n.
    str (StringBuilder): O(n) - In the worst-case scenario (all parentheses removed), str will store the entire original string, resulting in a size of n.
    Since these data structures can potentially grow linearly with the input size n (string length), the space complexity of the method is:

    O(n)

    Time Complexity Analysis:

    The method employs two loops that iterate through the input string n times:

    First Loop: O(n) - This loop iterates over the string once, performing constant time operations like character checks and potential list manipulations on average.
    Second Loop: O(n) - Similar to the first loop, this iteration also examines the entire string once, involving constant time operations like character checks and string appending.
    As both loops contribute linear time complexity, the overall time complexity of the method is:

    O(n)
     */
    private static String minRemoveToMakeValid(String s) {
        List<Integer> openIndex = new ArrayList<>();
        List<Integer> closeIndex = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                openIndex.add(i);
            } else if (curr == ')') {
                if (openIndex.isEmpty()) {
                    closeIndex.add(i);
                } else {
                    openIndex.removeFirst();
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!(openIndex.contains(i) || closeIndex.contains(i))) {
                str.append(curr);
            }
        }

        return str.toString();
    }
}
