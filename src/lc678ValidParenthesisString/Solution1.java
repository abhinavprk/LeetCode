package lc678ValidParenthesisString;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("())"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(**)))"));
        System.out.println(checkValidString("*"));
        System.out.println(checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }

    private static boolean checkValidString(String s) {
       int openCount = 0;
       int closeCount = 0;
       int len = s.length() - 1;

       for(int i = 0; i<= len; i++){
           if((s.charAt(i) == '(') || (s.charAt(i) == '*')){
               openCount++;
           }else {
               openCount--;
           }

           if((s.charAt(len-i) == ')') || (s.charAt(len-i) == '*')){
               closeCount++;
           }else {
               closeCount--;
           }
           if (openCount < 0 || closeCount < 0) {
               return false;
           }
       }
       return true;
    }

}
