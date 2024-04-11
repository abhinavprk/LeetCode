package lc678ValidParenthesisString;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("())"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(**)))"));
        System.out.println(checkValidString("*"));
        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    private static boolean checkValidString(String s) {
        Stack<Integer> openBrackets = new Stack < > ();
        Stack<Integer> asterisks = new Stack < > ();

       for(int i = 0; i < s.length(); i++){
           if(s.charAt(i) == '('){
               openBrackets.push(i);
           }else if(s.charAt(i) == '*') {
               asterisks.push(i);
           } else {
               if((openBrackets.isEmpty() && asterisks.isEmpty())){
                   return false;
               } else if (!openBrackets.isEmpty()) {
                   openBrackets.pop();
               } else {
                   asterisks.pop();
               }
           }
       }

       while(!openBrackets.isEmpty() && !asterisks.isEmpty()){
           if(openBrackets.pop() > asterisks.pop()){
               return false;
           }
       }
       return openBrackets.isEmpty();
    }

}
