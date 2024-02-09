package lc9_palindrome;

public class FirstSolution {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1421));
        System.out.println(isPalindrome(-1421));
    }

    private static boolean isPalindrome(int x) {
        String value = (Integer.valueOf(x)).toString();
        return value.equalsIgnoreCase(new StringBuffer(value).reverse().toString());
    }
}
