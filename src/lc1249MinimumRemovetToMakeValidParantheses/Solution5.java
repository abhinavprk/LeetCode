package lc1249MinimumRemovetToMakeValidParantheses;

public class Solution5 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    private static String minRemoveToMakeValid(String s) {

        // Pass 1: Remove all invalid ")"
        StringBuilder sb = new StringBuilder();
        int openSeen = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openSeen++;
                balance++;
            }
            if (c == ')') {
                if (balance == 0){
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        System.out.println("Abhinav " + sb);
        // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0){
                    continue;
                }
            }
            result.append(c);
        }
        System.out.println("Abhinav " + result);
        return result.toString();
    }
}
