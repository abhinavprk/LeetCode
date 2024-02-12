package lc125_valid_palindrome;

/**
 * Using recursion and regex
 */
public class FirstSolution {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("\\\"Sirrah! Deliver deified desserts detartrated!\\\" stressed deified, reviled Harris."));
    }

    private  static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindrome(s, 0, s.length()-1);
    }

    private static boolean isPalindrome(String string, int left, int right){
        if(left > right){
            return true;
        }
        if(string.charAt(left) != string.charAt(right)){
            return false;
        } else {
            return isPalindrome(string, ++left, --right);
        }
    }
}
