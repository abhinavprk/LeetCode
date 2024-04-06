package lc1249MinimumRemovetToMakeValidParantheses;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    private static String minRemoveToMakeValid(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        System.out.println("Abhinav " + result);
        result = removeInvalidClosing(result.reverse(), ')', '(');
        System.out.println("Abhinav " + result);
        return result.reverse().toString();
    }

    private static StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            }
            if (c == close) {
                if (balance == 0){
                    continue;
                }
                balance--;
            }
            sb.append(c);
        }
        return sb;
    }


}
