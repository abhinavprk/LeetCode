package lc9_palindrome;

/**
 * Without converting the number to String
 */
public class SecondSolution {
    public static void main(String[] args) {
       // System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1421));
       // System.out.println(isPalindrome(-1421));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int reverseValue = 0;
            long tempValue = x;
            while (tempValue != 0) {
                int digit = (int) (tempValue % 10);
                reverseValue = reverseValue * 10 + digit;
                tempValue = tempValue / 10;
            }

            return (reverseValue == x);
        }
    }
}
