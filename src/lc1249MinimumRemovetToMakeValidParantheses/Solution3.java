package lc1249MinimumRemovetToMakeValidParantheses;

import java.util.*;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    private static String minRemoveToMakeValid(String s) {
        Set<Integer> closing = new HashSet<>();
        Deque<Integer> opening = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                opening.push(i);
            } if (s.charAt(i) == ')') {
                if (opening.isEmpty()) {
                    closing.add(i);
                } else {
                    opening.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!(closing.contains(i) || opening.contains(i))) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
