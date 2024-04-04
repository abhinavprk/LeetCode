package lc1614MaximumNestingDepthOfTheParentheses;

import java.util.Stack;

public class Solution1 {

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(maxDepth("(1)+((2))+(((3)))"));
        System.out.println(maxDepth("12"));
        System.out.println(maxDepth(""));
        System.out.println(maxDepth("8*((1*(5+6))*(8/6))"));
    }

    private static int maxDepth(String s) {
        int maxDepth = 0;
        Stack<Character> stack = new Stack<>();
        for(char val : s.toCharArray()){
            if((val == '(')){
                stack.push(val);
            } else if ((val == ')')) {
                stack.pop();
            }
            maxDepth = Math.max(maxDepth, stack.size());
        }
        return maxDepth;
    }
}
