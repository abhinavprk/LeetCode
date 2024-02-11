package lc1134_armstrong_number;
/**
 * What are Armstrong Numbers?
 * <p>
 * Armstrong Numbers are the numbers having the sum of digits raised to power no.
 * of digits is equal to a given number.
 * Examples- 0, 1, 153, 370, 371, 407, and 1634 are some of the Armstrong Numbers.
 * <p>
 * Example 1:
 * Input:153
 * Output: Yes, it is an Armstrong Number
 * Explanation: 1^3 + 5^3 + 3^3 = 153
 * <p>
 * Input:170
 * Output: No, it is not an Armstrong Number
 * Explanation: 1^3 + 7^3 + 0^3 != 170
 */
public class FirstSolution {
    public static void main(String[] args) {
        System.out.println(checkIfArmstrong(153));
        System.out.println(checkIfArmstrong(170));
    }

    private static boolean checkIfArmstrong(int input) {
        int number = input;
        int sum = 0;
        int length = (int) (Math.log10(input) + 1);
        while(number != 0){
            int digit = number % 10;
            number = number / 10;
            sum = sum + (int) Math.pow(digit, length);
        }
        System.out.println(sum);
        return sum == input;
    }
}
