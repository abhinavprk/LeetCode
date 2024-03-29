package lc20ValidParentheses;

import java.util.Stack;

public class SecondSolution {

    public static void main(String[] args) {
        System.out.println(hasValidParentheses("{()}()[]{}"));
        System.out.println(hasValidParentheses("{"));
    }

    private static boolean hasValidParentheses(String inputString) {
        int length = inputString.length();

        if(length % 2 != 0) { //If length is not even, at least one parenthesis is missing
            return false;
        }
        Stack<Character> valStack = new Stack<>();
        for (int charIndex = 0; charIndex < inputString.length(); charIndex++){
            char val = inputString.charAt(charIndex);
            char complement = getComplement(val);
            if(complement != 1){ //If parenthesis of end type, pop the top out of the stack
               //At this point the stack should not be empty and should contain the complement parenthesis
                if(valStack.isEmpty() || valStack.pop() != complement){
                    return false;
                }
            } else { // Start type parenthesis should be pushed to stack
                valStack.push(val);
            }

        }
        //If after the loop completes, the stack is not empty, there are unmatched parentheses
        return valStack.isEmpty();
    }

    private static char getComplement(char input){
        return switch (input){
            case '}' -> '{';
            case ']' -> '[';
            case ')' -> '(';
            default -> 1 ;
        };
    }
}
