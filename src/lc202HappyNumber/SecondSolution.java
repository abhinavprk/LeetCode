package lc202HappyNumber;

/**
 * Uses Floyd's algorithm of fast and slow pointer
 * <a href="https://www.youtube.com/watch?v=LUm2ABqAs1w">Tortoise and Hare algorithm</a>
 */

public class SecondSolution {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(1));
    }

    private static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = sumOfSquareDigits(slow);
            fast = sumOfSquareDigits(sumOfSquareDigits(fast));
        }while (slow != fast);
        return slow == 1;
    }
    private static int sumOfSquareDigits(int number) {
        int sum = 0;
        int input = number;
        while (input != 0) {
            int digit = input % 10;
            sum = sum + digit * digit;
            input = input / 10;
        }
        return sum;
    }
}
